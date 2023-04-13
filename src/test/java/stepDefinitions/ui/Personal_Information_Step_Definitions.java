package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PreApprovalDetails_Page;
import utils.SeleniumUtils;

import java.util.List;
public class Personal_Information_Step_Definitions {

    @Given("The user signs in and navigates to the Preapproval Details here")
    public void the_user_is_on_the_preapproval_details_page() {
    }

    @When("the user sees the email and password and enters info here")
    public void the_user_sees_the_email_and_password_info() {
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

    @Then("the user should be able to sign into page here")
    public void the_user_should_be_able_to_sign_in2() {
    }

    @When("The user clicks on Dropdown menu of options for \"Purpose of Loan\" here")
    public void the_user_clicks_on_dropdown_menu_of_options_for_purpose_of_loan() {
    }

    @Then("it should contain options here")
    public void it_should_contain_options1(List<String> dataTable) {
        System.out.println(dataTable);
        Assert.assertEquals(3,dataTable.size());
    }

    @When("The user enters a dollar amount into \"Estimated Purchase Price\" field here")
    public void the_user_enters_a_dollar_amount_into_estimated_purchase_price_field_here() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it should be required here")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_should_be_required_here() {

        SeleniumUtils.waitFor(4);
    }


    @When("The user enters a dollar amount into \"Down Payment Amount\" field here")
    public void the_user_enters_a_dollar_amount_into_down_payment_amount_field_here() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it's required here")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_s_required1(){

        SeleniumUtils.waitFor(4);

    }

    @When("The user enters a percent amount into \"Down Payment Percentage\" field here")
    public void the_user_enters_a_percent_amount_into_down_payment_percentage_field1() {
    }

    @Then("The user should be able to enter a dollar amount with up to 2 decimal places and it be automatically calculated here")
    public void the_user_should_be_able_to_enter_a_dollar_amount_with_up_to_2_decimal_places_and_it_be_automatically_calculated1() {
        SeleniumUtils.waitFor(4);

    }

    @When("The user enters amounts into purchase price and down payment fields here")
    public void the_user_enters_amounts_into_purchase_price_and_down_payment_fields2() {
    }

    @Then("The \"Your Loan Amount\" field should be automatically updated here")
    public void the_your_loan_amount_field_should_be_automatically_updated1() {
        SeleniumUtils.waitFor(4);
    }

    @When("the user enters their first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void the_user_enters_their_first_name_last_name_email_date_of_birth_ssn_marital_status_cell_phone_and_home_phone() {
    }

    @Then("all required fields are filled out")
    public void all_required_fields_are_filled_out() {
    }

    @When("the user selects \"Yes\" for the co-borrower question")
    public void the_user_selects_yes_for_the_co_borrower_question() {
    }

    @Then("an additional section for co-borrower's information is displayed")
    public void an_additional_section_for_co_borrower_s_information_is_displayed() {
    }

    @When("the user enters the co-borrower's first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void the_user_enters_the_co_borrower_s_first_name_last_name_email_date_of_birth_ssn_marital_status_cell_phone_and_home_phone() {
    }

    @Then("all required fields are filled out again")
    public void all_required_fields_are_filled_out_again2() {
    }

    @When("the user reads the Privacy Policy and clicks the checkbox to accept the terms")
    public void the_user_reads_the_privacy_policy_and_clicks_the_checkbox_to_accept_the_terms() {
    }

    @Then("the checkbox is checked and the user can move forward to the next page of the application")
    public void the_checkbox_is_checked_and_the_user_can_move_forward_to_the_next_page_of_the_application() {
    }

    @When("the user clicks the \"Next\" button")
    public void the_user_clicks_the_next_button() {
    }

    @Then("the user is directed to the next page of the loan application")
    public void the_user_is_taken_to_the_next_page_of_the_application() {
    }

}
