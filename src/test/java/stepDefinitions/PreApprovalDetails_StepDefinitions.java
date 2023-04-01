package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PreApprovalDetails_Page;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.time.Duration;
import java.util.List;


public class PreApprovalDetails_StepDefinitions {

//    @Before()
//    public void setUpScenario(){
//        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        Driver.getDriver().manage().window().maximize();
//    }
    @Given("The user is on the preapproval details page")
    public void the_user_is_on_the_preapproval_details_page() {
        //Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php",Driver.getDriver().getCurrentUrl());
    }

    @When("The user clicks on Dropdown menu of options for \"Purpose of Loan\"")
    public void the_user_clicks_on_dropdown_menu_of_options_for_purpose_of_loan() {
    }

    @Then("it should contain options")
    public void it_should_contain_options(List<String> dataTable) {
        System.out.println(dataTable);
        Assert.assertEquals(3,dataTable.size());
    }

    @When("The user enters a dollar amount into \"Estimated Purchase Price\" field")
    public void the_user_enters_a_dollar_amount_into_estimated_purchase_price_field() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it should be required")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_should_be_required() {
        SeleniumUtils.waitFor(4);
        //Assert.assertTrue(new PreApprovalDetails_Page().getEstimatedPurchasePrice().equals("2000.50"));
        new PreApprovalDetails_Page().sendKeysToEstimatedPurchasePrice();
        System.out.println(new PreApprovalDetails_Page().getEstimatedPurchasePrice().getCssValue("value"));

    }

    @When("The user enters a dollar amount into \"Down Payment Amount\" field")
    public void the_user_enters_a_dollar_amount_into_down_payment_amount_field() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it's required")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_s_required() {
        SeleniumUtils.waitFor(4);
        Assert.assertTrue(new PreApprovalDetails_Page().getDownPayment().equals(50.30));
    }

    @When("The user enters a percent amount into \"Down Payment Percentage\" field")
    public void the_user_enters_a_percent_amount_into_down_payment_percentage_field() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it be automatically calculated")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_be_automatically_calculated() {
        SeleniumUtils.waitFor(4);
        Assert.assertTrue(new PreApprovalDetails_Page().getDownPaymentPercentage().equals(2.50));
    }

    @When("The user enters amounts into purchase price and down payment fields")
    public void the_user_enters_amounts_into_purchase_price_and_down_payment_fields() {
    }

    @Then("The \"Your Loan Amount\" field should be automatically updated")
    public void the_your_loan_amount_field_should_be_automatically_updated()
    {
        Assert.assertTrue(new PreApprovalDetails_Page().getCalculatedAmount().equals(1950));
    }
    }


