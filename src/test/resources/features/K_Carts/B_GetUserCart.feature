Feature: Get user cart

  @K_Carts @Cookit
  Scenario: Get list user carts with valid page parameter and valid limit parameter
    Given "1" as valid page parameter and "1" as valid limit parameter for get list user carts with valid page parameter and valid limit parameter
    When Send GET request for get list user carts with valid page parameter and valid limit parameter
    Then API response for get list user carts with valid page parameter and valid limit parameter should return 200 OK status code
    And Validate response body JSON Schema for get list user carts with valid page parameter and valid limit parameter
    And Validate response body message key for get list user carts with valid page parameter and valid limit parameter should be "succesfully read list of user's carts"