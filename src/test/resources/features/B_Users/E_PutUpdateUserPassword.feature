Feature: Put update user password

  @B_Users @Cookit
  Scenario: Put update user password with valid request body
    Given Valid request body for put update user password with valid request body
    When Send PUT request for put update user password with valid request body
    Then API response for put update user password with valid request body should return 200 OK status code
    And Validate response body JSON Schema for put update user password with valid request body
    And Validate response body message key for put update user password with valid request body should be "success update password"