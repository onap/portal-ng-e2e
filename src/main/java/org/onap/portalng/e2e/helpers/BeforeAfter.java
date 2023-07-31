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

package org.onap.portalng.e2e.helpers;

import io.cucumber.java.After;
import org.onap.portalng.e2e.steps.user_administration.UserAdministrationSteps;

public class BeforeAfter {

    @After("@delete_user")
    public void deleteUserAfterTest() {
        UserAdministrationSteps.deleteUser(UiSessionVariables.USERNAME.get());
    }
}
