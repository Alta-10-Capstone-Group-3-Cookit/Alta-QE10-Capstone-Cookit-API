Feature: Create a new task

  @Tasks
  Scenario: Post Create a new task with valid request body
    Given Valid request body for create a new task
    When Send VALID POST request for create a new task
    Then API response should return 200 OK status code
    And Validate create a new task response body JSON Schema
    And Response body content key for create a new task should be "Buy Milk"

  @Tasks
  Scenario: Post Create a new task with empty content key
    Given Request body for create a new task with empty content key
    When Send POST request for create a new task
    Then API response for create a new task should return 400 Bad Request status code

  @Tasks
  Scenario: Post Create a new task with number data type of content key
    Given Request body for create a new task with number data type of content key
    When Send POST request for create a new task
    Then API response for create a new task should return 400 Bad Request status code

  @Tasks
  Scenario: Post Create a new task without content key
    Given Request body for create a new task without content key
    When Send POST request for create a new task
    Then API response for create a new task should return 400 Bad Request status code

  @Tasks
  Scenario: Post Create a new task with empty due_string key
    Given Request body for create a new task with empty due_string key
    When Send POST request for create a new task
    Then API response for create a new task should return 400 Bad Request status code

  @Tasks
  Scenario: Post Create a new task with number data type of due_string key
    Given Request body for create a new task with number data type of due_string key
    When Send POST request for create a new task
    Then API response for create a new task should return 400 Bad Request status code

  @Tasks
  Scenario: Post Create a new task without due_string key
    Given Request body for create a new task without due_string key
    When Send POST request for create a new task
    Then API response for create a new task should return 400 Bad Request status code


