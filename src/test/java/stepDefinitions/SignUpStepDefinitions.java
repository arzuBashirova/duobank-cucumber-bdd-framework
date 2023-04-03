package stepDefinitions;

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

    @When("the user enters invalid input into any of the input fields")
    public void the_user_enters_invalid_input_into_any_of_the_input_fields() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.firstName.sendKeys("123");
        signUpPage.lastName.sendKeys("Smith");
        signUpPage.email.sendKeys("evelyn.smith@gmail.com");
        signUpPage.password.sendKeys("123456");
    }

    @Then("the Sign Up button should remain disabled")
    public void the_sign_up_button_should_remain_disabled() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage();
        WebElement signUpButton = signUpPage.signUpButton;
        Assert.assertFalse("The Sign Up button is not disabled", signUpButton.isEnabled());
        Thread.sleep(5000);
    }

    @Then("error messages should be displayed for the invalid input fields")
    public void error_messages_should_be_displayed_for_the_invalid_input_fields() {
//        SignUpPage signUpPage = new SignUpPage();
//        WebElement firstNameError = signUpPage.firstName.findElement(By.xpath("../div[@class='invalid-feedback']"));
//        String expectedError = "First name must contain only letters and spaces";
//        String actualError = firstNameError.getText().trim();
//        Assert.assertEquals("Error message does not match expected", expectedError, actualError);

        SignUpPage signUpPage = new SignUpPage();
        WebElement firstNameError = signUpPage.firstName.findElement(By.xpath("//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div"));
        Assert.assertTrue(firstNameError.isDisplayed());


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

    @And("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String string) {
        String expectedErrorMessage = "Email already exists";
        SignUpPage signUpPage = new SignUpPage();
        WebElement errorMessageElement = signUpPage.email.findElement(By.xpath("../div[@class='invalid-feedback']"));
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