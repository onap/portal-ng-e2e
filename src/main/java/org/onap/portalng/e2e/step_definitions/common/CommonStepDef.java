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

package org.onap.portalng.e2e.step_definitions.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.onap.portalng.e2e.steps.common.CommonSteps;
import org.onap.portalng.e2e.types.Button;
import org.onap.portalng.e2e.types.Page;

public class CommonStepDef {

    @Given("User clicks on {} button in main menu")
    public void userClicksOnButtonInMainMenu(Button item) {
        CommonSteps.userClicksOnButtonInMainMenu(item);
    }
    @Given("User can see {}")
    public void userCanSeePage(Page page) {
        CommonSteps.userCanSeePage(page);
    }

    @Then("User should see error message with text {}")
    public void userClicksOnSubmitButtonAndErrorMessageIsDisplayed(String errorCode) {
        CommonSteps.userClicksOnSubmitButtonAndErrorMessageIsDisplayed(errorCode);
    }
}
