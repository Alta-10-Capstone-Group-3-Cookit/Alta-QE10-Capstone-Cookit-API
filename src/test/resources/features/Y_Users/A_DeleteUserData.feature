Feature: Delete user data

  @Y_Users @Cookit
  Scenario: Delete user data with valid path
    Given Valid path for delete user data with valid path
    When Send DELETE request for delete user data with valid path
    Then API response for delete user data with valid path should return 200 OK status code
    And Validate response body JSON Schema for delete user data with valid path
    And Validate response body message key for delete user data with valid path should be "succes delete user data"