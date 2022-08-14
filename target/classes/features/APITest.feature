Feature: Ejemplo de request
  @API
  Scenario: Prueba Get al endpoint
    Given I send a Get request to the https://api.github.com URI
    Then I get a 200 status code

  Scenario: Validar la cantidad de entradas de la respuesta
    Given I send a Get request to the https://jsonplaceholder.typicode.com URI
    Then I validate there are 10 items on the /users endpoint


  Scenario: Validar que un elemento se encuentra en la respuesta
    Given I send a Get request to the https://jsonplaceholder.typicode.com URI
    Then I validate there are value: Bret in the response at /users endpoint

  Scenario: Validar que un elemento se encuentra en la respuesta
    Given I send a Get request to the https://jsonplaceholder.typicode.com URI
    Then I validate there are other value: Bret in the response at /users endpoint

  Scenario: Validar que un elemento se encuentra en la respuesta
    Given I send a Get request to the https://jsonplaceholder.typicode.com URI
    Then I can validate the nested value: Kattie Turnpike  on the response at /users endpoint