/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
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

package org.elasticsearch.index.field.function;

import org.apache.lucene.index.IndexReader;

import java.util.Map;

/**
 * @author kimchy (shay.banon)
 */
public interface FieldsFunction {

    void setNextReader(IndexReader reader);

    /**
     * @param docId The doc id
     * @param vars  The vars providing additional parameters, should be reused and has values added to it in execute
     */
    Object execute(int docId, Map<String, Object> vars);

    /**
     * @param docId        The doc id
     * @param vars         The vars providing additional parameters, should be reused and has values added to it in execute
     * @param sameDocCache If executing against the same doc id several times (possibly with different scripts), pass this across the invocations
     */
    Object execute(int docId, Map<String, Object> vars, Map<String, Object> sameDocCache);
}
