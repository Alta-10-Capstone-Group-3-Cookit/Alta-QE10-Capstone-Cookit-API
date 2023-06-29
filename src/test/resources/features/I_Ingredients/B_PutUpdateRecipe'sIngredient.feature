Feature: Put update recipe's ingredients

 @Cookit
  Scenario: Put update recipe's ingredients with valid recipe id and ingredient id and json body
    Given Put update recipe's ingredients with valid recipe id and ingredient id and json body
    When Send Put update recipe's ingredients
    Then Status code should be 200 OK
    And Validate put update recipe's ingredients with valid recipe id and ingredient id and json body json schema