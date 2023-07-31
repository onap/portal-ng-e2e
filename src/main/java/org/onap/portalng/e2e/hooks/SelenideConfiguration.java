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

package org.onap.portalng.e2e.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.onap.portalng.e2e.helpers.ConfigFileReader;

import java.util.Properties;

import static java.lang.Boolean.parseBoolean;

public class SelenideConfiguration {

    private static final String REPORTS_FOLDER = "target";
    private static final Properties testProperties = new ConfigFileReader(System.getenv("PORTAL_ENV")).getProperties();

    public static String getBaseUrl() {
        if (System.getenv("PORTAL_BASE_URL") != null) {
            testProperties.setProperty("baseUrl", System.getenv("PORTAL_BASE_URL"));
        }
        return testProperties.getProperty("baseUrl");
    }

    public static void getBrowser() {
        String browser = System.getProperty("selenide.browser", "chrome");
        boolean headless = parseBoolean(System.getProperty("selenide.headless", "false"));

        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.screenshots = true;
        Configuration.reportsFolder = REPORTS_FOLDER;
    }

    public static void closeSession() {
        WebDriverRunner.closeWebDriver();
    }
}
