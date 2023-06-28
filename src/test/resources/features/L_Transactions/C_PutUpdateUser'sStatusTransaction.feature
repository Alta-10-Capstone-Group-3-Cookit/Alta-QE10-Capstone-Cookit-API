Feature: Put update user's status transaction


  Scenario: Put update user's status transaction with valid transaction id
    Given Put update user's status transaction with valid transaction id
    When Send Put update user's status transaction
    Then Status code should be 200 OK
    And And Validate put update user's status transaction with valid transaction id json schema
