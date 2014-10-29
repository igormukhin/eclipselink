/****************************************************************************
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
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
package org.eclipse.persistence.jpars.test;

import org.eclipse.persistence.jpars.test.service.latest.ContextsLatestTest;
import org.eclipse.persistence.jpars.test.service.latest.EmployeeLatestTest;
import org.eclipse.persistence.jpars.test.service.latest.LinksLatestTest;
import org.eclipse.persistence.jpars.test.service.latest.MarshalUnmarshalLatestTest;
import org.eclipse.persistence.jpars.test.service.latest.MetadataLatestTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        MetadataLatestTest.class,
        MarshalUnmarshalLatestTest.class,
        EmployeeLatestTest.class,
        LinksLatestTest.class,
        ContextsLatestTest.class
})
public class ServiceLatestTests {

}
