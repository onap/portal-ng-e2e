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

package org.onap.portal.e2e.test.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final Properties properties;
    private String propertyFileName= "test-local.properties";


    public ConfigFileReader(String fileName) {
        if(fileName != null) this.propertyFileName = fileName;
        BufferedReader reader;
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            try{
                reader = new BufferedReader(new FileReader(classLoader.getResource(propertyFileName).getFile()));
            }catch (FileNotFoundException fileNotFoundException){
                fileNotFoundException.printStackTrace();
                throw new FileNotFoundException("Configuration file not found. Check your PORTAL_ENV variable.");
            }
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFileName + "Check your PORTAL_ENV variable.");
        }
    }

    public Properties getProperties() {
        if (properties != null) return properties;
        else throw new RuntimeException("Properties file: " + propertyFileName + " not found. Check your PORTAL_ENV variable.");
    }
}
