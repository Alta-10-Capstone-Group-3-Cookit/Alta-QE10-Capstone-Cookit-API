Feature: Get details of recipes

 @Cookit
  Scenario: Get details of recipes with valid recipe id
    Given Get details of recipes with valid recipe id
    When Send Get details of recipes
    Then Status code should be 200 OK
    And Validate Get details of recipes with valid recipe id json schema