package com.nttdata.stepsdefinitions;

import com.nttdata.pages.PageInventarioProducts;
import com.nttdata.pages.PageLoginSaucedemo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;

public class LoginStepDef {

    PageLoginSaucedemo pageLogin = new PageLoginSaucedemo();
    PageInventarioProducts pageInventario = new PageInventarioProducts();

    @Dado("que me encuentro en la pagina de inicio de sesion de Saucedemo")
    public void queMeEncuentroEnLaPaginaDeInicioDeSesionDeSaucedemo() {
        pageLogin.navigateToSaucedemo();
        TestUtils.takeScreenShot();
    }

    @Cuando("ingreso las dredenciales de usuario: {string} y contraseña: {string}")
    public void ingresoLasDredencialesDeUsuarioYContraseña(String username, String password) {
        pageLogin.typeUserInput(username);
        pageLogin.typePassInput(password);
        pageLogin.clickOnLogin();
        TestUtils.takeScreenShot();
    }

    @Entonces("valido el titulo de {string}")
    public void validoElTituloDe(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, pageInventario.getTitle());
    }

    @Y("tambien valido que exista al menos un item")
    public void tambienValidoQueExistaAlMenosUnItem() {
        Assertions.assertTrue(pageInventario.countProducts()>0, "El tamaño de la lista es: "+ pageInventario.countProducts());
        TestUtils.scrollDown();
        TestUtils.takeScreenShot();
    }

    @Y("hago click en el producto {string}")
    public void hagoClickEnElProducto(String product) {
        pageInventario.clickOnProduct(product);
        TestUtils.takeScreenShot();
    }
}
