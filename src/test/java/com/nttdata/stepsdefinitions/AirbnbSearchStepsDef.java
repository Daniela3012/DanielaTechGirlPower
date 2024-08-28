package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AirbnbSearchSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class AirbnbSearchStepsDef {

    @Steps
    AirbnbSearchSteps airbnbBusqueda;

    @Given("estoy en la pantalla de login de Airbnb")
    public void estoyEnLaPantallaDeLoginDeAirbnb() {
        airbnbBusqueda.clickClose();
    }

    @When("busco mi preferencia {string}")
    public void buscoMiPreferencia(String place) {
        airbnbBusqueda.searchByText(place);
    }

    @Then("muestra el resultado {string}")
    public void muestraElResultado(String testResult) {
        Assert.assertEquals(airbnbBusqueda.getResultText(), testResult);
    }
}
