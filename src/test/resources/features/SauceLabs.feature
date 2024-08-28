
@LoginTest
 Feature: Sauce Labs App

   @Login1
   Scenario: Login de ingreso exitoso
     Given ingreso al aplicativo de SauceLabs en el Login
     When inicio sesión con el usuario "standard_user" y clave "secret_sauce"

     @Login2
   Scenario: Login de ingerso exitoso por segunda vez
     Given ingreso al aplicativo de SauceLabs
     When ingreso el usuario "standard_user"
     And ingreso la clave "secret_sauce"
     And hago click en el boton Login
     Then valido el ingreso correctamente