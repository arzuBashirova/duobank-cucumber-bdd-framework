package stepDefinitions.DB;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DBUtils;

import java.util.List;

public class ExpensesPageDBStepDef {


    List<String> actualColumnNames;

    @When("I send a request to retrieve information from tbl_mortagage table")
    public void i_send_a_request_to_retrieve_information_from_tbl_mortagage_table() {
        actualColumnNames = DBUtils.getColumnNames("select  * from tbl_mortagage");

    }
    @Then("It should be the following column names")
    public void it_should_be_the_following_column_names(List<String> expectedColumnNames) {

        Assert.assertTrue(actualColumnNames.containsAll(expectedColumnNames));


    }


    List<String> actualRentOwnStatusColumnValues;
    @When("I send a request to retrieve rent_own_status column details from tbl_mortagage table")
    public void i_send_a_request_to_retrieve_rent_own_status_column_details_from_tbl_mortagage_table() {

        actualRentOwnStatusColumnValues = DBUtils.getSingleColumnValues("rent_own_status", "tbl_mortagage");
    }
    @Then("It should have the following details")
    public void it_should_have_the_following_details(List<String> expectedRentOwnStatusColumnValues ) {
        Assert.assertTrue(actualRentOwnStatusColumnValues.containsAll(expectedRentOwnStatusColumnValues));
    }

    List<List<Object>> actualMonthlyRentalPaymentColumnValues;
    @When("I send a request to retrieve monthly_rental_payment column details from tbl_mortagage table")
    public void i_send_a_request_to_retrieve_monthly_rental_payment_column_details_from_tbl_mortagage_table() {
        actualMonthlyRentalPaymentColumnValues = DBUtils.getListOfLists("SELECT monthly_rental_payment FROM tbl_mortagage WHERE monthly_rental_payment < 0");

    }
    @Then("It should have the following details for " +
            "monthly_rental_payment column")
    public void it_should_have_the_following_details_for_monthly_rental_payment_column() {

        Assert.assertTrue(actualMonthlyRentalPaymentColumnValues.isEmpty());
    }


    List<List<Object>> actualFirstMortgageTotalPaymentColumnValues;
    @When("I send a request to retrieve first_mortgage_total_payment column details from tbl_mortagage table")
    public void i_send_a_request_to_retrieve_first_mortgage_total_payment_column_details_from_tbl_mortagage_table() {
        actualFirstMortgageTotalPaymentColumnValues = DBUtils.getListOfLists("SELECT first_mortagage_total_payment FROM tbl_mortagage where first_mortagage_total_payment <0");
    }
    @Then("It should have the following details for first_mortgage_total_payment column")
    public void it_should_have_the_following_details_for_first_mortgage_total_payment_column() {
        Assert.assertTrue(actualFirstMortgageTotalPaymentColumnValues.isEmpty());
    }










}
