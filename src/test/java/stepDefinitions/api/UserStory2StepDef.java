package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utils.ApiUtils;
import utils.ConfigReader;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory2StepDef {


    RequestSpecification requestSpecification;
    Response response;

    @Given("I have a valid API key")
    public void i_have_a_valid_api_key() {
        requestSpecification = given().
                queryParam("api_key", ConfigReader.getProperty("api_key"));


    }

    @When("I send a GET request to {string} with a valid user ID as a query parameter")
    public void i_send_a_get_request_to_with_a_valid_user_id_as_a_query_parameter(String endpoint) {
        String userId = "valid_user_id";
        Object apiKey = null;
        Response response = given()
                .header("Authorization", apiKey)
                .queryParam("id", userId)
                .get(endpoint);
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response Content-Type header should be {string}")
    public void the_response_content_type_header_should_be(String expectedContentType) {
        assertTrue(response.getContentType().startsWith(expectedContentType));
    }

    @Then("the response body should contain the following fields:")
    public void the_response_body_should_contain_the_following_fields(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asLists().forEach(row -> {
            String fieldName = row.get(0);
            String expectedValue = row.get(1);
            response.then().assertThat().body(fieldName, equalTo(expectedValue));
        });
    }

    @When("I send a GET request to {string} with an invalid or missing user ID as a query parameter")
    public void i_send_a_get_request_to_with_an_invalid_or_missing_user_id_as_a_query_parameter(String endpoint) {
        ApiUtils.prepareAPI();
        ApiUtils.setRequestQueryParameter("api_key", ConfigReader.getProperty("api_key"));
        ApiUtils.setRequestQueryParameter("id", "invalid_user_id");
    }

    @Then("the response body should contain an error message")
    public void the_response_body_should_contain_an_error_message() {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("error"));
    }

    @Then("response status code should be {int} or {int}")
    public void responseStatusCodeShouldBeOr(int arg0, int arg1) {

    }
}
