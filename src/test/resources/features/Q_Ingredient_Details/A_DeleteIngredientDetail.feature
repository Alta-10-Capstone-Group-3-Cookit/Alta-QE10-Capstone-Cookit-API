Feature: Delete ingredient detail

  @Q_Ingredient_Detail
  Scenario: Delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path
    Given valid recipe_id path and valid ingredient_detail_id path for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path
    When Send DELETE request for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path
    Then API response for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path should return 200 OK status code
    And Validate response body JSON Schema for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path
    And Validate response body for delete ingredient detail with valid recipe_id path and valid ingredient_detail_id path should be "succesfully delete ingredient's detail"