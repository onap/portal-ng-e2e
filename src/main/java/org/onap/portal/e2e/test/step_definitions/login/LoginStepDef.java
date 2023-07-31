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

package org.onap.portal.e2e.test.step_definitions.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.onap.portal.e2e.test.steps.login.LoginSteps;
import org.onap.portal.e2e.test.steps.main.MainSteps;

public class LoginStepDef {
    @And("User verifies presence of all elements on Sign In form")
    public void verifySignInForm() {
        LoginSteps.verifySignInForm();
    }

    @When("User fills log in form with USERNAME value {string} and PASSWORD value {string}")
    public void fillFormWithUsernameAndPasswordValues(String username, String password) {
        LoginSteps.fillFormWithUsernameAndPasswordValues(username, password);
    }

    @Then("User submits credentials with Sign In button")
    public void submitCredentialsForLoginBySignInButton() {
        LoginSteps.submitCredentialsForLoginBySignInButton();
    }

    @And("User checks if is signed in to the Portal")
    public void userChecksIfSignedInToThePortal(){
        LoginSteps.userChecksIfSignedInToThePortal();
    }

    @And("User clicks on Logout button to log out from the Portal")
    public void userClicksOnLogoutButton(){
        LoginSteps.userClicksOnLogoutButton();
    }

    @Then("User sees error message {string} after incorrect credentials input")
    public void errorIsShownAfterWrongCredentialsInput(String errorMsg) {
        LoginSteps.errorIsShownAfterWrongCredentialsInput(errorMsg);
    }

    @And("User is logged in Portal as ADMIN")
    public void userIsLoggedInPortalAsAdmin() {
        MainSteps.userVisitsTheIndexPage();
        LoginSteps.fillFormWithUsernameAndPasswordValues("onap-admin", "password");
        LoginSteps.submitCredentialsForLoginBySignInButton();
    }
}
