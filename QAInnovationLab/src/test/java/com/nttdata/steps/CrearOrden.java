package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CrearOrden {
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";
    private static String GET_PET = "https://petstore.swagger.io/v2/pet/";
    private Response response;

    public void createOrder(int id, int petId, int quantity, String shipDate, String status, boolean complete) {

        System.out.println("Response Body: " + response.getBody().asString());
        String requestBody = "{\n" +
                "  \"id\": \""+id+"\",\n" +
                "  \"petId\": \""+petId+"\",\n" +
                "  \"quantity\":  \""+quantity+"\",\n" +
                "  \"shipDate\": \""+shipDate+"\",\n" +
                "  \"status\": \""+status+"\",\n" +
                "  \"complete\": \""+complete+"\"\n" +
                "}";
        System.out.println("Request Body: ");
        System.out.println(requestBody);

        response = SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body(requestBody)
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
                .extract().response();
    }

    public void verifiedPet (int petId) {
        response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .get(GET_PET + petId)
                .then()
                .log().all()
                .extract().response();
    }

    public void validateResponseCode (int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode))    ;
    }

    public void validateBodyRequest(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        response.then().assertThat().body("id", Matchers.equalTo(id));
        response.then().assertThat().body("petId", Matchers.equalTo(petId));
        response.then().assertThat().body("quantity", Matchers.equalTo(quantity));
        response.then().assertThat().body("shipDate", Matchers.matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}(Z|\\+0000)"));
        response.then().assertThat().body("status", Matchers.equalTo(status));
        response.then().assertThat().body("complete", Matchers.equalTo(complete));
    }


}
