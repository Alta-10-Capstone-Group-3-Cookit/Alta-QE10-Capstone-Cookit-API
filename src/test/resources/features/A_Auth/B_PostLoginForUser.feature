Feature: Post Login For User

  @B_Auth
  Scenario: Post login user with valid path and valid json body
    Given Post login user with valid path and valid json body
    When Send post login user
    Then Status code should be 200 OK
    And Validate post login for user JSON Schema