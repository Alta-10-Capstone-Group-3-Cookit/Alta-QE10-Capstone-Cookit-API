Feature: Post User Registration

  @A_Auth
  Scenario: Post register user with valid path and valid json body
    Given Post register user with valid path and valid json body
    When Send post registration user
    Then Status code should be 201 created
    And Validate post registration user JSON Schema