Feature: Post Like User's Recipe

@Cookit
  Scenario: Post like user's recipe with valid recipe id
    Given Post like user's recipe with valid recipe id
    When Send Post like user's recipe
    Then Status code should be 200 OK
    And Validate Post like user's recipe with valid recipe id json schema