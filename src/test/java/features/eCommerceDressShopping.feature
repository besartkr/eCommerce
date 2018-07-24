Feature: Shopping Dresses feature

  Background:
    Given I navigate to the home page

@ready
Scenario: Select a Casual Dress from list of Dresses
  Given I navigate to Dresses page
  When I select a Casual Dresses
  Then list of Casual Dresses will be displayed on the page



  @test
  Scenario: Add Causal Dress to the Shopping Cart
    Given I navigate to Dresses page
    When I add Casual Dress to Cart
    And I sign in to the checkout process
    And the Delivery and Billing address are the same
    And I complete the Shipping and payment details
    #Then the Dress will be added to the Shopping basket