Feature: Update a personal label
  @Labels @Todoist
  Scenario: Post update a personal label with available id path
    Given As an available id path and name was Coffee for update a personal label
    When Send POST request for update a personal label
    Then API response should return 200 OK status code
    And Validate update a personal label response body JSON schema
    And Response body name for update a personal label should be "Coffee"

  @Labels @Todoist
  Scenario Outline: Post update a personal label with unavailable id path
    Given "<id>" as an unavailable id path and name was Snack for update a personal label
    When Send POST request for update a personal label
    Then API response should return 404 Not Found status code
    Examples:
      | id         |
      | 1234567899 |

  @Labels @Todoist
    Scenario Outline: Post update a personal label with invalid id path
    Given "<id>" as an invalid id path and name was Snack for update a personal label
    When Send POST request for update a personal label
    Then API response should return 400 Bad Request status code
    Examples:
      | id         |
      | !@#$%^&*() |

  @Labels @Todoist
  Scenario: Post update a personal label with empty name key
    Given An available id path and empty name key for update a personal label
    When Send POST request for update a personal label
    Then API response should return 400 Bad Request status code

  @Labels @Todoist
  Scenario: Post update a personal label with invalid body request
    Given "<key>" as invalid key on request body for update a project
    When Send POST request for update a personal label
    Then API response should return 400 Bad Request status code

