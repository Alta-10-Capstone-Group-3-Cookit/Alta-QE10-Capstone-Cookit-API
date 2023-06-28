Feature: Put update user cart

  @K_Carts
  Scenario: Put update user cart with valid cart_id path and valid request body json
    Given valid cart_id path and valid request body json for put update user cart with valid cart_id path and valid request body json
    When Send PUT request for put update user cart with valid cart_id path and valid request body json
    Then API response for put update user cart with valid cart_id path and valid request body json should return 200 OK status code
    And Validate response body JSON Schema for put update user cart with valid cart_id path and valid request body json
    And Validate response body message key for put update user cart with valid cart_id path and valid request body json should be "succesfully update user's cart"