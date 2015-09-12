/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2013-2014 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2014 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.config.vacuumd;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;
import org.opennms.core.test.xml.XmlTest;

public class VacuumdConfigurationTest extends
        XmlTest<VacuumdConfiguration> {

    public VacuumdConfigurationTest(final VacuumdConfiguration sampleObject,
            final String sampleXml, final String schemaFile) {
        super(sampleObject, sampleXml, schemaFile);
    }

    @Parameters
    public static Collection<Object[]> data() throws ParseException {
        // Simplest config
        VacuumdConfiguration minimalistVacuumdConfig = new VacuumdConfiguration();
        minimalistVacuumdConfig.setPeriod(1);

        // A config with every option set
        VacuumdConfiguration vacuumdConfig;
        List<Statement> statements = new ArrayList<Statement>();
        Statement statement = new Statement(
                                            "INSERT 1000000 INTO bankaccount;",
                                            false);
        statements.add(statement);

        Automations automations = new Automations();
        Automation automation = new Automation("testAutomation", 3000,
                                               "testTrigger", "testAction",
                                               "testAutoEvent",
                                               "testActionEvent", false);
        automations.addAutomation(automation);

        Triggers triggers = new Triggers();
        Trigger trigger = new Trigger("testTrigger", "testDataSource", ">=",
                                      0, statement);
        triggers.addTrigger(trigger);

        Actions actions = new Actions();
        Action action = new Action("testTrigger", "testDataSource", statement);
        actions.addAction(action);

        AutoEvents autoEvents = new AutoEvents();
        AutoEvent autoEvent = new AutoEvent("testAutoEvent", "testField",
                                            new Uei("testUei"));
        autoEvents.addAutoEvent(autoEvent);

        List<Assignment> assignments = new ArrayList<Assignment>();
        Assignment assignment = new Assignment("field", "uei", "testUei");
        assignments.add(assignment);

        ActionEvents actionEvents = new ActionEvents();
        ActionEvent actionEvent = new ActionEvent("testActionEvent", true,
                                                  true, assignments);
        actionEvents.addActionEvent(actionEvent);

        vacuumdConfig = new VacuumdConfiguration(1, statements, automations,
                                                 triggers, actions,
                                                 autoEvents, actionEvents);

        return Arrays.asList(new Object[][] {
                {
                        minimalistVacuumdConfig,
                        "<VacuumdConfiguration period=\"1\">"
                                + "<automations/>" + "<triggers/>"
                                + "<actions/>" + "<auto-events/>"
                                + "<action-events/>"
                                + "</VacuumdConfiguration>",
                        "target/classes/xsds/vacuumd-configuration.xsd" },
                {
                        vacuumdConfig,
                        "<VacuumdConfiguration period=\"1\">"
                                + "<statement transactional=\"false\">INSERT 1000000 INTO bankaccount;</statement>"
                                + "<automations>"
                                + "    <automation name=\"testAutomation\" interval=\"3000\""
                                + " trigger-name=\"testTrigger\" action-name=\"testAction\""
                                + " auto-event-name=\"testAutoEvent\" action-event=\"testActionEvent\" active=\"false\"/>"
                                + "</automations>"
                                + "<triggers>"
                                + "    <trigger name=\"testTrigger\" data-source=\"testDataSource\" operator=\"&gt;=\" row-count=\"0\">"
                                + "        <statement transactional=\"false\">INSERT 1000000 INTO bankaccount;</statement>"
                                + "    </trigger>"
                                + "</triggers>"
                                + "<actions>"
                                + "    <action name=\"testTrigger\" data-source=\"testDataSource\">"
                                + "        <statement transactional=\"false\">INSERT 1000000 INTO bankaccount;</statement>"
                                + "    </action>"
                                + "</actions>"
                                + "<auto-events>"
                                + "    <auto-event name=\"testAutoEvent\" fields=\"testField\">"
                                + "        <uei>testUei</uei>"
                                + "    </auto-event>"
                                + "</auto-events>"
                                + "<action-events>"
                                + "    <action-event name=\"testActionEvent\" for-each-result=\"true\" add-all-parms=\"true\">"
                                + "        <assignment type=\"field\" name=\"uei\" value=\"testUei\"/>"
                                + "    </action-event>" + "</action-events>"
                                + "</VacuumdConfiguration>",
                        "target/classes/xsds/vacuumd-configuration.xsd" } });
    }
}
