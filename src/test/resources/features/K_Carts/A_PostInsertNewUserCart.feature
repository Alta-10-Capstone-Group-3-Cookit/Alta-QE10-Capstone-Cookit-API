Feature: Post insert new user cart

  @K_Carts @Cookit
  Scenario: Post insert new user cart with valid request body json
    Given Valid request body json for post insert new user cart with valid request body json
    When Send POST request for post insert new user cart with valid request body json
    Then API response for post insert new user cart with valid request body json should return 201 Created status code
    And Validate response body JSON Schema for post insert new user cart with valid request body json
    And Validate response body message key for post insert new user cart with valid request body json should be "succesfully insert user's cart"