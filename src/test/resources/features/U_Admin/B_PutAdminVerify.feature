Feature: Put Users Approval

 @Cookit
  Scenario: Put users approval with valid id and json body
    Given Put users approval with valid id and json body
    When Send put users approval
    Then Status code should be 200 OK
    And Validate put users approval with valid id and json body json schema