/*******************************************************************************
 * Copyright (c) 2011, 2014 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *      gonural - initial
 *      2014-09-01-2.6.0 Dmitry Kornilov
 *         - Moved to another package
 ******************************************************************************/
package org.eclipse.persistence.jpars.test.server.noversion;

import org.eclipse.persistence.jpars.test.BaseJparsTest;
import org.eclipse.persistence.jpars.test.model.traveler.Traveler;
import org.eclipse.persistence.jpars.test.util.RestUtils;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServerTravelerTest extends BaseJparsTest {

    @BeforeClass
    public static void setup() throws Exception {
        initContext("jpars_traveler-static", null);
    }

    @After
    public void cleanup() throws Exception {
        RestUtils.restUpdateQuery(context, "Traveler.deleteAll", "Traveler", null, null, MediaType.APPLICATION_JSON_TYPE);
    }

    /**
     * Test update travel reservation json.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUpdateTravelReservationJSON() throws Exception {
        updateTravelReservation(MediaType.APPLICATION_JSON_TYPE);
    }

    /**
     * Test update travel reservation xml.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUpdateTravelReservationXML() throws Exception {
        updateTravelReservation(MediaType.APPLICATION_XML_TYPE);
    }

    private void updateTravelReservation(MediaType mediaType) throws Exception {
        String traveler = null;
        if (mediaType == MediaType.APPLICATION_XML_TYPE) {
            traveler = RestUtils.getXMLMessage("traveler.xml");
        } else {
            traveler = RestUtils.getJSONMessage("traveler.json");
        }
        String response = RestUtils.restUpdate(context, traveler, Traveler.class.getSimpleName(), null, mediaType);
        assertNotNull(response);
        if (mediaType == MediaType.APPLICATION_XML_TYPE) {

            //<?xml version="1.0" encoding="UTF-8"?>
            //<ns0:traveler xmlns:ns0="http://example.org" xmlns:ns2="http://example.org/fname" xmlns:ns1="http://www.example.org/traveler">
            //   <ns2:firstName>Adrian</ns2:firstName>
            //   <ns1:id>19</ns1:id>
            //   <ns1:lastName>Clinton</ns1:lastName>
            //   <ns1:version>1</ns1:version>
            //   <_relationships>
            //      <_link href="http://localhost:8080/eclipselink.jpars.test/persistence/v1.0/jpars_traveler-static/entity/Traveler/19/reservation" rel="reservation" />
            //   </_relationships>
            //   <ns1:reservation>
            //      <_link href="http://localhost:8080/eclipselink.jpars.test/persistence/v1.0/jpars_traveler-static/entity/Reservation/20" method="GET" rel="self" />
            //   </ns1:reservation>
            //</ns0:traveler>

            assertTrue(response.contains(":traveler xmlns:"));
            assertTrue(response.contains("http://example.org\""));
            assertTrue(response.contains("http://example.org/fname\""));
            assertTrue(response.contains("http://www.example.org/traveler\""));
            assertTrue(response.contains(":firstName>Adrian"));
            assertTrue(response.contains(":lastName>Clinton"));
            assertTrue(response.contains(":id"));
            assertTrue(response.contains(":reservation>"));
        } else {
            assertTrue(response.contains("\"reservation\":"));
            assertTrue(response.contains("\"firstName\":\"Adrian\""));
            assertTrue(response.contains("\"lastName\":\"Clinton\""));
        }
    }
}
