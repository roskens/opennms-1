/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2008-2014 The OpenNMS Group, Inc.
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

package org.opennms.opennmsd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

public class FilterTest {
    
    Filter m_filter;
    NNMEvent m_event;
    
    @Before
    public void setUp() {
        m_filter = new Filter();
        m_event = MockNNMEvent.createEvent("Category", "Severity", "name", "1.1.1.1");
        
    }
    
    @Test
    public void testMatchCategory() {
        m_filter.setCategoryMatcher("^.*Category$");
        assertFilterMatches();
    }
    
    @Test
    public void testMatchCategoryPartial() {
        m_filter.setCategoryMatcher("gor");
        assertFilterMatches();
    }
    
    @Test
    public void testMismatchCategory() {
        m_filter.setCategoryMatcher("nomatch");
        assertFilterDoesntMatch();
    }

    @Test
    public void testMatchSeverity() {
        m_filter.setSeverityMatcher("ever");
        assertFilterMatches();
    }

    @Test
    public void testMismatchSeverity() {
        m_filter.setSeverityMatcher("nomatch");
        assertFilterDoesntMatch();
    }

    @Test
    public void testMatchName() {
        m_filter.setEventNameMatcher("am");
        assertFilterMatches();
    }

    @Test
    public void testMismatchName() {
        m_filter.setEventNameMatcher("nomatch");
        assertFilterDoesntMatch();
    }

    @Test
    public void testMatchAddress() {
        m_filter.setAddressMatchSpec("1.1-3.*.1,3");
        assertFilterMatches();
    }

    @Test
    public void testMismatchAddress() {
        m_filter.setAddressMatchSpec("192.168.*.*");
        assertFilterDoesntMatch();
    }
    
    @Test
    public void testCategoryAndAddress() {
        m_filter.setCategoryMatcher("ategory");
        m_filter.setAddressMatchSpec("1.*.*.*");
        
        assertFilterMatches();
    }

    @Test
    public void testCategoryButNotAddress() {
        m_filter.setCategoryMatcher("ategory");
        m_filter.setAddressMatchSpec("192.*.*.*");
        
        assertFilterDoesntMatch();
    }

    private void assertFilterMatches() {
        assertTrue("Expected filter to match: "+m_filter, m_filter.matches(m_event));
    }

    private void assertFilterDoesntMatch() {
        assertFalse("Expected filter NOT to match: "+m_filter, m_filter.matches(m_event));
    }

}
