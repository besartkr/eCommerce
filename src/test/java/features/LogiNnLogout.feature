Feature: LoginFeature
  This feature deals with the login functionality of the application

@test
Scenario:
    Given I navigate to the home page and logged in
    When I enter the following for Login
      | username | password      |
      | admin    | admin |
    And I click login button
    Then I should see the welcome message






