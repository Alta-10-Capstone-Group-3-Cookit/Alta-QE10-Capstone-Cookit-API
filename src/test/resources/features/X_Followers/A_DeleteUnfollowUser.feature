Feature: Delete Unfollow User

  Scenario: Delete unfollow user with valid id
    Given Delete unfollow user with valid id 30
    When Send delete unfollow user
    Then Status code should be 200 OK
    And Validate post follow user with valid id json schema