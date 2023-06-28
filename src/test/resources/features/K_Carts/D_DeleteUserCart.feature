Feature: Delete user cart

  @K_Carts
  Scenario: Delete user cart with valid card_id path
    Given valid cart_id path for delete user cart with valid card_id path
    When Send DELETE request for delete user cart with valid card_id path
    Then API response for delete user cart with valid card_id path should return 200 OK status code
    And Validate response body JSON Schema for put update user cart with valid card_id path
    And Validate response body message key for put update user cart with valid card_id path should be "succesfully delete user's cart"