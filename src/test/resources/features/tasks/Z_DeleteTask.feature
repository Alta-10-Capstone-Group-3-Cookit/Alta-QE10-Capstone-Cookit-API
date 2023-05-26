Feature: Delete a task

  @Tasks @Todoist
  Scenario: Delete a task with available id path
    Given Available id path for delete a task
    When Send GET request for delete a task
    Then API response for delete a task should return 204 No Content status code

  @Tasks @Todoist
  Scenario Outline: Delete a task with unavailable id path
    Given "<id>" as an unavailable id path for delete a task
    When Send GET request for delete a task
    Then API response for delete a task should return 404 Not Found status code
    Examples:
      | id         |
      | 1234567890 |

  @Tasks @Todoist
  Scenario Outline: Delete a task with invalid id path with special char
    Given "<id>" as an invalid id path for delete a task
    When Send GET request for delete a task
    Then API response for delete a task should return 400 Bad Request status code
    Examples:
      | id   |
      | +-*/ |
