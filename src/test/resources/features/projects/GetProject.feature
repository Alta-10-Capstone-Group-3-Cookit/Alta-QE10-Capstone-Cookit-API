Feature: Get a project

  @Project
  Scenario: Get a project with available id path
    Given Available id path for get a project
    When Send GET request for get a project
    Then API response for get a project should return 200 OK status code
    And Validate get a project response body JSON Schema
    And Validate response body id key for get a project should be same as available id path

  @Project
  Scenario Outline: Get a project with unavailable id path
    Given "<id>" as an unavailable id path for get a project
    When Send GET request for get a project
    Then API response for get a project should return 404 Not Found status code
    Examples:
      | id         |
      | 1234567890 |
