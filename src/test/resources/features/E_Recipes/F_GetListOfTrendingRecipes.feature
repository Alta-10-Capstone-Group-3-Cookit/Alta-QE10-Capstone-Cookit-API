Feature: Get List Of Trending Recipes

  @Cookit
  Scenario: Get list of trending recipes with valid path
    Given Get list of trending recipes with valid path
    When Send Get list of trending recipes
    Then Status code should be 200 OK
    And Validate Get list of trending recipes with valid path json schema