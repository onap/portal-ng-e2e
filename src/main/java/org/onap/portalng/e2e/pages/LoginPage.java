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

package org.onap.portalng.e2e.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By SIGN_IN_BTN = By.id("kc-login");
    public static final By USERNAME_LBL = By.xpath("//label[contains(text(),'Username or email')]");
    public static final By PASSWORD_LBL = By.xpath("//label[contains(text(),'Password')]");
    public static final By USERNAME_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");

    public static final By CURRENT_PAGE_SPAN = By.xpath("//span[@aria-current='page']");
    public static final By CURRENT_PAGE_HEADING_TITLE = By.xpath("//h2[@class='qa_title']");

    public static final By DROPDOWN_MENU = By.id("dropdownMenu");
    public static final By LOGOUT_BUTTON = By.xpath("//button[contains(text(), \"Logout\")]");
    public static final By INPUT_ERROR_SPAN = By.id("input-error");

}
