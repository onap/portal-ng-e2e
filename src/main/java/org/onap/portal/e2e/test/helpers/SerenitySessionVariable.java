/*
 *   Copyright (c) 2023. Deutsche Telekom AG
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *   SPDX-License-Identifier: Apache-2.0
 *
 */

package org.onap.portal.e2e.test.helpers;

import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface SerenitySessionVariable {

    Logger log = LoggerFactory.getLogger(SerenitySessionVariable.class);

    String name();
    default <T> T get() {
        final Optional<T> maybe = getOptional();
        if (!maybe.isPresent()) {
            throw new NoSuchElementException("No value present for: " + name());
        }
        return maybe.get();
    }

    default <T> Optional<T> getOptional() {
        final T value = Serenity.sessionVariableCalled(this);
        return Optional.ofNullable(value);
    }

    default <T> void set(T value) {
        log.info("Setting {} to {}", this, value);
        Serenity.setSessionVariable(this).to(value);
    }
}
