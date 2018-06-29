Feature: LoginFeature
  This feature deals with adding a new admin user and chanaging their roles

  Background:
    Given I navigate to the home page


  @test
  Scenario: Login with correct username and add new Admin user
    Given I navigate to the contact us page
    When I enter the deails in the Send A Message Form
    And I sent the message
    Then I will get a confirmation email


  @ORangeHRM
  Scenario: Login and delete an admin user that left the company
    Given I navigate to the Admin tab
    When I search for an admin account
      | addUserName | employeeName |
      | besart      | Fiona Grace  |
    And I edit my employer details on my username
    Then The user Role will change from Admin to ESS



