Feature: LoginFeature
  This feature deals with the login and logout functionality of the application

  Scenario:
    Given I navigate to the home page
    When I enter the following for Login
      | username | password |
      | admin    | admin    |
    And I click login button
    Then I should see the welcome message

  @test
  Scenario:
    Given  I navigate to the home page
    When I enter the following for Login
      | username | password |
      | admin    | admin    |
    And I click login button
    And I click on the log out button to logout
    Then I navigate to the home page






