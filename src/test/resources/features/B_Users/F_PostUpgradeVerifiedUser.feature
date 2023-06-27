Feature: Post upgrade verified user

  @B_Users
  Scenario: Post upgrade verified user with valid path
    Given Valid path for post upgrade verified user with valid path
    When Send POST request for post upgrade verified user with valid path
    Then API response for post upgrade verified user with valid path should return 201 Created status code
    And Validate response body JSON Schema for post upgrade verified user with valid path
    And Validate response body message key for post upgrade verified user with valid path should be "success send your request to admin"