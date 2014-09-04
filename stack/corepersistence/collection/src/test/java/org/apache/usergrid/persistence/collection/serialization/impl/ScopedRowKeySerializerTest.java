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

package org.apache.usergrid.persistence.collection.serialization.impl;


import java.nio.ByteBuffer;

import org.junit.Test;

import org.apache.usergrid.persistence.collection.CollectionScope;
import org.apache.usergrid.persistence.collection.impl.CollectionScopeImpl;
import org.apache.usergrid.persistence.core.astyanax.IdRowCompositeSerializer;
import org.apache.usergrid.persistence.core.astyanax.ScopedRowKey;
import org.apache.usergrid.persistence.model.entity.Id;
import org.apache.usergrid.persistence.model.entity.SimpleId;

import static org.junit.Assert.assertEquals;


/** @author tnine */
public class ScopedRowKeySerializerTest {

    @Test
    public void testSerialization() {

        final Id testId = new SimpleId( "scopeType" );
        final String name = "scopeName";
        final Id testKey = new SimpleId( "testKey" );

        final CollectionScope collectionScope = new CollectionScopeImpl(new SimpleId( "organization" ), testId, name );
        final ScopedRowKey<CollectionScope, Id>
                rowKey = new ScopedRowKey<CollectionScope, Id>( collectionScope, testKey );


        CollectionScopedRowKeySerializer<Id> collectionScopedRowKeySerializer = 
                new CollectionScopedRowKeySerializer<Id>( IdRowCompositeSerializer.get() );

        ByteBuffer buff = collectionScopedRowKeySerializer.toByteBuffer( rowKey );

        ScopedRowKey<CollectionScope, Id> parsedRowKey = collectionScopedRowKeySerializer.fromByteBuffer( buff );

        assertEquals("Row key serialized correctly", rowKey, parsedRowKey);

    }
}