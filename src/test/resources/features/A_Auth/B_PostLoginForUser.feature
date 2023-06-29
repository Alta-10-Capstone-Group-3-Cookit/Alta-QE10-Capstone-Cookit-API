Feature: Post Login For User

  @LOGIN_to_PostRecipes @Cookit
  Scenario: Post login user with valid path and valid json body
    Given Post login user with valid path and valid json body
    When Send post login user
    Then Status code should be 200 OK
    And Validate post login for user JSON Schema
