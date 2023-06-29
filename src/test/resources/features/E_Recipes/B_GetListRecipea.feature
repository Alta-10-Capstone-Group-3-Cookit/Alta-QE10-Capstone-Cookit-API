Feature: Get List Recipe

  @Cookit
  Scenario: Get list recipes with valid path
    Given Get list recipes with valid path
    When Send get list recipes
    Then Status code should be 200 OK
    And And Validate get list recipes with valid path json schema