Feature: Get user by username

  @B_Users @Cookit
  Scenario: Get user by username with valid offset and valid username parameter
    Given "user1" as valid username and "1" as valid offset parameter for get user by username
    When Send GET request for get user by username with valid offset and valid username parameter
    Then API response for get user by username with valid offset and valid username parameter should return 200 OK status code
    And Validate response body JSON Schema for get user by username with valid offset and valid username parameter
    And Validate response body username key for get user by username with valid offset and valid username parameter should be "user1"