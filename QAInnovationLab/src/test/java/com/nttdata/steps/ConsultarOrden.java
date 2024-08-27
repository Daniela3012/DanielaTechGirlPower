package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ConsultarOrden {
    private static String GET_INVENTORY = "https://petstore.swagger.io/v2/store/inventory";
    private static String GET_ORDER = "https://petstore.swagger.io/v2/store/order/";
    private Response response;

    public void verificarDisponibilidadAPI() {
        SerenityRest.given()
                .relaxedHTTPSValidation()
                .when()
                .get(GET_INVENTORY)
                .then()
                .statusCode(200); // Asegúrate de que el API responde con 200
    }

    public void consultarOrden (int id) {
        response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .get(GET_ORDER + id)
                .then()
                .log().all()
                .extract().response();
    }

    public void validarCodigoDeRespuesta(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println("Actual Status Code: " + actualStatusCode);

        // Imprime el cuerpo completo para más detalles
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Realiza la aserción
        assertThat(actualStatusCode, equalTo(expectedStatusCode));
    }

    public void validarCantidad(int quantityExpected) {
        int quantityCurrent = response.jsonPath().getInt("quantity");
        assertThat(quantityCurrent, equalTo(quantityExpected));
    }

}
