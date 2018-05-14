Feature: Admin Jobs
  This feature deals with administrating new/existing jobs


  Background:
    Given I navigate to the home page
    When I enter the following for Login
      | username | password      |
      | admin    | admin |
    And I click login button
    Then I should see the welcome message

@test21
    Scenario:
    Given I navigate to the list of JobTitles
    When I enter the details of the new Job title
    Then The new job title will be displayed in the list
