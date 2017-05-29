/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2011-2017 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2017 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.poller.monitors;

import static org.junit.Assert.assertEquals;
import static org.opennms.netmgt.poller.monitors.DNSResolutionMonitor.PARM_NAMESERVER;
import static org.opennms.netmgt.poller.monitors.DNSResolutionMonitor.PARM_RESOLUTION_TYPE;
import static org.opennms.netmgt.poller.monitors.DNSResolutionMonitor.PARM_RESOLUTION_TYPE_BOTH;
import static org.opennms.netmgt.poller.monitors.DNSResolutionMonitor.PARM_RESOLUTION_TYPE_EITHER;
import static org.opennms.netmgt.poller.monitors.DNSResolutionMonitor.PARM_RESOLUTION_TYPE_V4;
import static org.opennms.netmgt.poller.monitors.DNSResolutionMonitor.PARM_RESOLUTION_TYPE_V6;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.core.test.MockLogAppender;
import org.opennms.core.test.OpenNMSJUnit4ClassRunner;
import org.opennms.core.test.dns.annotations.DNSEntry;
import org.opennms.core.test.dns.annotations.DNSZone;
import org.opennms.core.test.dns.annotations.JUnitDNSServer;
import org.opennms.netmgt.poller.PollStatus;
import org.opennms.netmgt.poller.mock.MockMonitoredService;
import org.opennms.test.JUnitConfigurationEnvironment;
import org.springframework.test.context.ContextConfiguration;

/**
 * DNSResolutionMonitorTest
 *
 * @author brozow
 */
@RunWith(OpenNMSJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/opennms/emptyContext.xml"})
@JUnitDNSServer(port = 9153, zones = {
    @DNSZone(name = "example.com", entries = {
        @DNSEntry(hostname = "test", data = "192.168.0.1")
    })
    ,

    @DNSZone(name = "opennms.org", entries = {
        @DNSEntry(hostname = "wipv6day", data = "192.168.0.2")
        ,
        @DNSEntry(hostname = "wipv6day", data = "fded:beef:cafe:1::63", type = "AAAA")
        ,
        @DNSEntry(hostname = "choopa-ipv4", data = "192.168.0.3")
        ,
        @DNSEntry(hostname = "choopa-ipv6", data = "fded:beef:cafe:1::64", type = "AAAA")
        ,
        @DNSEntry(hostname = "www", data = "web02.opennms.org.", type = "CNAME")
        ,
        @DNSEntry(hostname = "web02", data = "192.168.0.4", type = "A")
        ,
        @DNSEntry(hostname = "web02", data = "fded:beef:cafe:1::65", type = "AAAA"),})
})
@JUnitConfigurationEnvironment
public class DNSResolutionMonitorTest {

    @Before
    public void setUp() {
        MockLogAppender.setupLogging(true);
    }

    @Test
    public void testPoll() throws Exception {
        MockMonitoredService dual = new MockMonitoredService(1, "wipv6day.opennms.org", InetAddress.getLocalHost(), "RESOLVE");
        MockMonitoredService v4only = new MockMonitoredService(1, "choopa-ipv4.opennms.org", InetAddress.getLocalHost(), "RESOLVE");
        MockMonitoredService v6only = new MockMonitoredService(1, "choopa-ipv6.opennms.org", InetAddress.getLocalHost(), "RESOLVE");
        MockMonitoredService neither = new MockMonitoredService(1, "no-such-name.example.com", InetAddress.getLocalHost(), "RESOLVE");

        DNSResolutionMonitor monitor = new DNSResolutionMonitor();

        Map<String, Object> v4Parms = new HashMap<>();
        v4Parms.put(PARM_RESOLUTION_TYPE, PARM_RESOLUTION_TYPE_V4);
        v4Parms.put(PARM_NAMESERVER, "[::1]:9153");
        Map<String, Object> v6Parms = new HashMap<>();
        v6Parms.put(PARM_RESOLUTION_TYPE, PARM_RESOLUTION_TYPE_V6);
        v6Parms.put(PARM_NAMESERVER, "[::1]:9153");
        Map<String, Object> bothParms = new HashMap<>();
        bothParms.put(PARM_RESOLUTION_TYPE, PARM_RESOLUTION_TYPE_BOTH);
        bothParms.put(PARM_NAMESERVER, "[::1]:9153");
        Map<String, Object> eitherParms = new HashMap<>();
        eitherParms.put(PARM_RESOLUTION_TYPE, PARM_RESOLUTION_TYPE_EITHER);
        eitherParms.put(PARM_NAMESERVER, "[::1]:9153");

        assertEquals(PollStatus.available(), monitor.poll(dual, v4Parms));
        assertEquals(PollStatus.available(), monitor.poll(dual, v6Parms));
        assertEquals(PollStatus.available(), monitor.poll(dual, bothParms));
        assertEquals(PollStatus.available(), monitor.poll(dual, eitherParms));

        assertEquals(PollStatus.available(),   monitor.poll(v4only, v4Parms));
        assertEquals(PollStatus.unavailable(), monitor.poll(v4only, v6Parms));
        assertEquals(PollStatus.unavailable(), monitor.poll(v4only, bothParms));
        assertEquals(PollStatus.available(),   monitor.poll(v4only, eitherParms));

        assertEquals(PollStatus.unavailable(), monitor.poll(v6only, v4Parms));
        assertEquals(PollStatus.available(),   monitor.poll(v6only, v6Parms));
        assertEquals(PollStatus.unavailable(), monitor.poll(v6only, bothParms));
        assertEquals(PollStatus.available(),   monitor.poll(v6only, eitherParms));

        assertEquals(PollStatus.unavailable(), monitor.poll(neither, v4Parms));
        assertEquals(PollStatus.unavailable(), monitor.poll(neither, v6Parms));
        assertEquals(PollStatus.unavailable(), monitor.poll(neither, bothParms));
        assertEquals(PollStatus.unavailable(), monitor.poll(neither, eitherParms));

    }

}
