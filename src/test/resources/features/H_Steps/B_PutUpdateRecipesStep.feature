Feature: Put Update Recipes Step

 @Cookit
  Scenario: Put update recipes step with valid recipe id and step id and json body
    Given Put update recipes step with valid recipe id and step id and json body
    When Send Put update recipes step
    Then Status code should be 200 OK
    And Validate Put update recipes step with valid recipe id and step id and json body json schema