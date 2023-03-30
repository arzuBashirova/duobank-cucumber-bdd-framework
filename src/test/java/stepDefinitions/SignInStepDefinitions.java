package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;

public class SignInStepDefinitions {

    @Given("The user is on the Sign in page")
    public void i_am_on_sign_in_page() {

    }
    @When("The user navigates to the sign in page")
    public void i_navigates_to_the_sign_in_page() {


    }
    @Then("the user should be greeted with a welcome message")
    public void i_should_be_should_be_greeted_with_a_welcome_message() {

        Assert.assertTrue(new SignInPage().getWelcomeMessage().isDisplayed());
    }

    @When("The sign in page should have two input fields")
    public void the_sign_in_page_should_have_two_input_fields() {

        Assert.assertEquals(2,new SignInPage().getInputFields().size());//code

    }
    @Then("One for email address and the other for password")
    public void one_for_email_address_and_the_other_for_password() {

        Assert.assertEquals("Email address",new SignInPage().getEmail().getAttribute("placeholder"));
    }
}
