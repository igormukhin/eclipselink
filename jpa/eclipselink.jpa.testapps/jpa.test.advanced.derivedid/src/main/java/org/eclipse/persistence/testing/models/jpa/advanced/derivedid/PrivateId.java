/*
 * Copyright (c) 1998, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     04/24/2009-2.0 Guy Pelletier
//       - 270011: JPA 2.0 MappedById support
package org.eclipse.persistence.testing.models.jpa.advanced.derivedid;

import jakarta.persistence.Embeddable;

@Embeddable
public class PrivateId {
    String name;
    CorporalId corporalPK;

    public String getName() {
        return name;
    }

    public CorporalId getCorporalPK() {
        return corporalPK;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCorporalPK(CorporalId corporalPK) {
        this.corporalPK = corporalPK;
    }
}
