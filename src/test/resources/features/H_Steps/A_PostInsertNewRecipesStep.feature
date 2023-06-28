Feature: Post insert new recipes step

  Scenario: Post insert new recipes step with valid recipe id and json body
    Given Post insert new recipes step with valid recipe id and json body
    When Send Post insert new recipes step
    Then Status code should be 201 Created
    And Validate post insert new recipes step with valid recipe id and json body json schema