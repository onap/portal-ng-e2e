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

package org.onap.portal.e2e.test.pages;

import org.openqa.selenium.By;

public class MainPage {

    public static final By NAV_LINKS = By.xpath("//a[@class='nav-link']");
    public static final By SPINNER = By.xpath("//div[contains(@class, 'loading-spinner')]");

    public static final By DASHBOARD_BTN = By.className("qa_menu_home");
    public static final By APP_STARTER_BTN = By.className("qa_menu_app_starter");
    public static final By USERS_BTN = By.className("qa_menu_users");

}

