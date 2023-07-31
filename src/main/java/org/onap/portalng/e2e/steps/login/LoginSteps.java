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

package org.onap.portalng.e2e.steps.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.onap.portalng.e2e.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    public static void verifySignInForm() {
        Selenide.$(LoginPage.USERNAME_LBL).shouldHave(text("Username or email"));
        Selenide.$(LoginPage.PASSWORD_LBL).shouldHave(Condition.text("Password"));
        Selenide.$(LoginPage.SIGN_IN_BTN).shouldHave(Condition.value("Sign In"));
    }

    public static void fillFormWithUsernameAndPasswordValues(String username, String password) {
        Selenide.$(LoginPage.USERNAME_INPUT).setValue(username);
        Selenide.$(LoginPage.PASSWORD_INPUT).setValue(password);
    }

    public static void submitCredentialsForLoginBySignInButton() {
        Selenide.$(LoginPage.SIGN_IN_BTN).click();
    }

    public static void userChecksIfSignedInToThePortal(){
        Selenide.$(LoginPage.CURRENT_PAGE_SPAN).shouldHave(text("Dashboard"));
        Selenide.$(LoginPage.CURRENT_PAGE_HEADING_TITLE).shouldHave(text("Dashboard"));
    }

    public static void userClicksOnLogoutButton(){
        Selenide.$(LoginPage.DROPDOWN_MENU).click();
        Selenide.$(LoginPage.LOGOUT_BUTTON).click();
    }

    public static void errorIsShownAfterWrongCredentialsInput(String errorMsg) {
        assertThat(Selenide.$(LoginPage.INPUT_ERROR_SPAN).getText())
                .describedAs("Text is not as expected")
                .isEqualTo(errorMsg);
    }
}
