Feature: Get list of user following

  @D_Users @Cookit
  Scenario: Get list of user following with valid page and limit parameter
    Given "1" as valid page parameter and "1" as valid limit parameter for get list of user following with valid page and limit parameter
    When Send GET request for get list of user following with valid page and limit parameter
    Then API response for get list of user following with valid page and limit parameter should return 200 OK status code
    And Validate response body JSON Schema for get list of user following with valid page and limit parameter