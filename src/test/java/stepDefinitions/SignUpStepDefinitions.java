package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomePage;
import utils.ConfigReader;
import utils.Driver;


public class SignUpStepDefinitions {
    @Given("the user is on the registration page of the mortgage application website")
    public void the_user_is_on_the_registration_page_of_the_mortgage_application_website() {

        HomePage homePage = new HomePage();
        homePage.clickSignUpLink();

    }

    @When("the user enters their First Name, Last Name, Email Address, and Password")
    public void the_user_enters_their_first_name_last_name_email_address_and_password() {

        new HomePage().fillTheFormWithRandomData();


    }

    @When("all input fields have been filled out correctly")
    public void all_input_fields_have_been_filled_out_correctly() {

    }

    @Then("the Sign Up button should be clickable")
    public void the_sign_up_button_should_be_clickable() {

        HomePage homePage = new HomePage();
        homePage.clickSignUpButton();

    }

    @When("the user clicks the Sign Up button")
    public void the_user_clicks_the_sign_up_button() {

        new HomePage().clickSignUpButton();

    }

    @Then("a new account is created for the user")
    public void a_new_account_is_created_for_the_user() {

    }

    @Then("the user is redirected to the Sign In page")
    public void the_user_is_redirected_to_the_sign_in_page() {

        Assert.assertEquals("h[ttp://qa-duobank.us-east-2.elasticbeanstalk.com/register].php", Driver.getDriver().getCurrentUrl());
    }

    @Then("the user enters invalid input into any of the input fields")
    public void the_user_enters_invalid_input_into_any_of_the_input_fields() {
        new HomePage().fillTheFormWithRandomData();

    }

    @Then("the user enters the existing email address")
    public void the_user_enters_the_existing_email_address() {
        new HomePage().fillTheFormWithRandomData();

    }
    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String string) {

    }


    @Then("the Sign Up button should remain disabled")
    public void the_sign_up_button_should_remain_disabled() {

    }
    @Then("error messages should be displayed for the invalid input fields")
    public void error_messages_should_be_displayed_for_the_invalid_input_fields() {

    }
        @Given("there is an existing account with the email address the user is trying to use")
        public void there_is_an_existing_account_with_the_email_address_the_user_is_trying_to_use() {

    }

    @Given("the user already has an account")
    public void the_user_already_has_an_account() {

    }
    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String string) {

    }

    @Then("the user is redirected to the Sign In page of the mortgage application website")
    public void the_user_is_redirected_to_the_sign_in_page_of_the_mortgage_application_website() {

    }
}




