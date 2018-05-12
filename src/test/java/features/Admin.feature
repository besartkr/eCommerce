Feature: LoginFeature
  This feature deals with the login functionality of the application

  Background:
    Given I navigate to the home page and logged in
    When I enter the following for Login
      | username | password      |
      | admin    | admin |
    And I click login button
    Then I should see the welcome message

@test
  Scenario: Login with correct username and add new Admin user
    Given I navigate to the Admin tab
    When I key the admin details
      | EmployeeName | username | password | confirmpass |
      | Fiona Grace  | besart    | admin    | admin       |
  And I click Save button
  Then I will see the details are saved in the table

  @test

  Scenario: Login and delete an admin user that left the company
    Given I navigate to the Admin tab
    When I search for an admin account
      | addUserName | employeeName |
      | besart | Fiona Grace        |
      And I edit my employer details on my username
      Then The admin user will no longer be available



