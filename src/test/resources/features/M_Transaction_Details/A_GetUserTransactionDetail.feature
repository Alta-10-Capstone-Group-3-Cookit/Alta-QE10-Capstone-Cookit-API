Feature: Get user transaction detail

  @M_Transaction_Detail
  Scenario: Get user transaction detail with valid transaction_detail_id path
    Given valid transaction_detail_id path for get user transaction detail with valid transaction_detail_id path
    When Send GET request for get user transaction detail with valid transaction_detail_id path
    Then API response for get user transaction detail with valid transaction_detail_id path should return 200 OK status code
    And Validate response body JSON Schema for get user transaction detail with valid transaction_detail_id path
    And Validate response body message key for get user transaction detail with valid transaction_detail_id path should be "succesfully read user's transaction detail"