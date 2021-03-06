/*
 * Copyright (C) 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.demo.jpa.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;

/**
 * Enum whose values are used for the "format" attribute of the testing entity type "Album."
 *
 * @author Jonathan Fuerth <jfuerth@gmail.com>
 */
@Portable
public enum Format {
    SINGLE, SP, EP, LP, DOUBLE_EP, DOUBLE_LP
}
