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

package org.onap.portalng.e2e.steps.user_administration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.onap.portalng.e2e.steps.main.MainSteps;
import org.onap.portalng.e2e.helpers.UiSessionVariables;
import org.onap.portalng.e2e.pages.PopUpDialogPage;
import org.onap.portalng.e2e.steps.common.CommonSteps;
import org.onap.portalng.e2e.steps.common.TableSteps;
import org.onap.portalng.e2e.types.Button;
import org.onap.portalng.e2e.types.UserRole;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Optional;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.onap.portalng.e2e.helpers.CommonUtils.checkPresenceOfElement;
import static org.onap.portalng.e2e.helpers.CommonUtils.checkTextOfElement;
import static org.onap.portalng.e2e.pages.PageWithTable.ROW_DELETE_BUTTON;
import static org.onap.portalng.e2e.pages.PopUpDialogPage.ALERT_SUCCESS;
import static org.onap.portalng.e2e.pages.PopUpDialogPage.*;
import static org.onap.portalng.e2e.pages.UserAdministrationPage.*;

public class UserAdministrationSteps {

    public static void userClicksOnCreateUserButton() {
        $(BUTTON_CREATE).shouldHave(Condition.text("Create User"));
        $(BUTTON_CREATE).click();
    }

    public static void userVerifiesCreateUserForm() {
        $(TITLE_H2).shouldHave(Condition.text("Create User"));

        $$(TITLE_H4).get(0).shouldHave(Condition.text("Set User Data"));
        $$(TITLE_H4).get(1).shouldHave(Condition.text("Set Roles"));

        $$(TITLE_H5).get(1).shouldHave(Condition.text("Available"));
        $$(TITLE_H5).get(2).shouldHave(Condition.text("Assigned"));

        $(LABEL_ID).shouldHave(Condition.text("ID"));
        $(LABEL_USERNAME).shouldHave(Condition.text("Username"));
        $(LABEL_EMAIL).shouldHave(Condition.text("Email"));
        $(LABEL_FIRST_NAME).shouldHave(Condition.text("First Name"));
        $(LABEL_LAST_NAME).shouldHave(Condition.text("Last Name"));

        $(INPUT_ID).shouldBe(Condition.disabled);
    }

    public static void userFillsDataNecessaryForCreatingTheUserInTheForm(String username) {
        $(INPUT_USERNAME).setValue(username);
        $(INPUT_EMAIL).setValue(username + "@test.user");
        $(INPUT_FIRST_NAME).setValue("E2E");
        $(INPUT_LAST_NAME).setValue("TestUser");
        UiSessionVariables.USERNAME.set(username);

        $$(FORM_CHECK).findBy(Condition.text("onap_admin")).$("input").click();
    }
    public static void userFillsSpecificValuesForUserCreation(String input, String value) {
        switch (input) {
            case "EMAIL":
                if (value.equals("clear")) {
                    $(INPUT_EMAIL).setValue(" ");
                    $(INPUT_EMAIL).sendKeys(Keys.BACK_SPACE);
                } else {
                    $(INPUT_EMAIL).setValue(" ");
                    $(INPUT_EMAIL).sendKeys(Keys.BACK_SPACE);
                    $(INPUT_EMAIL).setValue(value);
                }
                break;
            case "USERNAME":
                if (value.equals("clear")) {
                    $(INPUT_USERNAME).setValue(" ");
                    $(INPUT_USERNAME).sendKeys(Keys.BACK_SPACE);
                } else {
                    $(INPUT_USERNAME).setValue(value);
                }
                break;
            case "LAST_NAME":
                $(INPUT_LAST_NAME).setValue(value);
                break;
            case "FIRST_NAME":
                $(INPUT_FIRST_NAME).setValue(value);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }
    }

    public static void userClicksOnSaveButtonInTheForm() {
        $(BUTTON_SAVE).click();
    }

    public static void userClicksOnCancelButtonInTheForm() {
        $(BUTTON_CANCEL).click();
    }

    public static void userSeeFeedback(String invalidInput, String message) {
        switch (invalidInput) {
            case "REQUIRED_USERNAME":
                checkTextOfElement($(REQUIRED_USERNAME), message);
                checkPresenceOfElement($(INVALID_INPUT));
                break;
            case "REQUIRED_EMAIL":
                checkTextOfElement($(REQUIRED_EMAIL), message);
                checkPresenceOfElement($(INVALID_INPUT));
                break;
            case "INVALID_USERNAME":
                checkTextOfElement($(INVALID_USERNAME), message);
                checkPresenceOfElement($(INVALID_INPUT));
                break;
            case "INVALID_EMAIL":
                checkTextOfElement($(INVALID_EMAIL), message);
                checkPresenceOfElement($(INVALID_INPUT));
                break;
            case "WRONG_EMAIL_FORMAT":
                checkTextOfElement($(WRONG_EMAIL_FORMAT), message);
                checkPresenceOfElement($(INVALID_INPUT));
                break;
            default:
                throw new IllegalArgumentException(invalidInput + " is not implemented yet");

        }
    }


    public static void userVerifiesNewUserInUserList() throws InterruptedException {
        Selenide.Wait().until(ExpectedConditions.visibilityOf($$(TABLE_ROWS).get(0)));

        for (SelenideElement row : $$(TABLE_ROWS)) {
            if ($(row).findAll(By.id("td")).findBy(Condition.text("e2e-test-user")).exists()) {
                Assert.assertEquals("e2e-test-user", $(row).findAll(By.id("td")).get(0).getText());
                Assert.assertEquals("E2e", $(row).findAll(By.id("td")).get(1).getText());
                Assert.assertEquals("TestUser", $(row).findAll(By.id("td")).get(2).getText());
                Assert.assertEquals("e2e@test.user", $(row).findAll(By.id("td")).get(3).getText());
                Assert.assertEquals("onap_admin", $(row).findAll(By.id("td")).get(4).getText());
            }
        }
    }

