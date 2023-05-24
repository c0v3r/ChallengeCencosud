Feature: Verify Get method in the API

  @GetAll
  Scenario: Get all

    When User sets get all endpoint
    Then statusCode equals 200



  @GetByParam
  Scenario Outline: Get by parameter

    When User sets get by parameter endpoint
    Then User receive a valid "<title>"

    Examples:
      | title                                                                      |
      | sunt aut facere repellat provident occaecati excepturi optio reprehenderit |
