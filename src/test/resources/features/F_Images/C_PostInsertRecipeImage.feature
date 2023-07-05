Feature: Post insert recipe image (2)

  @F_Images @Cookit
  Scenario: Post insert recipe image with valid recipe_id path and valid image file
    Given valid recipe_id path and valid image for post insert recipe image with valid recipe_id path and valid image file
    When Send POST request for post insert recipe image with valid recipe_id path and valid image file
    Then API response for post insert recipe image with valid recipe_id path and valid image file should return 201 Created status code
    And Validate response body JSON Schema for post insert recipe image with valid recipe_id path and valid image file
    And Validate response body message key for post insert recipe image with valid recipe_id path and valid image file should be "succesfully insert recipe's image"