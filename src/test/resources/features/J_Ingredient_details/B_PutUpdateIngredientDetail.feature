Feature: Put update ingredient detail

  @J_Ingredient_Details
  Scenario: Put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json
    Given valid recipe_id path, valid ingredient_detail_id path, and valid request body json for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json
    When Send PUT request for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json
    Then API response for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json should return 200 OK status code
    And Validate response body JSON Schema for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json
    And Validate response body for put update ingredient detail with valid recipe_id path, valid ingredient_detail_id path, and valid request body json should be "succesfully update ingredient's detail"