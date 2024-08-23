#language: es
@testfeature
Característica: Login
  Yo como usuario
  quiero iniciar sesion
  para ver todos los productos

  @test
  Escenario: Inicio de sesion
    Dada que me encuentro en la pagina de inicio de sesion de Saucedemo
    Cuando ingreso las dredenciales de usuario: "standard_user" y contraseña: "secret_sauce"
    Entonces valido el titulo de "Products"
    Y tambien valido que exista al menos un item
    Y hago click en el producto "Test.allTheThings() T-Shirt (Red)"