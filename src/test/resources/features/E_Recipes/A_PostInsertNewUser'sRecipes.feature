Feature: Post insert new user's recipes

  @LOGIN_to_PostRecipes @Cookit
  Scenario: Post insert new user's recipes with valid path and valid data
    Given Post insert new user's recipes with valid path and valid data
    When Send post insert new user's recipes
    Then Status code should be 201 Created
    And Validate post insert new user's recipes with valid path and valid data json schema