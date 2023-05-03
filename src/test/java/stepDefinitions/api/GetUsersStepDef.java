package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApiUtils;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUsersStepDef {


    RequestSpecification requestSpecification;
    Response response;

    @Given("the request is authenticated with a valid API key")
    public void the_request_is_authenticated_with_a_valid_api_key() {

        requestSpecification=given().
                queryParam("api_key", ConfigReader.getProperty("api_key"));
    }
    @When("I send a {string} request to the end point {string}")
    public void i_send_a_request_to_the_end_point(String requestMethod, String endPoint) {

        if(requestMethod.equalsIgnoreCase("GET")){

            response=requestSpecification.
                    when().log().all().get(endPoint);

        }else if(requestMethod.equalsIgnoreCase("POST")){

            response=requestSpecification.
                    when().log().all().
                    post(endPoint);
        }

    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {

        response.then().
                statusCode(equalTo(statusCode));
    }

    @Given("the api key doesn't provide")
    public void theApiKeyDoesnTProvide() {

        requestSpecification=given().
                queryParam("");
    }

    @Then("{int} Unauthorized status code with error message should be displayed")
    public void unauthorizedStatusCodeWithErrorMessageShouldBeDisplayed(int statusCode2) {

        response.then().
                statusCode(equalTo(statusCode2));
    }


    @Given("the request made with valid API key")
    public void the_request_made_with_valid_api_key() {
        ApiUtils.prepareAPI();
       ApiUtils.setRequestQueryParameter("api_key", ConfigReader.getProperty("api_key"));
    }
    @When("I send a {string} request to the end point {string} to get the all users data")
    public void i_send_a_request_to_the_end_point_to_get_the_all_users_data(String method, String endPoint) {
        ApiUtils.sendRequest(method,endPoint);
    }
    @Then("the {string} header is set to {string}")
    public void and_the_header_is_set_to(String header, String value) {
        ApiUtils.verifyResponseHeader(header, value);
    }

}
