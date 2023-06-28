Feature: Delete user's recipe


  Scenario: Delete user's recipe with valid recipe id
    Given Delete user's recipe with valid recipe id
    When Send Delete user's recipes
    Then Status code should be 200 OK
    And Validate Delete user's recipe with valid recipe id json schema