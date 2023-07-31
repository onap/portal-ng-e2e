#  Copyright (c) 2023. Deutsche Telekom AG
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#  http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.
#
#  SPDX-License-Identifier: Apache-2.0

Feature: Login and Logout

  Scenario: User can sign in to Portal with valid credentials
    Given User opens the Portal page
    And User verifies presence of all elements on Sign In form
    When User fills log in form with USERNAME value 'onap-admin' and PASSWORD value 'password'
    Then User submits credentials with Sign In button
    And User checks if is signed in to the Portal
    And User clicks on Logout button to log out from the Portal

  Scenario: User cannot login to Portal with invalid username or password
    Given User opens the Portal page
    And User verifies presence of all elements on Sign In form
    When User fills log in form with USERNAME value 'onap-admin' and PASSWORD value 'invalidPassword'
    And User submits credentials with Sign In button
    Then User sees error message 'Invalid username or password.' after incorrect credentials input
