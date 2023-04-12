package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import pages.EconsentPage;
import pages.ExpensesPage;
import pages.SignInPageNigar;
import utils.Driver;

public class EconsentPageStepDefs {

    //Background
    @Given("the user is on the eConsent page")
    public void the_user_is_on_the_e_consent_page(){

        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
          Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php", Driver.getDriver().getCurrentUrl());


        SignInPageNigar sign = new SignInPageNigar();
        sign.addEmail();
        sign.addPassword();
        sign.singIn();
        sign.personalInfo();
        new ExpensesPage().fillMonthlyRentPayBox("2500");
        sign.clickNextButton();
        extracted(sign);
        sign.clickNextButton();
        sign.clickNextButton();
    }

    private static void extracted(@NotNull SignInPageNigar sign) {
        sign.employmentAndIncome();
    }

    //Scenario 1
    @When("the user fills the form with random data  including first name, last name and email")
    public void the_user_fills_the_form_with_random_data_including_first_name_last_name_and_email() {
        new EconsentPage().fillTheFormWithRandomData();
    }

    @Then("the value boxes for first and last names should be filled")
    public void theValueBoxesForFirstAndLastNamesShouldBeFilled() {
        EconsentPage econsentPage = new EconsentPage();
        String actualFirstName = econsentPage.getFirstNameValue();
        String actualLastName = econsentPage.getLastNameValue();
        Assert.assertNotEquals("", actualFirstName);
        Assert.assertNotEquals("", actualLastName);
    }





    //Scenario 2
    @Then("the value boxes for first and last names should be blank")
    public void theValueBoxesForFirstAndLastNamesShouldBeBlank() {

        new EconsentPage().clearTheForm();
        EconsentPage econsentPage = new EconsentPage();
        String actualFirstName = econsentPage.getFirstNameValue();
        String actualLastName = econsentPage.getLastNameValue();
        Assert.assertEquals("", actualFirstName);
        Assert.assertEquals("", actualLastName);


        //  EconsentPage econsentPage = new EconsentPage();



    }









}

