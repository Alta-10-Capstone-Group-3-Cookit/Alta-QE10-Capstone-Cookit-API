Feature: Delete certain recipe image

  @P_Images
  Scenario: Delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path
    Given valid recipe_id path and valid image_id path for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path
    When Send DELETE request for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path
    Then API response for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path should return 200 OK status code
    And Validate response body JSON Schema for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path
    And Validate response body message key for delete recipe image by recipe_id and image_id with valid recipe_id path and valid image_id path should be "succesfully delete recipe's image"