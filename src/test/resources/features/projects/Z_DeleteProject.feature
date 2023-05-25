Feature: Delete a project

  @Project
  Scenario: Delete a project with available id path
    Given Available id path for delete a project
    When Send DELETE request for delete a project
    Then API response for delete a project should return 204 No Content status code

  @Project
  Scenario Outline: Delete project with unavailable id path
    Given "<id>" as an unavailable id path for delete a project
    When Send DELETE request for delete a project
    Then API response for delete a project should return 404 Not Found status code
    Examples:
      | id         |
      | 1234567890 |

  @Project
  Scenario Outline: Delete project with invalid id path
    Given "<id>" as an invalid id path for delete a project
    When Send DELETE request for delete a project
    Then API response for delete a project should return 400 Bad Request status code
    Examples:
      | id  |
      | @!+ |