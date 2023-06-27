Feature: Delete recipe comment

  @G_Comments
  Scenario: Delete recipe comment with valid recipe_id path and valid comment_id path
    Given valid recipe_id path, valid comment_id path for delete recipe comment with valid recipe_id path and valid comment_id path
    When Send DELETE request for delete recipe comment with valid recipe_id path and valid comment_id path
    Then API response for delete recipe comment with valid recipe_id path and valid comment_id path should return 200 OK status code
    And Validate response body JSON Schema for delete recipe comment with valid recipe_id path and valid comment_id path
    And Validate response body message key for delete recipe comment with valid recipe_id path and valid comment_id path should be "succesfully delete recipe's comment"