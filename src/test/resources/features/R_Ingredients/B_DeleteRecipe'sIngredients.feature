Feature: Delete recipe's ingredients

 @Cookit
  Scenario: Delete recipe's ingredients with valid recipe id
    Given Delete recipe's ingredients with valid recipe id
    When Send Delete recipe's ingredients
    Then Status code should be 200 OK
    And Validate delete recipe's ingredients with valid recipe id json schema