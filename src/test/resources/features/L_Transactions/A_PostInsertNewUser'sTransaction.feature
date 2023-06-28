Feature: Post Insert New User's Transaction


  Scenario: Post insert new user's transaction with valid path and json body
    Given Get Post insert new user's transaction with valid path and json body
    When Send Post insert new user's transaction
    Then Status code should be 201 Created
    And Validate get post insert new user's transaction with valid path and json body json schema