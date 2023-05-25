Feature: Get a Personal Label

  @Labels
  Scenario: Get a personal labels with available id path
    Given As an available id path for get a personal label
    When Send GET request for get a personal label
    Then API response should return 200 OK status code
    And Validate get a personal label response body JSON Schema
    And Validate response body id key for get a personal label should be same as available id path

  @Labels
  Scenario Outline: Get a personal labels with unavailable id path
    Given unavailable "<id>" path for get a personal labels
    When Send GET request with unavailable id path for get a personal labels
    Then API response should return 404 Not Found status code
    Examples:
      | id         |
      | 1111122222 |

  @Labels
  Scenario Outline: Get a personal labels with invalid id path
    Given invalid "<id>" path for get a personal label
    When Send GET request with invalid id path for get a personal label
    Then API response for get a personal label  should return 400 Bad Request status code
    Examples:
      | id  |
      | @!+ |