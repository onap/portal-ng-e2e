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

package org.onap.portal.e2e.test.step_definitions.main;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.onap.portal.e2e.test.steps.common.CommonSteps;
import org.onap.portal.e2e.test.steps.main.MainSteps;
import org.onap.portal.e2e.test.steps.user_administration.UserAdministrationSteps;
import org.onap.portal.e2e.test.types.Page;

public class MainStepDef {

    @Given("User opens the Portal page")
    public void userVisitsTheIndexPage() {
        MainSteps.userVisitsTheIndexPage();
    }

    @Given("User visits the {} page")
    public void userVisitsTheUsersPage(Page page) {
        MainSteps.userClicksOnUserMenuBtn();
        CommonSteps.userCanSeePage(page);
    }

    @When("User clicks on Create User button")
    public void userClicksOnCreateUserButton() {
        UserAdministrationSteps.userClicksOnCreateUserButton();
    }
}
