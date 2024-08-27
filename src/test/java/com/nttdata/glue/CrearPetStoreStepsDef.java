package com.nttdata.glue;


import com.nttdata.steps.CrearOrden;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrearPetStoreStepsDef {
    private int idExpected;
    private int petIdExpected;
    private int quantityExpected;
    private String shipDateExpected;
    private String statusExpected;
    private boolean completeExpected;

    CrearOrden ordenNueva = new CrearOrden();

    @Given("verifico la existencia de la mascota con el id {int}")
    public void verificoLaExistenciaDeLaMascotaConElIdPetId(int petId) {
        ordenNueva.verifiedPet(petId);
    }
    @When("creo una orden con el id {int} petId {int} quantity {int} shipDate {string} status {string} complete {string}")
    public void creoUnaOrdenConElIdIdPetIdPetIdQuantityQuantityShipDateStatusComplete(int id, int petId, int quantity, String shipDate, String status, String complete) {

        this.idExpected=id;
        this.petIdExpected=petId;
        this.quantityExpected=quantity;
        this.shipDateExpected=shipDate;
        this.statusExpected=status;
        this.completeExpected=Boolean.parseBoolean(complete);
        ordenNueva.createOrder(id, petId, quantity, shipDate, status, Boolean.parseBoolean(complete));
    }

    
    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEsStatusCode(int statusCode) {
        ordenNueva.validateResponseCode(statusCode);
    }
    
    @And("la respuesta del servidor coincide con los datos de orden creada")
    public void laRespuestaDelServidorCoincideConLosDatosDeOrdenCreada() {
        ordenNueva.validateBodyRequest(idExpected, petIdExpected, quantityExpected, shipDateExpected, statusExpected, completeExpected);
    }


}
