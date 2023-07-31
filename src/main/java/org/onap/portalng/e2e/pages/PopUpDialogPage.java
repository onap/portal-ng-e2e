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

public class PopUpDialogPage {
    public static final By DIALOG_HEADER = By.className("qa_modal_header");
    public static final By DIALOG_BODY = By.className("qa_modal_body");
    public static final By DIALOG_APPLY_BUTTON = By.className("qa_apply_button");
    public static final By DIALOG_CANCEL_BUTTON = By.className("qa_cancel_button");
    public static final By ALERT_SUCCESS = By.className("alert-success");
    public static final By ALERT_ERROR = By.className("alert-error");
    public static final By ALERT_WARNING = By.className("alert-danger");
}
