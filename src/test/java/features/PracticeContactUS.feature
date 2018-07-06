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


  @ready
  Scenario: Ensure that I have items in my WishList
    Given I navigate to the WishList Page
    When I add items to my WishList
    Then  I will see list of WishList items on my WishList table


  @test
  Scenario: Ensure I can increase the quantity of the product I have in my WishList table
    Given I navigate to the WishList Page
    When I increase the product quantity To 10
   Then the new quantity will be saved and displayed


  @ready
  Scenario: Change the size of the product I have in my WishList Page
    Given I navigate to the WishList Page
    When I amend the size of the dress
    Then the new size will be displayed on my product detail tab