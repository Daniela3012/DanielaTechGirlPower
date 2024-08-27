Feature: Creación de orden de compra de una mascota en PetStore
  @crearOrden
  Scenario Outline: Crear orden de compra de mascota
    Given verifico la existencia de la mascota con el id <petId>
    When creo una orden con el id <id> petId <petId> quantity <quantity> shipDate "<shipDate>" status "<status>" complete "<complete>"
    Then el codigo de respuesta es <statusCode>
    And la respuesta del servidor coincide con los datos de orden creada
    Examples:
      | id   | petId | quantity | shipDate                 | status    | complete | statusCode |
      | 8  | 7     | 2        | 2024-08-26T09:49:14.509Z | placed    | true     | 200        |
      | 4  | 9     | 3        | 2024-08-26T09:49:14.509Z | approved  | true     | 200        |
      | 2  | 4     | 4        | 2024-08-26T09:49:14.509Z | delivered | true     | 200        |

  @consultaOrden
  Scenario Outline: Consultar orden de compra
    Given verifico que el API de PetStore se encuentre disponible
    When consulto la existencia de la orden de compra con id <orderId>
    Then obtengo el codigo de respuesta que es <statusCode>
    And la cantidad de la orden es <quantity>
    Examples:
      | orderId | statusCode | quantity |
      | 8       | 200        | 2        |
      | 4       | 200        | 3        |
      | 2       | 200        | 4        |


