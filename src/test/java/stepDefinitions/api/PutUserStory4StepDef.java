package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.ApiUtils;
import utils.ConfigReader;

public class PutUserStory4StepDef {




//    @Given("the request is authenticated with a valid API key")
//    public void the_request_is_authenticated_with_a_valid_api_key() {
//
//
//        ApiUtils.setRequestQueryParameter("api_key", ConfigReader.getProperty("api_key"));
//    }

    @Given("the request is not authenticated with a valid API key")
    public void the_request_is_not_authenticated_with_a_valid_api_key() {
        ApiUtils.setRequestQueryParameter("api_key", ConfigReader.getProperty("api_key")+"ashdgsag");
    }
    @Given("And the {string} header is set to {string}")
    public void and_the_header_is_set_to(String key, String value) {
        ApiUtils.setRequestHeader(key, value);
    }
    @When("I send a {string} request to the endpoint {string}.")
    public void i_send_a_request_to_the_endpoint(String requestMethod , String endpoint) {

        ApiUtils.sendRequest(requestMethod,endpoint);
    }

    @When("the {string} query parameter is set to {string}")
    public void the_query_parameter_is_set_to(String key, String value) {
        ApiUtils.setRequestQueryParameter(key, value);
    }

    @When("the body is set to the following")
    public void the_body_is_set_to_the_following(String docString) {
        ApiUtils.setRequestBody(docString);
    }
//    @Then("the response status code should be {int}")
//    public void the_response_status_code_should_be(Integer statusCode) {
//        ApiUtils.verifyResponseStatusCode(statusCode);
//    }
    @Then("The API endpoint updates the modified_at field in the database to reflect the date and time the user information was last modified.")
    public void the_api_endpoint_updates_the_modified_at_field_in_the_database_to_reflect_the_date_and_time_the_user_information_was_last_modified() {

        Response response = ApiUtils.getResponse();
        String modifiedAt = response.path("modified_at");
        System.out.println(modifiedAt);


    }
    @Then("The response time for a single user request should be less than {int} ms.")
    public void the_response_time_for_a_single_user_request_should_be_less_than_ms(Integer ms) {

        ApiUtils.verifyResponseTime(ms);
    }

    @Then("the response body key {string} should be {string}")
    public void the_response_body_key_should_be(String key, String value) {
        ApiUtils.verifyBasicResponseBody(key,value);
    }




}
