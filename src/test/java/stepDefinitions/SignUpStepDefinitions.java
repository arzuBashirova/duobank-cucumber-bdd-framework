package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utils.ConfigReader;
import utils.Driver;

public class SignUpStepDefinitions {
    @Given("the user is on the registration page of the mortgage application website")
    public void the_user_is_on_the_registration_page_of_the_mortgage_application_website() {
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));

        HomePage homePage = new HomePage();
        homePage.clickSignUpLink();

    }
    @When("the user enters their First Name, Last Name, Email Address, and Password")
    public void the_user_enters_their_first_name_last_name_email_address_and_password() {

        new HomePage().fillTheFormWithRandomData();


    }
    @When("all input fields have been filled out correctly")
    public void all_input_fields_have_been_filled_out_correctly() {

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.firstName.isDisplayed());
        Assert.assertTrue(homePage.lastName.isDisplayed());
        Assert.assertTrue(homePage.email.isDisplayed());
        Assert.assertTrue(homePage.password.isDisplayed());

    }
    @Then("the Sign Up button should be clickable")
    public void the_sign_up_button_should_be_clickable() {

        HomePage homePage = new HomePage();
        homePage.clickSignUpButton();
        Assert.assertTrue(homePage.signUpButton.isEnabled());

    }
    @When("the user clicks the Sign Up button")
    public void the_user_clicks_the_sign_up_button() {

        new HomePage().clickSignUpButton();


    }
    @Then("a new account is created for the user")
    public void a_new_account_is_created_for_the_user() {

        Assert.assertEquals("h[ttp://qa-duobank.us-east-2.elasticbeanstalk.com/register].php",Driver.getDriver().getCurrentUrl());

//        Assert.assertEquals("Welcome Back!",homePage.welcomeBackMessage.getText());


    }

    @Then("the user is redirected to the Sign In page")
    public void the_user_is_redirected_to_the_sign_in_page() {

        Assert.assertEquals("h[ttp://qa-duobank.us-east-2.elasticbeanstalk.com/register].php",Driver.getDriver().getCurrentUrl());

//        Assert.assertEquals("Welcome Back!",homePage.welcomeBackMessage.getText());
    }
    @Then("the message {string} is displayed")
    public void the_message_is_displayed(String string) {

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.welcomeBackMessage.isDisplayed());
//            Assert.assertEquals("Welcome Back!",homePage.welcomeBackMessage.getText());


    }
}


