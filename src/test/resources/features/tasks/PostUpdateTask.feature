Feature: Update a task

  @Tasks
  Scenario: Post update a task with available id path and valid content key
    Given Request body for update a task with name key is Buy Coffee and an available id path
    When Send VALID POST request for update a task
    Then API response for update a task should return 200 OK status code
    And Validate update a task response body JSON Schema
    And Validate response body id key for update a task should be same as available id path

  @Tasks
  Scenario Outline: Post update a task with unavailable id path and valid content key
    Given Request body for update a task with name key is Buy Coffee and "<id>" as an unavailable id path
    When Send POST request for Update a task
    Then API response for update a task should return 404 Not Found status code
    Examples:
      | id         |
      | 1234567890 |

  @Tasks
  Scenario Outline: Post update a task with invalid id path with special char and valid content key
    Given Request body for update a task with name key is Buy Coffee and "<id>" as an invalid id path with special char
    When Send POST request for Update a task
    Then API response for update a task should return 400 Bad Request status code
    Examples:
      | id   |
      | +-*/ |

  @Tasks
  Scenario: Post update a task with available id path and empty content key
    Given Request body for update a task with empty content key and an available id path
    When Send POST request for Update a task
    Then API response for update a task should return 400 Bad Request status code

  @Tasks
  Scenario: Post update a task with available id path and number data type of content key
    Given Request body for update a task with number data type of content key and an available id path
    When Send POST request for Update a task
    Then API response for update a task should return 400 Bad Request status code

  @Tasks
  Scenario: Post update a task with available id path and without content key
    Given Request body for update a task without content key and an available id path
    When Send POST request for Update a task
    Then API response for update a task should return 400 Bad Request status code


