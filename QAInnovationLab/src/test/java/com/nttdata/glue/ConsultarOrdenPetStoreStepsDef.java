package com.nttdata.glue;

import com.nttdata.steps.ConsultarOrden;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class ConsultarOrdenPetStoreStepsDef {
    ConsultarOrden consultaOrden = new ConsultarOrden();

    @Given("verifico que el API de PetStore se encuentre disponible")
    public void verificoQueElAPIDePetStoreSeEncuentreDisponible() {
        consultaOrden.verificarDisponibilidadAPI();
    }

    @When("consulto la existencia de la orden de compra con id {int}")
    public void consultoLaExistenciaDeLaOrdenDeCompraConIdId(int id) {
        consultaOrden.consultarOrden(id);
    }

    @Then("obtengo el codigo de respuesta que es {int}")
    public void obtengoElCodigoDeRespuestaQueEs(int statusCode) {
        consultaOrden.validarCodigoDeRespuesta(statusCode);
    }

    @And("la cantidad de la orden es {int}")
    public void laCantidadDeLaOrdenEsQuantity(int quantity) {
        consultaOrden.validarCantidad(quantity);
    }
}
