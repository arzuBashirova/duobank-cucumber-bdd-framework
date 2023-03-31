package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

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

        Assert.assertEquals(2,new SignInPage().getInputFields().size());

    }
    @Then("One for email address and the other for password")
    public void one_for_email_address_and_the_other_for_password() {

        Assert.assertEquals("Email address",new SignInPage().getEmail().getAttribute("placeholder"));
    }
    @When("The user left the fields blank")
    public void the_user_left_the_fields_blank() {


    }
    @Then("the user should not be able to submit")
    public void the_user_should_not_be_able_to_submit_the_form() {
        new SignInPage().clickOnSignInButton();
        Assert.assertEquals(ConfigReader.getProperty("homepage"),Driver.getDriver().getCurrentUrl());
    }

    @When("the user left the email field blank only")
    public void the_user_left_the_email_field_blank_only() {

        SignInPage signInPage=new SignInPage();
        signInPage.sendKeysToEmailField("");
        signInPage.sendKeysToPasswordField("VWK@uvx2dzw5rgv1kdx");

    }
    @Then("the user should not be able to submit without email")
    public void the_user_should_not_be_able_to_submit_the_form1() {
        new SignInPage().clickOnSignInButton();
        Assert.assertEquals(ConfigReader.getProperty("homepage"),Driver.getDriver().getCurrentUrl());
    }
    @When("the user left the password field blank only")
    public void the_user_left_the_password_field_blank_only() {

        SignInPage signInPage=new SignInPage();
        signInPage.getPassword().clear();
        signInPage.sendKeysToEmailField("farrokh.bulsara@gmail.com");
        signInPage.sendKeysToPasswordField("");
    }

    @Then("the user should not be able to submit without password")
    public void the_user_should_not_be_able_to_submit_the_form2() {
        new SignInPage().clickOnSignInButton();
        Assert.assertEquals(ConfigReader.getProperty("homepage"),Driver.getDriver().getCurrentUrl());
    }

    @When("the user enters an invalid email address")
    public void the_user_enters_an_invalid_email_address() {

        new SignInPage().userEnterInvalidEmail();
    }
    @When("clicks on the sign in button")
    public void clicks_on_the_sign_in_button() {
        new SignInPage().clickOnSignInButton();
    }
    @Then("the user should see an error message for email")
    public void the_user_should_see_an_error_message_for_email() throws InterruptedException {
        String errorMessage=new SignInPage().getEmail().getAttribute("validationMessage");
        Assert.assertEquals(errorMessage,Driver.getDriver().findElement(By.name("email")).getAttribute("validationMessage"));
        System.out.println(errorMessage);


    }

    @Then("the sign-up process should not proceed")
    public void the_sign_up_process_should_not_proceed() {

        //Assert.assertEquals(ConfigReader.getProperty("homepage"),Driver.getDriver().getCurrentUrl());
    }






}
