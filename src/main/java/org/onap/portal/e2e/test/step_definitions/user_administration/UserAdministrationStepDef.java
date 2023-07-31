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

package org.onap.portal.e2e.test.step_definitions.user_administration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.onap.portal.e2e.test.steps.main.MainSteps;
import org.onap.portal.e2e.test.steps.user_administration.UserAdministrationSteps;
import org.onap.portal.e2e.test.types.UserRole;

public class UserAdministrationStepDef {

    @And("User verifies Create User Form")
    public void userVerifiesCreateUserForm() {
        UserAdministrationSteps.userVerifiesCreateUserForm();
    }

    @And("User fills data necessary for creating the user with USERNAME value {} in the form")
    public void userFillsDataNecessaryForCreatingTheUserInTheForm(String username) {
        UserAdministrationSteps.userFillsDataNecessaryForCreatingTheUserInTheForm(username);
    }

    @When("User set parameter {} with value {} on User create or edit page")
    public void userFillsSpecificValuesForUserCreation(String input, String username) {
        UserAdministrationSteps.userFillsSpecificValuesForUserCreation(input, username);
    }

    @And("User clicks on Save button in the form")
    public void userClicksOnSaveButtonInTheForm() {
        UserAdministrationSteps.userClicksOnSaveButtonInTheForm();
    }

    @And("User clicks on Cancel button in the form")
    public void userClicksOnCancelButtonInTheForm() {
        UserAdministrationSteps.userClicksOnCancelButtonInTheForm();
    }


    @And("User should see {} feedback {}")
    public void userSeeFeedback(String invalidInput, String message) {
        UserAdministrationSteps.userSeeFeedback(invalidInput, message);
    }

    @Then("User verifies newly created User in the User List")
    public void userVerifiesNewUserInUserList() throws InterruptedException {
        UserAdministrationSteps.userVerifiesNewUserInUserList();
    }

    @And("User with USERNAME value {} is created")
    public void userIsCreated(String username) {
        MainSteps.userClicksOnUserMenuBtn();
        UserAdministrationSteps.userClicksOnCreateUserButton();
        UserAdministrationSteps.userVerifiesCreateUserForm();
        UserAdministrationSteps.userFillsDataNecessaryForCreatingTheUserInTheForm(username);
        UserAdministrationSteps.userClicksOnSaveButtonInTheForm();
//        UserAdministrationSteps.userVerifiesNewUserInUserList();
    }

    @Then("User with USERNAME {} is successfully deleted")
    public void deleteUser(String username) {
        UserAdministrationSteps.deleteUser(username);
    }

    @Given("User clicks on EDIT button for user with USERNAME {} on Users page")
    public void userClickOnBtnForUser(String username) {
        UserAdministrationSteps.clickOnEditBtn(username);
    }

    @Given("User checks presence of elements on User edit page")
    public void userCheckAllElementsOnUpdatePage() {
        UserAdministrationSteps.userCheckAllElementsOnEditPage();
    }

    @Given("User fills all possible values to User edit page")
    public void userFillsValuesToEditFormPage() {
        UserAdministrationSteps.userFillsValuesToEditFormPage();
    }

    @Given("User clicks on {} button for user on User edit page")
    public void userClickOnBtnOnEditPage(String button) {
        UserAdministrationSteps.userClickOnBtnOnEditPage(button);
    }

    @When("User fills EMAIL {} in User edit page")
    public void userFillsEmailValuesForUserCreation(String email) {
        UserAdministrationSteps.userFillsEmailValuesForUserCreation(email);
    }

    @Given("User checks {} pop-up on user page with text {}")
    public void userChecksPopupOnUserPage(String popUpType, String text) {
        UserAdministrationSteps.userChecksPopupOnUserPage(popUpType, text);
    }

    @When("User clicks on {} available role checkbox")
    public void assignAvailableRolesToUser(UserRole userRole) {
        UserAdministrationSteps.assignAvailableRolesToUser(userRole);
    }

    @When("{} role is assigned to user")
    public void selectedRoleIsAssignedToUser(UserRole userRole) {
        UserAdministrationSteps.verifyThatUserRoleIsAssigned(userRole);
    }

    @When("User clicks on {} assigned role checkbox")
    public void unAssignRolesToUser(UserRole userRole) {
        UserAdministrationSteps.unAssignRoleFromUser(userRole);
    }

    @When("{} role is unassigned from user")
    public void selectedRoleIsUnassignedFromUser(UserRole userRole) {
        UserAdministrationSteps.verifyThatUserRoleIsAvailable(userRole);
    }
}
