package stepDefinitions.DB;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DBUtils;

import java.util.List;

public class ExpensesPageDBStepDef {


    List<String> actualColumnNames;

    @When("I send a request to retrieve user information from tbl_mortagage table")
    public void i_send_a_request_to_retrieve_user_information_from_tbl_mortagage_table() {
        actualColumnNames = DBUtils.getColumnNames("select  * from tbl_mortagage");

    }
    @Then("It should be the following column names")
    public void it_should_be_the_following_column_names(List<String> expectedColumnNames) {

        Assert.assertTrue(actualColumnNames.containsAll(expectedColumnNames));

    }






}
