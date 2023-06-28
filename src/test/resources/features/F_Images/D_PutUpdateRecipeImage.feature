Feature: Put update recipe image

  @F_Images
  Scenario: Put update recipe image with valid recipe_id path, valid image_id path, and valid image file
    Given valid recipe_id path, valid image_id path, and valid image file for put update recipe image with valid recipe_id path, valid image_id path, and valid image file
    When Send PUT request for put update recipe image with valid recipe_id path, valid image_id path, and valid image file
    Then API response for put update recipe image with valid recipe_id path, valid image_id path, and valid image file should return 200 OK status code
    And Validate response body JSON Schema for put update recipe image with valid recipe_id path, valid image_id path, and valid image file
    And Validate response body message key for put update recipe image with valid recipe_id path, valid image_id path, and valid image file should be "succesfully update recipe's image"
