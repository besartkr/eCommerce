Feature: LoginFeature
  This feature deals with adding a new admin user and chanaging their roles

  Background:
    Given I navigate to the home page
    When I enter the following for Login
      | username | password |
      | admin    | admin    |
    And I click login button
    Then I should see the welcome message

  @ORangeHRM
  Scenario: Login with correct username and add new Admin user
    Given I navigate to the Admin tab
    When I key the admin details
      | EmployeeName | username | password | confirmpass |
      | Fiona Grace  | besart   | admin    | admin       |
    And I click Save button
    Then I will see the details are saved in the table

  @ORangeHRM
  Scenario: Login and delete an admin user that left the company
    Given I navigate to the Admin tab
    When I search for an admin account
      | addUserName | employeeName |
      | besart      | Fiona Grace  |
    And I edit my employer details on my username
    Then The user Role will change from Admin to ESS



