#language: es

Característica: Product - Store
  Esquema del escenario: Validación del precio de un producto con diferentes datos de usuario y categoría
    Dado Estoy en la pagina de la tienda
    Y me logueo con mi usuario "<usuario>" y clave "<clave>"
    Cuando navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito
    Ejemplos:
      | usuario                        | clave        | categoria | subcategoria |
      | danielapaola301299@gmail.com   | fresita964   | Clothes   | Men          |
      | daniela@gmail.com              | fresita      | Clothes   | Men          |
      | danielapaola301299@gmail.com   | fresita964   | Tacos     | Men          |



