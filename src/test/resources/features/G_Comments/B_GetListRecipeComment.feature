Feature: Get list of recipe comment

  @G_Comments
  Scenario: Get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter
    Given valid recipe_id path, "1" as valid page parameter, and "1" as valid limit parameter for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter
    When Send GET request for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter
    Then API response for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter should return 200 OK status code
    And Validate response body JSON Schema for get list of recipe comments with valid recipe_id path, valid page parameter and valid limit parameter