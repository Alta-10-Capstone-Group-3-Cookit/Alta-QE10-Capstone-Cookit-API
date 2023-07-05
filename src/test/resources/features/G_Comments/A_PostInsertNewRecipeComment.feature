Feature: Post insert new recipe comment

  @G_Comments @Cookit
  Scenario: Post insert new recipe comment with valid recipe_id path, valid comment and valid image file
    Given "1" as valid recipe_id path, "mantap" as valid comment, and valid image file for post insert new recipe comment with valid recipe_id path, valid comment and valid image file
    When Send POST request for post insert new recipe comment with valid recipe_id path, valid comment and valid image file
    Then API response for post insert new recipe comment with valid recipe_id path, valid comment and valid image file should return 201 Created status code
    And validate response body JSON Schema for post insert new recipe comment with valid recipe_id path, valid comment and valid image file
    And Validate response body comment key for post insert new recipe comment with valid recipe_id path, valid comment and valid image file should be "mantap"