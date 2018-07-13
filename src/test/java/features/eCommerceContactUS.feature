Feature: ContactUs feature

  Background:
    Given I navigate to the home page

  @ready
  Scenario: Navigate to Contact us page and send a message
    Given I navigate to the contact us page
    When I enter the  email address, orderRef & the Message
    Then I will get a confirmation message


  @ready
  Scenario: Login to the site
    Given I navigate to the Login Page
    When I login as a register user
    Then I will be taken to My Account page


