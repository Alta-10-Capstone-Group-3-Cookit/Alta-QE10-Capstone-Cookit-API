Feature: Put update recipe comment

  @G_Comments @Cookit
  Scenario: Put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file
    Given valid recipe_id path, valid comment_id path, "<comment>" as valid comment, and valid image file for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file
    When Send PUT request for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file
    Then API response for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file should return 200 OK status code
    And Validate response body JSON Schema for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file
    And Validate response body message key for put update recipe comment with valid recipe_id path, valid comment_id path, valid comment and valid image file should be "succesfully update recipe's comment"