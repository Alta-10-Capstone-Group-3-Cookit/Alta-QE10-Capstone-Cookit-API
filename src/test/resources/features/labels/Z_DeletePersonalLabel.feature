Feature: Delete Personal Label
  @Labels
  Scenario: Delete a personal label with available id path
    Given An available id path for delete a personal label
    When Send DELETE request a personal label
    Then API response should return 204 No Content status code

  @Labels
  Scenario Outline: Delete a personal label with unavailable id path
    Given "<id>" as an unavailable id path for delete a personal label
    When Send DELETE request a personal label
    Then API response should return 400 Bad Request status code
    Examples:
      | id         |
      | 5544332211 |


