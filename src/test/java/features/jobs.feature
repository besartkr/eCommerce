Feature: Admin Jobs
  This feature deals with administrating new/existing jobs


  Background:
    Given I navigate to the home page
    When I enter the following for Login
      | username | password |
      | admin    | admin    |
    And I click login button
    Then I should see the welcome message

  @test
  Scenario:
    Given I navigate to the list of available jobs
    When I search for existing job title
  # Then  the Job Title will be displayed in the table

  Scenario:
    Given I navigate to the list of available jobs
    When I search for existing job title
   # And   if the Job is not in the database table
    #Then I will add a new one

  Scenario:
  #  Given I amend the job title of an employer
   # When I save the new job in the database
    #Then the Job title of the employer will be updated
