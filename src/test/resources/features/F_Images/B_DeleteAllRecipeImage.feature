Feature: Delete all recipe images

  @F_Images
  Scenario: Delete recipe image by recipe_id with valid recipe_id path
    Given valid recipe_id path for delete recipe image by recipe id
    When Send DELETE request for delete recipe image by recipe_id
    Then API response for delete recipe image by recipe_id should return 200 OK status code
    And Validate response body JSON Schema for delete recipe image by recipe_id
    And Validate response body message key for delete recipe image by recipe_id should be "succesfully delete recipe's image"