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

package org.onap.portalng.e2e.steps.common;

import com.codeborne.selenide.Condition;
import org.onap.portalng.e2e.types.Button;
import org.onap.portalng.e2e.types.Page;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static org.onap.portalng.e2e.helpers.CommonUtils.checkTextOfElement;
import static org.onap.portalng.e2e.pages.MainPage.*;
import static org.onap.portalng.e2e.pages.PopUpDialogPage.ALERT_WARNING;
import static org.onap.portalng.e2e.pages.UserAdministrationPage.TITLE_H2;


public class CommonSteps {

    public static void spinnerShouldDisappear() {
        try {
            $(SPINNER).shouldBe(Condition.visible, Duration.ofSeconds(3));
        } catch (Throwable ignored) {
        } finally {
            $(SPINNER).shouldBe(disappear, Duration.ofSeconds(80));
        }
    }

    public static void userClicksOnButtonInMainMenu(Button button) {
        switch (button) {
            case DASHBOARD:
                checkTextOfElement($(DASHBOARD_BTN), "Dashboard");
                $(DASHBOARD_BTN).click();
                break;
            case APP_STARTER:
                checkTextOfElement($(APP_STARTER_BTN), "App Starter");
                $(APP_STARTER_BTN).click();
                break;
            case USERS:
                checkTextOfElement($(USERS_BTN), "Users");
                $(USERS_BTN).click();
                break;
            default:
                throw new IllegalStateException("Sidebar Menu Menu button" + button + "not recognized");
        }
    }

    public static void userCanSeePage(Page page) {
        switch (page) {
            case DASHBOARD:
                spinnerShouldDisappear();
                checkTextOfElement($(TITLE_H2), "Dashboard");
                break;
            case APP_STARTER_PAGE:
                spinnerShouldDisappear();
                checkTextOfElement($(TITLE_H2), "App Starter");
                break;
            case USERS_PAGE:
                spinnerShouldDisappear();
                checkTextOfElement($(TITLE_H2), "User Administration");
                break;
            case USER_EDIT_PAGE:
                spinnerShouldDisappear();
                checkTextOfElement($(TITLE_H2), "Edit User");
                break;
            default:
                throw new IllegalStateException("Page not recognized");
        }
    }

    public static void userClicksOnSubmitButtonAndErrorMessageIsDisplayed(String error) {
        checkTextOfElement($(ALERT_WARNING), error);
    }
}
