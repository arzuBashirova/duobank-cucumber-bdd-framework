package stepDefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SignUpPage;
import utils.Driver;

import static org.junit.Assert.assertFalse;


public class SignUpStepDefinitions {
    @Given("the user is on the registration page of the mortgage application website")
    public void the_user_is_on_the_registration_page_of_the_mortgage_application_website() {

        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php", Driver.getDriver().getCurrentUrl());


    }

    @When("the user enters their First Name, Last Name, Email Address, and Password")
    public void the_user_enters_their_first_name_last_name_email_address_and_password() {

        new SignUpPage().fillTheFormWithRandomData();

    }

    @When("all input fields have been filled out correctly")
    public void all_input_fields_have_been_filled_out_correctly() {

        SignUpPage homePage = new SignUpPage();
        Assert.assertTrue(homePage.firstName.isDisplayed());//firstName inputBoxElement.getValue().
        Assert.assertTrue(homePage.lastName.isDisplayed());
        Assert.assertTrue(homePage.email.isDisplayed());
        Assert.assertTrue(homePage.password.isDisplayed());

    }

    @When("the Sign Up is clickable")
    public void the_sign_up_button_should_be_clickable() throws InterruptedException {

        SignUpPage homePage = new SignUpPage();
        homePage.clickSignUpButton();
        WebElement signUpButton = homePage.signUpButton;
//        Assert.assertEquals("hhttp://qa-duobank.us-east-2.elasticbeanstalk.com/register.php", Driver.getDriver().getCurrentUrl());
        Assert.assertTrue("The Sign Up button is not clickable", signUpButton.isEnabled());
        Thread.sleep(10000);

    }

    @Then("the new account is created and the user is redirected to the Sign In page")
    public void the_user_is_redirected_to_the_sign_in_page() {

        WebDriver driver = Driver.getDriver();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php", driver.getCurrentUrl());

    }

    @Then("the message {string} is displayed")
    public void the_message_is_displayed(String string) {
        String expectedMessage = "Welcome Back!";
        WebElement messageElement = Driver.getDriver().findElement(By.xpath("//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[1]/div/h4"));
        String welcomeBackMessage = messageElement.getText();
        Assert.assertEquals(expectedMessage, welcomeBackMessage);

    }


    //Scenario 2
    @Then("the user should not be able to put invalid input into the input fields")
    public void theUserShouldNotBeAbleToPutInvalidInputIntoTheInputFields() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.email.sendKeys("evelyn.smith@gmail.com");
        signUpPage.password.sendKeys("123456");
        signUpPage.firstName.sendKeys("123");
        signUpPage.lastName.sendKeys("Smith");
        Assert.assertEquals("Invalid input allowed for first name field", "", signUpPage.firstName.getAttribute("value"));
        Assert.assertTrue("Invalid input allowed for last name field", signUpPage.lastName.getAttribute("value").matches("[^0-9]+"));
    }

    //Scenario 3
    @And("there is an existing account with the email address the user is trying to use")
    public void there_is_an_existing_account_with_the_email_address_the_user_is_trying_to_use() {
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php", Driver.getDriver().getCurrentUrl());

    }

    @When("the user enters the existing email address")
    public void the_user_enters_the_existing_email_address() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.firstName.sendKeys("Evelyn");
        signUpPage.lastName.sendKeys("Smith");
        signUpPage.email.sendKeys("evelyn.smith@gmail.com");
        signUpPage.password.sendKeys("123456");
        Thread.sleep(5000);
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String string) {
        String expectedErrorMessage = "This email already used";
        SignUpPage signUpPage = new SignUpPage();
        WebElement errorMessageElement = signUpPage.email.findElement(By.xpath("//*[@id=\"emailerror\"]"));
        String actualErrorMessage = errorMessageElement.getText().trim();
        Assert.assertEquals("Error message does not match expected", expectedErrorMessage, actualErrorMessage);
    }


    //Scenario 4

    @Given("the user already has an account")
    public void the_user_already_has_an_account() {


    }

    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String string) {
        new SignUpPage().clickRegistrationSignInLink();

    }


    @Then("the user is redirected to the Sign In page.")
    public void theUserIsRedirectedToTheSignInPage() {
        WebDriver driver = Driver.getDriver();
        System.out.println("Current URL: " + driver.getCurrentUrl());
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php", driver.getCurrentUrl());

    }

}