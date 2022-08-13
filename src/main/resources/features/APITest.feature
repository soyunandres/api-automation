@API
Feature: Ejemplo de request
  Scenario: Prueba Get al endpoint
    Given I send a request
    Then I get a list of 10 users
