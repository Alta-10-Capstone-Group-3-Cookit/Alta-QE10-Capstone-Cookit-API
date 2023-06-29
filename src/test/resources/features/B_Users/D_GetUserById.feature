Feature: Get user by id

  @B_Users @Cookit
  Scenario: Get user by id with valid id path
    Given "2" as valid id path for get user by id with valid id path
    When Send GET request for get user by id with valid id path
    Then API response for get user by id with valid id path should return 200 OK status code
    And Validate response body JSON Schema for get user by id with valid id path
    And Validate response body id key for get user by id with valid id path should be 2