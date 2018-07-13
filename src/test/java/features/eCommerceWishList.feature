Feature: WishList feature

  Background:
    Given I navigate to the home page


  @ready
  Scenario: Ensure I can increase the quanity of the product I have in my WishList table
    Given I navigate to the WishList Page
    When I increase the product quantity To 10
    Then the new quantity will be saved and displayed

  @ready
  Scenario: Increase the priority of the order
    Given I navigate to the WishList Page
    When I amend the priority of the order
    Then the new priority will be displayed on the order
