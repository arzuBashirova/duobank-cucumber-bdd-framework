package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EconsentPage;
import pages.ExpensesPage;
import utils.Driver;
import utils.SeleniumUtils;

public class EconsentPageStepDefs {

    // Common Given
    @Given("the user is on the eConsent page")
    public void the_user_is_on_the_e_consent_page() {

        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php", Driver.getDriver().getCurrentUrl());

    }

    //Scenario 1
    @When("fills out the eConsent form with random data")
    public void fills_out_the_e_consent_form_with_random_data() {
        new EconsentPage().fillTheFormWithRandomData();
    }

    @When("clicks on the {string} button")
    public void clicks_on_the_button(String string) {

    }

    @Then("the user is redirected to the next page")
    public void the_user_is_redirected_to_the_next_page() {

    }

    //Scenario 2
    @When("the user clicks on the eConsent button")
    public void the_user_clicks_on_the_e_consent_button() {

    }

    @Then("an alert message should be displayed")
    public void an_alert_message_should_be_displayed() {

    }


    @When("the user fills the form with random data  including first name, last name and email")
    public void the_user_fills_the_form_with_random_data_including_first_name_last_name_and_email() {
        new EconsentPage().fillTheFormWithRandomData();

    }


}
