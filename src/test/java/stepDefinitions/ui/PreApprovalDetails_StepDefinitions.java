package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PreApprovalDetails_Page;
import utils.SeleniumUtils;

import java.util.List;


public class PreApprovalDetails_StepDefinitions {

    @Given("The user signs in and navigates to the Preapproval Details page")
    public void the_user_is_on_the_preapproval_details_page() {

    }

    @When("the user sees the email and password and enters it")
    public void the_user_sees_the_email_and_password() {
        PreApprovalDetails_Page preApprovalDetails_page = new PreApprovalDetails_Page();
        SeleniumUtils.waitFor(4);
        preApprovalDetails_page.sendKeysToEmailField("farrokh.bulsara@gmail.com");
        SeleniumUtils.waitFor(2);
        preApprovalDetails_page.sendKeysToPasswordField("VWK@uvx2dzw5rgv1kdx");
        SeleniumUtils.waitFor(3);
        preApprovalDetails_page.SignInButton2.click();
        SeleniumUtils.waitFor(3);
        preApprovalDetails_page.clickMortgageApplication();
    }

    @Then("the user should be able to sign in")
    public void the_user_should_be_able_to_sign_in() {

    }

//    @When("The user is on the sign in page")
//    public void the_user_is_on_the_sign_in_page() {}
//
//    @Then("the user should be able to sign in using their username and password")
//    public void the_user_should_be_able_to_sign_in_using_their_username_and_password() {
//        SeleniumUtils.waitFor(4);
//        String expectedURL = "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php";
//    }

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
    }


    @When("The user enters a dollar amount into \"Down Payment Amount\" field")
    public void the_user_enters_a_dollar_amount_into_down_payment_amount_field() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it's required")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_s_required(){

        SeleniumUtils.waitFor(4);

    }

    @When("The user enters a percent amount into \"Down Payment Percentage\" field")
    public void the_user_enters_a_percent_amount_into_down_payment_percentage_field() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it be automatically calculated")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_be_automatically_calculated() {
        SeleniumUtils.waitFor(4);

    }

    @When("The user enters amounts into purchase price and down payment fields")
    public void the_user_enters_amounts_into_purchase_price_and_down_payment_fields() {
    }

    @Then("The \"Your Loan Amount\" field should be automatically updated")
    public void the_your_loan_amount_field_should_be_automatically_updated() {
        SeleniumUtils.waitFor(4);

    }

    }