Feature: Get List Verify


  Scenario: Get list verify with valid path
    Given Get list verify with valid path
    When Send get list verify
    Then Status code should be 200 OK
    And Validate get list verify with valid path json schema