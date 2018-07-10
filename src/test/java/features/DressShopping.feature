Feature: Shopping Dresses feature

  Background:
    Given I navigate to the home page

@test
Scenario: Select a Casual Dress from list of Dresses
  Given I navigate to Dresses page
  When I select a Casual Dresses
  Then list of Casual Dresses will be displayed on the page
