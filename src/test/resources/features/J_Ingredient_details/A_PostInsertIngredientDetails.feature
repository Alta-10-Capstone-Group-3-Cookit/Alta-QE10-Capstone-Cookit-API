Feature: Post insert ingredient details

  @J_Ingredient_Details
  Scenario: Post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json
    Given valid recipe_id path, valid ingredient_id path, and valid request body json for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json
    When Send POST request for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json
    Then API response for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json should return 201 Created status code
    And Validate response body JSON Schema for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json
    And Validate response body message key for post insert ingredient detail with valid recipe_id path, valid ingredient_id path, and valid request body json should be "succesfully insert ingredient's detail"