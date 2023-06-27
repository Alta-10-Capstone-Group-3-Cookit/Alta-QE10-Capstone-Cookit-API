Feature: Get show user profile

  @B_Users
  Scenario: Get show user profile with valid path
    Given Valid path for get show user profile with valid path
    When Send GET request for get show user profile with valid path
    Then API response for get show user profile should return 200 OK status code
    And Validate response body JSON Schema for get show user profile with valid path