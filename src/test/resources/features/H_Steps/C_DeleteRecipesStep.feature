Feature: Delete Recipes Step

  @Cookit
  Scenario: Delete certain recipes step with valid recipe id
    Given Delete recipes step Id with valid recipe id
    When Send Delete recipes step Id
    Then Status code should be 200 OK
    And Validate delete recipes step Id with valid recipe id json schema