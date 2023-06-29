Feature: Get list of user's transaction

 @Cookit
  Scenario: Get list of user's transaction with valid path
    Given Get list of user's transaction with valid path
    When Send Get list of user's transaction
    Then Status code should be 200 OK
    And Validate get list of user's transaction with valid path json schema
