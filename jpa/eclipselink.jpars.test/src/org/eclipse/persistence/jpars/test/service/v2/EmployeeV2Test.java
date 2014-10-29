/*******************************************************************************
 * Copyright (c) 2014 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *      Dmitry Kornilov - Initial implementation
 ******************************************************************************/
package org.eclipse.persistence.jpars.test.service.v2;

import org.eclipse.persistence.jpars.test.service.noversion.EmployeeTest;
import org.junit.BeforeClass;

/**
 * EmployeeTest adapted for JPARS 2.0.
 * {@see EmployeeTest}
 *
 * @author Dmitry Kornilov
 * @since EclipseLink 2.6.0
 */
public class EmployeeV2Test extends EmployeeTest {

    @BeforeClass
    public static void setup() throws Exception {
        initContext("jpars_employee-static", "v2.0");
    }
}
