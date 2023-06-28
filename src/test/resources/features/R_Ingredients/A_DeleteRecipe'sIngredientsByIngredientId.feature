Feature: Delete recipe's ingredients by ingredients id


  Scenario: Delete recipe's ingredients with valid recipe id and ingredient id
    Given Delete recipe's ingredients with valid recipe id and ingredient id
    When Send Delete recipe's ingredients Id
    Then Status code should be 200 OK
    And And Validate delete recipe's ingredients with valid recipe id and ingredient id json schema