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

public class UserAdministrationPage {


    //ALERT
    public static final By ALERT_DANGER = By.className("alert-danger");
    public static final By ALERT_SUCCESS = By.className("alert-success");

    //TITLES
    public static final By TITLE_H2 = By.tagName("h2");
    public static final By TITLE_H4 = By.tagName("h4");
    public static final By TITLE_H5 = By.tagName("h5");


    //BUTTONS
    public static final By BUTTON_CREATE = By.className("qa_create_button");
    public static final By BUTTON_CANCEL = By.className("qa_submit_cancel");
    public static final By BUTTON_SAVE = By.className("qa_submit_button");
    public static final By BUTTON_EDIT = By.className("qa_edit_button");

    //LABELS
    public static final By LABEL_ID = By.xpath("//label[@for = 'id']");
    public static final By LABEL_USERNAME = By.xpath("//label[@for = 'username']");
    public static final By LABEL_EMAIL = By.xpath("//label[@for = 'email']");
    public static final By LABEL_FIRST_NAME = By.xpath("//label[@for = 'firstName']");
    public static final By LABEL_LAST_NAME = By.xpath("//label[@for = 'lastName']");
    //INPUT
    public static final By INPUT_ID = By.xpath("//input[@id = 'id']");
    public static final By INPUT_USERNAME = By.xpath("//input[@id = 'username']");
    public static final By INPUT_EMAIL = By.xpath("//input[@id = 'email']");
    public static final By INPUT_FIRST_NAME = By.xpath("//input[@id = 'firstName']");
    public static final By INPUT_LAST_NAME = By.xpath("//input[@id = 'lastName']");

    public static final By INVALID_INPUT = By.className("ng-invalid");
    public static final By REQUIRED_EMAIL = By.className("qa_required_email");
    public static final By REQUIRED_USERNAME = By.className("qa_required_user_name");
    public static final By INVALID_USERNAME = By.className("qa_invalid_user_name");
    public static final By INVALID_EMAIL = By.className("qa_invalid_email");
    public static final By WRONG_EMAIL_FORMAT = By.className("qa_wrong_format_email");

    //FORM
    public static final By FORM_CHECK = By.className("form-check");
    //TABLE
    public static final By TABLE_ROWS = By.xpath("//tbody/tr");

    public static final By TITLE_LBL = By.className("qa_title");
    public static final By USER_DATA_HEADER = By.xpath("//*[contains(text(), 'Set User Data')]");
    public static final By ROLES_HEADER = By.xpath("//*[contains(text(), 'Set Roles')]");

    public static final By AVAILABLE_ROLES = By.className("qa_available_roles");
    public static final By ASSIGNED_ROLES = By.className("qa_assigned_roles");
    //ROLES
    public static final By ONAP_DESIGNER_ROLE = By.id("onap_designer");
    public static final By ONAP_OPERATOR_ROLE = By.id("onap_operator");
    public static final By ONAP_ADMIN_ROLE = By.id("onap_admin");
    public static final By AVAILABLE_ROLES_HEADER = By.className("qa_available_roles");
    public static final By ASSIGNED_ROLES_HEADER = By.className("qa_assigned_roles");

    public static By roleCheckbox(String role) {
        return By.xpath("div/input[contains(@type,checkbox) and contains(@aria-labelledby, '" + role + "')]");
    }
}
