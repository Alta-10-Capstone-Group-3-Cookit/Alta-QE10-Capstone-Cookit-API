Feature: Post follow user

  @C_Followers @Cookit
  Scenario Outline: Post follow user with valid id
    Given Post follow user with valid "<id>"
    When Send post follow user
    Then Status code should be 201 Created
    And Validate post follow user with valid id json schema
    Examples:
      | id |
      | 30 |