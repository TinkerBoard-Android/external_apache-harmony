/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * @author Aleksei Y. Semenov
 */

package org.apache.harmony.security.tests.java.security;

import java.security.*;
import org.apache.harmony.security.tests.support.IdentityScopeStub;

import junit.framework.TestCase;


/**
 * Tests for <code>IdentityScope</code>
 */

public class IdentityScopeTest extends TestCase {

    IdentityScope is;

    /**
     * Constructor for IdentityScopeTest.
     *
     * @param arg0
     */
    public IdentityScopeTest(String arg0) {
        super(arg0);
    }

    /**
     * Class under test for String toString()
     */
    public final void testToString() {
        assertNotNull(new IdentityScopeStub("Aleksei Semenov").toString());
    }

    /**
     * test default constructor void IdentityScope()
     */
    public final void testIdentityScope() {
        assertNotNull(new IdentityScopeStub());
    }

    /**
     * check that void IdentityScope(String) creates instance with given name
     */
    public final void testIdentityScopeString() {
        is = new IdentityScopeStub("Aleksei Semenov");
        assertNotNull(is);
        assertEquals("Aleksei Semenov", is.getName());
    }

    /**
     * check that void IdentityScope(String, IdentityScope) creates instance with given name and within given scope
     */
    public final void testIdentityScopeStringIdentityScope() throws Exception {
        IdentityScope scope = new IdentityScopeStub("my scope");
        is = new IdentityScopeStub("Aleksei Semenov", scope);
        assertNotNull(is);
        assertEquals("Aleksei Semenov", is.getName());
        assertEquals(scope.getName(), is.getScope().getName());
    }

    /**
     * just call IdentityScope.getSystemScope()
     */
    public final void testGetSystemScope() {
        String name = Security.getProperty("system.scope");
        assertNotNull(name);
        IdentityScope scope = IdentityScope.getSystemScope();
        assertNotNull(scope);
        assertEquals(name, scope.getClass().getName());
    }

    /**
     * Class under test for Identity getIdentity(Principal)
     */
    public final void testGetIdentityPrincipal() {
        is = new IdentityScopeStub("Aleksei Semenov");
        IdentityScope sc2 = new IdentityScopeStub("aaa");
        assertSame(is, is.getIdentity(sc2));
    }

}
