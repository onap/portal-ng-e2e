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

Feature: User Administration

  @delete_user
  Scenario: User can create a new user in Portal
    Given User is logged in Portal as ADMIN
    Given User visits the USERS_PAGE page
    When User clicks on Create User button
    And User verifies Create User Form
    And User fills data necessary for creating the user with USERNAME value e2e-test-user in the form
    And User clicks on Save button in the form
    Given User visits the USERS_PAGE page
    Then User verifies newly created User in the User List

  Scenario: User can cancel user creation
    Given User visits the USERS_PAGE page
    When User clicks on Create User button
    And User verifies Create User Form
    And User clicks on Cancel button in the form
    And User can see USERS_PAGE

  Scenario: User cannot create a new user in Portal without mandatory parameters
    Given User visits the USERS_PAGE page
    When User clicks on Create User button
    And User verifies Create User Form
    And User clicks on Save button in the form
    Then User should see REQUIRED_USERNAME feedback Required
    And User should see REQUIRED_EMAIL feedback Cannot be empty

  @delete_user
  Scenario: User cannot be created with already existing USERNAME
    Given User with USERNAME value e2e-test-user is created
    And User clicks on USERS button in main menu
    When User clicks on Create User button
    And User fills data necessary for creating the user with USERNAME value e2e-test-user in the form
    And User clicks on Save button in the form
    Then User should see error message with text Error while creating user account! Error reported by "Keycloak" system: "User exists with same username" Please, try to create user with different username.

  Scenario: User cannot be created with already existing EMAIL
    Given User with USERNAME value e2e-test-user is created
    And User clicks on USERS button in main menu
    When User clicks on Create User button
    And User fills data necessary for creating the user with USERNAME value e2e-test-user-2 in the form
    And User set parameter EMAIL with value e2e-test-user@test.user on User create or edit page
    And User clicks on Save button in the form
    Then User should see error message with text Error while creating user account! Error reported by "Keycloak" system: "User exists with same email" Please, try to create user with different email address.
    #deletion after test
    Then User with USERNAME e2e-test-user is successfully deleted

  Scenario: User cannot be created with USERNAME value as empty string
    Given User clicks on USERS button in main menu
    And User clicks on Create User button
    When User fills data necessary for creating the user with USERNAME value "" in the form
    And User set parameter EMAIL with value test@test.user on User create or edit page
    And User clicks on Save button in the form
    Then User should see INVALID_USERNAME feedback Invalid character

  Scenario: User cannot be created with EMAIL value as empty string
    Given User clicks on USERS button in main menu
    And User clicks on Create User button
    And User fills data necessary for creating the user with USERNAME value e2e-test-user in the form
    When User set parameter EMAIL with value "" on User create or edit page
    And User clicks on Save button in the form
    Then User should see INVALID_EMAIL feedback Invalid character
    And User should see WRONG_EMAIL_FORMAT feedback Wrong email format

  Scenario: User can be deleted in Portal
    Given User with USERNAME value e2e-test-user is created
    Then User with USERNAME e2e-test-user is successfully deleted

  @delete_user
  Scenario: User can be edited in Portal
    Given User with USERNAME value e2e-test-user is created
    And User clicks on EDIT button for user with USERNAME e2e-test-user on Users page
    And User can see USER_EDIT_PAGE
    And User checks presence of elements on User edit page
    And User clicks on Cancel button for user on User edit page
    And User can see USERS_PAGE
    And User clicks on EDIT button for user with USERNAME e2e-test-user on Users page
    And User fills all possible values to User edit page
    When User clicks on Edit button for user on User edit page
    Then User checks SUCCESS pop-up on user page with text User successfully updated.
    And User can see USERS_PAGE

  Scenario: User cannot be created with already existing EMAIL
    Given User with USERNAME value e2e-test-user-1 is created
    And User with USERNAME value e2e-test-user-2 is created
    And User clicks on USERS button in main menu
    And User can see USERS_PAGE
    And User clicks on EDIT button for user with USERNAME e2e-test-user-1 on Users page
    And User can see USER_EDIT_PAGE
    When User fills EMAIL e2e-test-user-2@test.user in User edit page
    And User clicks on Edit button for user on User edit page
    Then User should see error message with text Error, changing user account failed! Error reported by "Keycloak" system: "User exists with same username or email" Please, try to create user with different email address.
    #deletion after
    Then User with USERNAME e2e-test-user-1 is successfully deleted
    Then User with USERNAME e2e-test-user-2 is successfully deleted

  @delete_user
  Scenario: User role can be assigned or unassigned on Edit page
    Given User with USERNAME value e2e-test-user is created
    And User clicks on EDIT button for user with USERNAME e2e-test-user on Users page
    When User clicks on ONAP_DESIGNER available role checkbox
    Then ONAP_DESIGNER role is assigned to user
    And User clicks on ONAP_DESIGNER assigned role checkbox
    Then ONAP_DESIGNER role is unassigned from user
