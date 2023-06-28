Feature: Post insert new recipe's ingredients


  Scenario: Post insert new recipe's ingredients with valid recipe id and json body
    Given Post insert new recipe's ingredients with valid recipe id and json body
    When Send Post insert new recipe's ingridients
    Then Status code should be 201 Created
    And Validate post insert new recipe's ingredients with valid recipe id and json body json schema