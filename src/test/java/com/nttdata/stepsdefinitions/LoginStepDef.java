package com.nttdata.stepsdefinitions;

import com.nttdata.pages.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;

public class LoginStepDef {

    PagePrincipal paginaPrincipal = new PagePrincipal();
    PageLogin paginaDeLogin = new PageLogin();
    PageMiCuentaEnTienda miCuenta = new PageMiCuentaEnTienda();
    PageCategoriaClothes paginaClothes = new PageCategoriaClothes();
    PageClothesMen paginaDeRopaHombre = new PageClothesMen();
    PageClothesMenHumPrintTshirt poloHummer = new PageClothesMenHumPrintTshirt();
    PageCart paginaCarrito = new PageCart();

    @Dado("Estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        paginaPrincipal.navigateToStorePe();
        TestUtils.takeScreenShot();
        paginaPrincipal.clickOnLogIn();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String direccionCorreo, String contrasenia) {
        paginaDeLogin.typeUserInput(direccionCorreo);
        paginaDeLogin.typePassInput(contrasenia);
        TestUtils.takeScreenShot();
        paginaDeLogin.clickOnLogin();
        TestUtils.takeScreenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        miCuenta.clickOnCategoria(categoria);
        paginaClothes.clickOnSubCategory(subcategoria);
        TestUtils.takeScreenShot();

    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        paginaDeRopaHombre.clickOnProduct();
        poloHummer.clickOnAddTshirt(unidades);
        poloHummer.clickOnAddCart();
        TestUtils.takeScreenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {

        Assertions.assertEquals("Producto añadido correctamente a su carrito de compra", poloHummer.getConfirmationMessage().trim());
        TestUtils.takeScreenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        double precioUnidad = 19.12;
        int cantidad = 3;
        double total = precioUnidad*cantidad;
        String cantidadTotalSolesEsperada = "S/ "+String.valueOf(total);
        Assertions.assertEquals(cantidadTotalSolesEsperada, poloHummer.getTotalPrice());
        TestUtils.takeScreenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        poloHummer.clickOnEndBuy();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        poloHummer.clickOnCart();
        TestUtils.takeScreenShot();
        String tituloEsperado = "CARRITO";
        Assertions.assertEquals(tituloEsperado, paginaCarrito.getTitleCart());
        TestUtils.takeScreenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        double precioUnidad = 19.12;
        int cantidad = 3;
        double total = precioUnidad*cantidad;
        String cantidadTotalSolesEsperada = "S/ "+String.valueOf(total);
        paginaCarrito.getTotalPrice();
        Assertions.assertEquals(cantidadTotalSolesEsperada, paginaCarrito.getTotalPrice());
        TestUtils.takeScreenShot();
    }
}
