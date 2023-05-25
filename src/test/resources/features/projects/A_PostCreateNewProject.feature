Feature: Create a New Project

  @Project
  Scenario: Post create a new project with valid name key in request body
    Given Request body for create a new project with name key is Shopping List
    When Send VALID POST request for create a new project
    Then API response for create a new project should return 200 OK status code
    And Validate create a new project response body JSON schema
    And Response body name key for create a new project should be "Shopping List"

  @Project
  Scenario: Post create a new project with empty request body
    Given Empty request body for create a new project
    When Send POST request for create a new project
    Then API response for create a new project should return 400 Bad Request status code

  @Project
  Scenario: Post create a new project with empty name key
    Given Request body for create a new project with empty name key
    When Send POST request for create a new project
    Then API response for create a new project should return 400 Bad Request status code

  @Project
  Scenario: Post create a new project with number data type of name key
    Given Request body for create a new project with number data type of name key
    When Send POST request for create a new project
    Then API response for create a new project should return 400 Bad Request status code