package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class SignInStepDefinitions {//sign in definitions

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


    @When("the user enters a password into password field")
    public void theUserEntersAPasswordIntoPasswordField() {

        new SignInPage().sendKeysToPasswordField(ConfigReader.getProperty("password"));
    }
    @Then("password should be masked")
    public void passwordShouldBeMasked() {

        if (new SignInPage().getPassword().getAttribute("type") == "password"){
            // if it is, do something
            Assert.assertEquals(ConfigReader.getProperty("homepage"),Driver.getDriver().getCurrentUrl());

        }else {
            // not masked
            Assert.assertFalse(Driver.getDriver().getPageSource().contains("Welcome"));
        }

    }


    @When("the user doesn't fill fields")
    public void theUserDoesnTFillFields() {



    }

    @Then("the sign in button should be disabled")
    public void theSignInButtonShouldBeDisabled() {
        if(new SignInPage().getSignInButton().isEnabled()){

            Assert.assertEquals(ConfigReader.getProperty("homepage"),Driver.getDriver().getCurrentUrl());
        }else {
            Assert.assertFalse(Driver.getDriver().getPageSource().contains("Welcome"));
        }

    }

    @When("the user enters correct credentials")
    public void theUserEntersCorrectCredentials() {

        new SignInPage().signIN();

    }

    @Then("the user navigates to the mortgage account dashboard")
    public void theUserNavigatesToTheMortgageAccountDashboard() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php",Driver.getDriver().getCurrentUrl());
    }

    @When("the user enters incorrect credentials")
    public void theUserEntersIncorrectCredentials() {

        new SignInPage().sendKeysToEmailField("123456789@gmail.com");
        new SignInPage().sendKeysToPasswordField("sdfg432w` ");

    }

    @Then("the application should display an error message “Login Failed”")
    public void theApplicationShouldDisplayAnErrorMessageLoginFailed() {

        //System.out.println(new SignInPage().getHeader().getAttribute("validationMessage"));
        List<WebElement> l= Driver.getDriver().findElements(By.xpath("//*[contains(text(),'Login Failed')]"));
        //I couldn't navigate element of “Login Failed” error message.


    }

    @When("the user doesn't have an account")
    public void theUserDoesnTHaveAnAccount() {


    }

    @Then("the sign in page should have a {string} text")
    public void theSignInPageShouldHaveALink(String arg0) {

        System.out.println(new SignInPage().getQuestion1().getText());

        Assert.assertEquals(new SignInPage().getQuestion1().getText(),arg0);
    }

    @Then("the sign in page should have a {string} link")
    public void theSignInPageShouldHaveALink2(String arg0) {

        String linkText=Driver.getDriver().findElement(By.linkText(arg0)).getText();

        Assert.assertEquals(arg0,linkText);

    }

}

