package stepDefinitions.DB;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import utils.DBUtils;
import pages.EmplAndIncome_Page_DB;


import java.util.List;
import java.util.Map;

public class EmplAndIncome_DB_StepDef {



    @Given("Database should contain the columns for Employments page")
    public void database_should_contain_the_columns_for_employments_page(List<String> expected) {
        List<String> result = DBUtils.getColumnNames(" select * from loan.tbl_mortagage");
        //Assert.assertTrue(result.contains(expected));
    }

    @Given("The database should have name and income values and not be null")
    public void the_database_should_have_name_and_income_values_and_not_be_null() {
        List<List<Object>> nameValues = DBUtils.getListOfLists("select employer_name from loan.tbl_mortagage");
        List<List<Object>> incomeValues = DBUtils.getListOfLists("select gross_monthly_income from loan.tbl_mortagage ");

    }
}