Feature: Login to Cenco Mobile App

  Background:
    Given User launches the application


  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples:
      | username             | password  | errorMessage                |
      | Admin                | 123456789 | The email format is invalid |


  @ValidCredentials
  Scenario: Login with valid credentials
    When User enters username as "prueba@accenture.com" and password as "123456"
    Then User should be able to login sucessfully
