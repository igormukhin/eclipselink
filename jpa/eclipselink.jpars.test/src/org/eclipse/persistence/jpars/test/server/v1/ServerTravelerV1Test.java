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
package org.eclipse.persistence.jpars.test.server.v1;

import org.eclipse.persistence.jpars.test.server.noversion.ServerTravelerTest;
import org.junit.BeforeClass;

/**
 * ServerTravelerNoVersionTest adapted for JPARS 1.0.
 * {@see ServerTravelerNoVersionTest}
 *
 * @author Dmitry Kornilov
 * @since EclipseLink 2.6.0
 */
public class ServerTravelerV1Test extends ServerTravelerTest {

    @BeforeClass
    public static void setup() throws Exception {
        initContext("jpars_traveler-static", "v1.0");
    }
}
