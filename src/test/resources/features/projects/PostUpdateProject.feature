Feature: Update a project

  @Project
  Scenario: Post update a project with available id path and valid name key in request body
    Given Request body for update a project with name key is Things To Buy and an available id path
    When Send POST request for update a project
    Then API response for update a project should return 200 OK status code
    And Validate update a project response body JSON Schema
    And Validate response body name key for update a project should be "Things To Buy"

  @Project
  Scenario Outline: Post update a project with unavailable id path and valid name key in request body
    Given Request body for update a project with name key is Things to Buy and "<id>" as an unavailable id path
    When Send POST request for update a project
    Then API response for update a project should return 404 Not Found
    Examples:
      | id         |
      | 1234567890 |