    public static void deleteUser(String username) {
        MainSteps.userClicksOnUserMenuBtn();

        Optional<SelenideElement> userRow = TableSteps.findRowWithText(username, true);
        if (userRow.isPresent()) {
            assertThat(userRow.isPresent()).as("User cannot be deleted, user with " + username + " was not found.").isTrue();
            userRow.get().$(ROW_DELETE_BUTTON).click();
            $(DIALOG_HEADER).shouldHave(text("Delete User"));
            $(DIALOG_BODY).shouldHave(text("Are you sure, that you want to delete user: " + username + " ? "));
            $(DIALOG_APPLY_BUTTON).shouldHave(text("Delete"));
            $(DIALOG_APPLY_BUTTON).click();
            $$(ALERT_SUCCESS).last().shouldHave(text("User successfully deleted."));
            userRow.get().should(not(exist));
        }
    }

    public static void clickOnEditBtn(String username) {
        CommonSteps.userClicksOnButtonInMainMenu(Button.USERS);

        Optional<SelenideElement> userRow = TableSteps.findRowWithText(username, true);
        assertThat(userRow.isPresent()).as("User cannot be updated, user with " + username + " was not found.").isTrue();
        userRow.get().$(BUTTON_EDIT).click();
        userRow.get().should(not(exist));
    }

    public static void userCheckAllElementsOnEditPage() {
        checkTextOfElement($(TITLE_LBL), "Edit User");
        checkPresenceOfElement($(USER_DATA_HEADER));
        checkPresenceOfElement($(INPUT_ID));
        checkPresenceOfElement($(INPUT_USERNAME));
        checkPresenceOfElement($(INPUT_EMAIL));
        checkPresenceOfElement($(INPUT_FIRST_NAME));
        checkPresenceOfElement($(INPUT_LAST_NAME));
        checkTextOfElement($(LABEL_ID), "ID");
        checkTextOfElement($(LABEL_USERNAME), "Username");
        checkTextOfElement($(LABEL_EMAIL), "Email");
        checkTextOfElement($(LABEL_FIRST_NAME), "First Name");
        checkTextOfElement($(LABEL_LAST_NAME), "Last Name");
        checkPresenceOfElement($(ROLES_HEADER));
        checkTextOfElement($(AVAILABLE_ROLES), "Available");
        checkTextOfElement($(ASSIGNED_ROLES), "Assigned");
        checkTextOfElement($(ONAP_DESIGNER_ROLE), "onap_designer");
        checkTextOfElement($(ONAP_OPERATOR_ROLE), "onap_operator");
        checkTextOfElement($(ONAP_ADMIN_ROLE), "onap_admin");
        checkTextOfElement($(BUTTON_CANCEL), "Cancel");
        checkTextOfElement($(BUTTON_SAVE), "Save");
    }

    public static void userFillsValuesToEditFormPage() {
        $(INPUT_FIRST_NAME).setValue("firstName");
        $(INPUT_LAST_NAME).setValue("lastName");
        $(INPUT_EMAIL).setValue("e2e" + "@test.com");
    }

    public static void userClickOnBtnOnEditPage(String button) {
        switch (button) {
            case "Edit":
                $(BUTTON_SAVE).click();
                break;
            case "Cancel":
                $(BUTTON_CANCEL).click();
                break;
            default:
                throw new IllegalArgumentException("Button was not implemented");
        }
    }

    public static void userFillsEmailValuesForUserCreation(String email) {
        $(INPUT_EMAIL).clear();
        $(INPUT_EMAIL).setValue(email);
    }

    public static void userChecksPopupOnUserPage(String popUpType, String text) {
        if (popUpType.equals("SUCCESS")) {
            checkTextOfElement($(PopUpDialogPage.ALERT_SUCCESS), text);
        } else if (popUpType.equals("ERROR")) {
            checkTextOfElement($(PopUpDialogPage.ALERT_ERROR), text);
        }
    }

    public static void assignAvailableRolesToUser(UserRole userRole) {
        SelenideElement availableRolesBlock = $(AVAILABLE_ROLES_HEADER).parent();
        SelenideElement availableRole = availableRolesBlock.find(userRoleCheckBox(userRole));
        availableRole.click();
        availableRole.should(not(exist));
    }

    public static void unAssignRoleFromUser(UserRole userRole) {
        SelenideElement assignedRolesBlock = $(ASSIGNED_ROLES_HEADER).parent();
        SelenideElement assignedRole = assignedRolesBlock.find(userRoleCheckBox(userRole));
        assignedRole.click();
        assignedRole.should(not(exist));
    }

    public static void verifyThatUserRoleIsAvailable(UserRole userRole) {
        SelenideElement availableRolesBlock = $(AVAILABLE_ROLES_HEADER).parent();
        availableRolesBlock.find(userRoleCheckBox(userRole)).should(exist);
    }

    public static void verifyThatUserRoleIsAssigned(UserRole userRole) {
        SelenideElement assignedRolesBlock = $(ASSIGNED_ROLES_HEADER).parent();
        assignedRolesBlock.find(userRoleCheckBox(userRole)).should(exist);
    }

    public static By userRoleCheckBox(UserRole userRole) {
        switch (userRole) {
            case ONAP_DESIGNER:
                return roleCheckbox("onap_designer");
            case ONAP_OPERATOR:
                return roleCheckbox("onap_operator");
            case ONAP_ADMIN:
                return roleCheckbox("onap_admin");
            default:
                throw new IllegalArgumentException("Not recognized role");
        }
    }
}
