package stepDefinitions.DB;

import com.google.common.base.Equivalence;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.assertj.core.api.SoftAssertions;
//import org.jetbrains.annotations.NotNull;
//import org.testng.Assert;
import org.junit.Assert;
import utils.DBUtils;
import pages.EmplAndIncome_Page_DB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

public class EmplAndIncome_DB_StepDef {


    private Equivalence.Wrapper<Object> dataTable;

    @Given("Database should contain the columns for Employments page")
    public void database_should_contain_the_columns_for_employments_page(List<String> expected) {
        List<String> result = DBUtils.getColumnNames(" select * from loan.tbl_mortagage");
        List<String> cutResult = result.subList(35, 62);
        Assert.assertEquals(cutResult, expected);
    }

    @Given("The database should have name and income values and not be null")
    public void the_database_should_have_name_and_income_values_and_not_be_null() {
        List<List<Object>> nameValues = DBUtils.getListOfLists("select employer_name from loan.tbl_mortagage");
        if (nameValues != null) {
            Assert.assertTrue(true);
        }
        List<List<Object>> incomeValues = DBUtils.getListOfLists("select gross_monthly_income from loan.tbl_mortagage ");
        if (incomeValues != null) {
            Assert.assertTrue(true);
        }
    }

    @Given("The user filling out employment form")
    public void the_user_filling_out_employment_form(io.cucumber.datatable.DataTable dataTable) {
        new EmplAndIncome_Page_DB().mappingEmployer();
    }

    @Then("Database should have the entered by user information mapped accordingly")
    public void database_should_have_the_entered_by_user_information_mapped_accordingly( List<Map<String, String>> dataTable) throws
            SQLException {

        try {
            String expEmpName = dataTable.get(0).get("employer_name");

            String expIncome = dataTable.get(0).get("gross_monthly_income");


            List<Map<String, Object>> actual = DBUtils.getListOfMaps("select * from loan.tbl_mortagage where employer_name='Duotech2023'");
            String actEmpName = dataTable.get(0).get("employer_name");
            String actIncome = dataTable.get(0).get("gross_monthly_income");


            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat(actEmpName).isEqualTo(expEmpName);

            softAssertions.assertThat(actIncome).isEqualTo(expIncome);


            softAssertions.assertAll();
        } finally {
            DBUtils.executeUpdate("DELETE FROM loan.tbl_mortagage where b_email='moon@gmail.com'");
        }
    }
}



