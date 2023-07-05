Feature: Get Timeline Of Recipes

  @Cookit
  Scenario: Get timeline of recipes with valid path
    Given Get timeline of recipes with valid path
    When Send Get timeline of recipes
    Then Status code should be 200 OK
    And Validate Get timeline of recipes with valid path json schema