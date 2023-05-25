Feature: Post Create Personal Label
  @Labels
  Scenario: Post create a new personal label with valid name in request body
    Given Request body for create a new personal label with name is Tomato
    When Send POST request for create a new personal label
    Then API response should return 200 OK status code
    And Validate create a new personal label response body JSON schema
    And Response body name for create a new personal label should be "tomato"

  @Labels
  Scenario: Post Create a new task with empty content key
    Given Empty request body for create a new project label
    When Send POST request with empty body for create a new personal label
    Then API response should return 400 Bad Request status code

  @Labels
  Scenario: Post create a new personal label with registered name
    Given Request body with registered name for create a new project label
    When Send POST request registered name for create a new personal label
    Then API response should return 400 Bad Request status code

  @Labels
  Scenario: Post create a new personal label with invalid request body
    Given "<key>" as invalid key on request body for create a new personal label
    When Send POST request for invalid body create a new personal label
    Then API response should return 400 Bad Request status code

  @Label
  Scenario: Post create a new personal label with empty name key
    Given Empty name key for create a new personal label
    When Send POST request with empty name key for create a new personal label
    Then API response should return 400 Bad Request status code




