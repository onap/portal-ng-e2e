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

public class PageWithTable {

    public static final By PAGINATION = By.xpath("//ul[contains(@class, 'pagination')]");
    public static final By NEXT_PAGE = By.xpath("//ul[contains(@class, 'pagination')]//li[last()-1]");
    public static final By TABLE_ROWS = By.xpath("//table//tbody/tr");
    public static final By ROW_CELLS = By.xpath("td");
    public static final By ROW_DELETE_BUTTON = By.xpath("td//button[contains(@class, 'qa_delete_button')]");
}
