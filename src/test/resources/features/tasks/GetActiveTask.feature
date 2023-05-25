Feature: Get an active task

  @Tasks @Todoist
  Scenario: Get an active task with available id path
    Given Available id path for get an active task
    When Send GET request for get an active task
    Then API response for get an active task should return 200 OK status code
    And Validate get an active task response body JSON Schema
    And Validate response body id key for get an active task should be same as available id path

  @Tasks @Todoist
  Scenario Outline: Get an active task with unavailable id path
    Given "<id>" as an unavailable id path
    When Send GET request for get an active task
    Then API response for get an active task should return 404 Not Found status code
    Examples:
      | id         |
      | 1234567890 |

  @Tasks @Todoist
  Scenario Outline: Get an active task with invalid id path with special char
    Given "<id>" as an invalid id path with special char
    When Send GET request for get an active task
    Then API response for get an active task should return 400 Bad Request status code
    Examples:
      | id   |
      | +-*/ |