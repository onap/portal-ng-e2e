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

package org.onap.portalng.e2e.steps.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.onap.portalng.e2e.pages.MainPage.USERS_BTN;
import static org.onap.portalng.e2e.pages.UserAdministrationPage.TITLE_H2;

public class MainSteps {
    public static void userVisitsTheIndexPage() {
        open(Configuration.baseUrl);
    }

    public static void userClicksOnUserMenuBtn() {
        $(USERS_BTN).click();
    }

    public void userCanSeeUserAdministrationPage() {
        $(TITLE_H2).shouldHave(Condition.text("User Administration"));
    }
}
