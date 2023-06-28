Feature: Put update user's recipe


  Scenario: Put update user's recipe with valid recipe id and json body
    Given Put update user's recipe with valid recipe id and valid json body
    When Send put update user's recipes
    Then Status code should be 200 OK
    And Validate put update user's recipes with valid recipe id and valid json body json schema