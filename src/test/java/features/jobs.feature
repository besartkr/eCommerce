Feature: Admin Jobs
  This feature deals with administrating new/existing jobs


  Background:
    Given I navigate to the home page
    When I enter the following for Login
      | username | password |
      | admin    | admin    |
    And I click login button
    Then I should see the welcome message



  Scenario: Add a new job in the database
    Given I navigate to the list of available jobs
    When I enter the details of the new job
    Then the job will be added in database


  @inProgress
  Scenario: Edit existing job in the database
    Given I navigate to the list of available jobs
    When I search for existing job title
    Then I'll update the job details have have them displayed in the database

  Scenario: Delete existing job in the database
    Given I navigate to the list of available jobs
    When I delete a job title from the list
    Then The job Title no longer exists in the database
