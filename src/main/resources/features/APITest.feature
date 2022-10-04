# language: es
@API
Necesidad del negocio: Ejemplo de request
  Regla de negocio lol

  Escenario: Prueba Get al endpoint
    Dado I send a Get request to the https://api.github.com URI
    Entonces I get a 200 status code

  Escenario: Validar la cantidad de entradas de la respuesta
    Dado I send a Get request to the https://jsonplaceholder.typicode.com URI
    Entonces I validate there are 10 items on the /users endpoint


  Escenario: Validar que un elemento se encuentra en la respuesta
    Dado I send a Get request to the https://jsonplaceholder.typicode.com URI
    Entonces I validate there are value: Bret in the response at /users endpoint

  Escenario: Validar que un elemento se encuentra en la respuesta
    Dado I send a Get request to the https://jsonplaceholder.typicode.com URI
    Entonces I validate there are other value: Bret in the response at /users endpoint

  Escenario: Validar que un elemento se encuentra en la respuesta
    Dado I send a Get request to the https://jsonplaceholder.typicode.com URI
    Entonces I can validate the nested value: Kattie Turnpike  on the response at /users endpoint