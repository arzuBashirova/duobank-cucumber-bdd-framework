package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EmploymentPage_Nilu;
import pages.PathPage_Nilu;
import pages.PreApprovalDetails_Page;
import utils.Driver;
import utils.SeleniumUtils;

public class ApplicationsStepDefinition {

    // Background
    @Given("The user is on the logging page")
    public void the_user_is_on_the_logging_page() {
    }

    @When("User entering email and password")
    public void user_entering_email_and_password() {
        PreApprovalDetails_Page preApprovalDetails_page = new PreApprovalDetails_Page();
        SeleniumUtils.waitFor(4);
        preApprovalDetails_page.sendKeysToEmailField("farrokh.bulsara@gmail.com");
        SeleniumUtils.waitFor(2);
        preApprovalDetails_page.sendKeysToPasswordField("VWK@uvx2dzw5rgv1kdx");
        SeleniumUtils.waitFor(3);
        preApprovalDetails_page.SignInButton2.click();
    }

    @Then("User should be logged in")
    public void user_should_be_logged_in() {

    }
    @Then("User navigates to the Application List page")
    public void user_navigates_to_the_application_list_page(){
        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/applications.php");
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/applications.php", Driver.getDriver().getCurrentUrl());

    }


    // Common Given

    @Given("The user is on the Application List page")
    public void the_user_is_on_the_application_list_page() {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/applications.php", currentUrl);

    }


    // Scenario 1
    @Then("The user should see a table with columns for")
    public void the_user_should_see_a_table_with_columns_for(io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("The table should display a maximum of {int} entries by default")
    public void the_table_should_display_a_maximum_of_entries_by_default(Integer int1) {

    }

    @Then("The user can select the number of entries to show from a dropdown with options of {int}, {int}, {int}, and {int}")
    public void the_user_can_select_the_number_of_entries_to_show_from_a_dropdown_with_options_of_and(Integer int1, Integer int2, Integer int3, Integer int4) {

    }

    @Then("The user can enter a search term in the search field to filter the results based on the search term")
    public void the_user_can_enter_a_search_term_in_the_search_field_to_filter_the_results_based_on_the_search_term() {

    }

    @Then("The loan id should be an integer number")
    public void the_loan_id_should_be_an_integer_number() {

    }

    @Then("The borrower name should be displayed in the format of first name, last name")
    public void the_borrower_name_should_be_displayed_in_the_format_of_first_name_last_name() {

    }

    @Then("The loan amount should be displayed in US dollars and should be an integer")
    public void the_loan_amount_should_be_displayed_in_us_dollars_and_should_be_an_integer() {

    }

    @Then("The loan details column should have a View Details button that should take the user to a page with loan details")
    public void the_loan_details_column_should_have_a_view_details_button_that_should_take_the_user_to_a_page_with_loan_details() {

    }

    @Then("The table should have sorting functionality for each column")
    public void the_table_should_have_sorting_functionality_for_each_column() {

    }

    @Then("Pagination should be available if the number of entries exceeds the selected {string} option")
    public void pagination_should_be_available_if_the_number_of_entries_exceeds_the_selected_option(String string) {

    }

    // Scenario 2

    @When("The user clicks on the View Details button for a specific loan")
    public void the_user_clicks_on_the_view_details_button_for_a_specific_loan() {

    }

    @Then("The user should be taken to a page with loan details")
    public void the_user_should_be_taken_to_a_page_with_loan_details() {

    }

    @Then("The information displayed on the loan details page should match what the user entered previously")
    public void the_information_displayed_on_the_loan_details_page_should_match_what_the_user_entered_previously() {

    }

    @Then("The user can navigate back to the Application Tracking page")
    public void the_user_can_navigate_back_to_the_application_tracking_page() {

    }

    // Scenario 3
    @When("The user clicks on a column header")
    public void the_user_clicks_on_a_column_header() {

    }

    @Then("The table should be sorted by that column in ascending order")
    public void the_table_should_be_sorted_by_that_column_in_ascending_order() {

    }

    @Then("When the user clicks on the same column header again")
    public void when_the_user_clicks_on_the_same_column_header_again() {

    }

    @Then("The table should be sorted by that column in descending order")
    public void the_table_should_be_sorted_by_that_column_in_descending_order() {

    }

    // Scenario 4
    @When("The number of entries exceeds the selected {string} option")
    public void the_number_of_entries_exceeds_the_selected_option(String string) {

    }

    @Then("The table should display pagination links to navigate to other pages")
    public void the_table_should_display_pagination_links_to_navigate_to_other_pages() {

    }

}
