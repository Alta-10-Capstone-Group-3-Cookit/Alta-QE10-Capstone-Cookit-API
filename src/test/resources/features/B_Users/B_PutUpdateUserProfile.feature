Feature: Put update user profile

  @B_Users @Cookit
  Scenario: Put update user profile with valid request body and valid profile picture
    Given Valid request body and valid profile picture for put update user profile with valid request body and valid profile picture
    When Send PUT request for put update user profile with valid request body and valid profile picture
    Then API response for put update user profile with valid request body and valid profile picture should return 200 OK status code
    And Validate response body JSON Schema for put update user profile with valid request body and valid profile picture
    And Validate response body message key for put update user profile with valid request body and valid profile picture should be "success update profile"