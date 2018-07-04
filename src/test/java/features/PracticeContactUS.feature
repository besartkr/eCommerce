Feature: ContactUs feature

  Background:
    Given I navigate to the home page

  @test1
  Scenario: Navigate to Contact us page and send a message
    Given I navigate to the contact us page
    When I enter the  email address, orderRef & the Message
    Then I will get a confirmation message


  @test
  Scenario: Login to the site
    Given I navigate to the Login Page
#    When I search for an admin account
   #   | addUserName | employeeName |
  #    | besart      | Fiona Grace  |
 #   And I edit my employer details on my username
 #   Then The user Role will change from Admin to ESS



