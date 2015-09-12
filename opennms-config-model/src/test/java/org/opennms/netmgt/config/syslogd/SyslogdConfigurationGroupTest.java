/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2015 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2015 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.config.syslogd;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;
import org.opennms.core.test.xml.XmlTestNoCastor;

public class SyslogdConfigurationGroupTest extends XmlTestNoCastor<SyslogdConfigurationGroup> {

    public SyslogdConfigurationGroupTest(final SyslogdConfigurationGroup sampleObject, final String sampleXml, final String schemaFile) {
        super(sampleObject, sampleXml, schemaFile);
    }

    @Parameters
    public static Collection<Object[]> data() throws ParseException {

        SyslogdConfigurationGroup group = new SyslogdConfigurationGroup();
        UeiList ueiList = new UeiList();
        group.setUeiList(ueiList);
        UeiMatch ueiMatch = new UeiMatch();
        ueiList.addUeiMatch(ueiMatch);
        ProcessMatch processMatch = new ProcessMatch();
        ueiMatch.setProcessMatch(processMatch);
        processMatch.setExpression("^procmail$");
        Match match = new Match();
        ueiMatch.setMatch(match);
        match.setType("regex");
        match.setExpression("^.*?Suspicious rcfile \"(.*?)\"$");
        ueiMatch.setUei("uei.opennms.org/vendor/procmail/syslog/procmail/suspiciousRcfile");
        ParameterAssignment paramAssignment = new ParameterAssignment();
        ueiMatch.addParameterAssignment(paramAssignment);
        paramAssignment.setMatchingGroup(1);
        paramAssignment.setParameterName("rcfile");

        return Arrays.asList(new Object[][]{{
            group,
            "<syslogd-configuration-group>\n"
            + "    <ueiList>\n"
            + "        <ueiMatch>\n"
            + "            <process-match expression=\"^procmail$\"/>\n"
            + "            <match type=\"regex\" expression=\"^.*?Suspicious rcfile &quot;(.*?)&quot;$\"/>\n"
            + "            <uei>uei.opennms.org/vendor/procmail/syslog/procmail/suspiciousRcfile</uei>\n"
            + "            <parameter-assignment matching-group=\"1\" parameter-name=\"rcfile\"/>\n"
            + "        </ueiMatch>\n"
            + "    </ueiList>\n"
            + "</syslogd-configuration-group>",
            "target/classes/xsds/syslogd-configuration.xsd",},});
    }
}