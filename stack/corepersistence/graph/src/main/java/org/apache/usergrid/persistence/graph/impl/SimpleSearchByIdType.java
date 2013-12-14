/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.usergrid.persistence.graph.impl;


import java.util.UUID;

import org.apache.usergrid.persistence.collection.mvcc.entity.ValidationUtils;
import org.apache.usergrid.persistence.graph.Edge;
import org.apache.usergrid.persistence.graph.SearchByEdgeType;
import org.apache.usergrid.persistence.graph.SearchByIdType;
import org.apache.usergrid.persistence.model.entity.Id;


/**
 *
 *
 */
public class SimpleSearchByIdType extends SimpleSearchByEdgeType implements SearchByIdType{

    private final String idType;

    /**
     * Create the search modules
     *
     * @param node The node to search from
     * @param type The edge type
     * @param maxVersion The maximum version to return
     * @param idType The id type on the edge
     * @param last The value to start seeking from.  Must be >= this value

     */
    public SimpleSearchByIdType( final Id node, final String type, final UUID maxVersion, final String idType, final Edge last  ) {
        super( node, type, maxVersion, last );
        this.idType = idType;
    }


    @Override
    public String getIdType() {
        return idType;
    }
}
