Feature: Delete Recipes Step


  Scenario: Delete recipes step with valid recipe id
    Given Delete recipes step with valid recipe id
    When Send Delete recipes step
    Then Status code should be 200 OK
    And Validate delete recipes step with valid recipe id json schema