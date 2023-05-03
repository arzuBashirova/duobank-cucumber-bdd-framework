package stepDefinitions.DB;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.*;
import utils.ConfigReader;
import utils.DBUtils;
import utils.SeleniumUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonalInfoStepDefs_DB_N {
    String expectedBorrowerName;
    String borroweLastName;
    String expectedCoborrowerName;
    String coborrowerLastName;
    String coborrowerEmail;



    @When("user logins to the website")
    public void user_logins_to_the_website() {
     new SignUpPageDB_Arzu().SIGNUP("Michael", "Jackson", ConfigReader.getProperty("email"),
             ConfigReader.getProperty("password"));
        SeleniumUtils.waitFor(5);
           new SignInPageNigar().singIn();


    }
    @Then("user should click {string} button")
    public void user_should_click_button(String button) {
        new SignInPageNigar().setMortgageApplicationButton(button);

    }
    @Then("user should fill Preapproval Details info")
    public void user_should_fill_preapproval_details_info() {
        SeleniumUtils.waitFor(2);
        new SignInPageNigar().MortgageInfo();

    }

    @Then("user should fill out borrower's and co-borrower's personal information")
    public void user_should_fill_out_borrower_s_and_co_borrower_s_personal_information() {
        SeleniumUtils.waitFor(2);
                SignInPageNigar sign = new SignInPageNigar();
        Faker faker = new Faker();
        expectedBorrowerName= faker.name().firstName();
         borroweLastName = faker.name().lastName();
        expectedCoborrowerName = faker.name().firstName();

        coborrowerLastName = faker.name().lastName();

        coborrowerEmail = faker.internet().emailAddress();


      sign.personalInfoDB(expectedBorrowerName, borroweLastName, expectedCoborrowerName, coborrowerLastName, coborrowerEmail);

        new ExpensesPage().fillMonthlyRentPayBox("2500");
        sign.clickNextButton();
        sign.employmentAndIncomeDB();
        sign.clickNextButton();
        new EConsentPage_N().EconsentInfoDB(expectedBorrowerName,borroweLastName);
        new EConsentPage_N().clickSubmit();

    }
    @Then("database should store borrower's personal information")
    public void databaseShouldStoreBorrowerSPersonalInformation() throws SQLException {

       List<Map<String, Object>> result = DBUtils.getListOfMaps("select * from tbl_mortagage where b_lastName = '"+borroweLastName+"'");
        System.out.println(result);
        List<Map<String, Object>>result2 = DBUtils.getListOfMaps("select b_firstName from tbl_mortagage where b_firstName = '"+expectedBorrowerName+"'");

        try{
       Assert.assertEquals(expectedBorrowerName,result2.get(0).get("b_firstName"));
        Assert.assertEquals(borroweLastName, result.get(0).get("b_lastName"));
    }finally {
            DBUtils.executeUpdate("delete * from tbl_mortagage where b_lastName = '"+borroweLastName+"' ");
        }
        }

    @Then("database should store co-borrower's personal information")
    public void databaseShouldStoreCoBorrowerSPersonalInformation() throws SQLException {
        List<Map<String, Object>> result = DBUtils.getListOfMaps("select c_firstName, c_lastName, c_email from tbl_mortagage where c_firstName = '" + expectedCoborrowerName + "'");
        System.out.println(result);
//        try {
            Assert.assertEquals(expectedCoborrowerName, result.get(0).get("c_firstName"));
            Assert.assertEquals(coborrowerLastName, result.get(0).get("c_lastName"));
            Assert.assertEquals(coborrowerEmail, result.get(0).get("c_email"));

//        }finally {
//            DBUtils.executeUpdate("delete c_firstName, c_lastName, c_email from tbl_mortagage where c_firstName = ' "+ expectedCoborrowerName+"' ");
      }


    @When("users added personal information")
    public void users_added_personal_information() {

    }
    @Then("database should have columns")
    public void database_should_have_columns(List<String>list) {
        List<String> actualColumnNames = DBUtils.getColumnNames("select apply_co_borrower, b_firstName, b_middleName, b_lastName," +
                " b_suffix, " +
                "b_email, b_dob, b_ssn, b_marital, b_cell, b_home from tbl_mortagage");
            System.out.println(actualColumnNames);
            List<String>expectedColumnNames = new ArrayList<>(list);
            System.out.println(expectedColumnNames);
            Assert.assertEquals(expectedColumnNames,actualColumnNames);


    }


    @When("users added pre-approval details")
    public void usersAddedPreApprovalDetails() {


    }
    @Then("database columns should indicate that")
    public void database_columns_should_indicate_that(List<String> list) {

        List<String>ExpectedColumnNames = new ArrayList<>(list);
        List<String> ActualColumnNames = DBUtils.getColumnNames("select id, realtor_status, realtor_info, loan_officer_status," +
                " purpose_loan, est_purchase_price, down_payment, down_payment_percent," +
                " total_loan_amount, src_down_payment, add_fund_available from tbl_mortagage");

        Assert.assertEquals(ExpectedColumnNames,ActualColumnNames);

    }
    @Then("user should fill out coborrower's information")
    public void user_should_fill_out_coborrower_s_information(List<Map<String, String>> datatable) {
        Map<String, String> data = datatable.get(0);
        new SignInPageNigar().coborrowerInfoDB(data.get("c_firstName"),
                data.get("c_lastName"),
                data.get("c_email"),
                data.get("c_dob"),
                data.get("c_ssn"));

    }

    @Then("the user can see the entered details in the following corresponding columns of the tbl_mortagage table")
    public void the_user_can_see_the_entered_details_in_the_following_corresponding_columns_of_the_tbl_mortagage_table(List<Map<String, String>> dataTable) {

        String expFirst = dataTable.get(0).get("c_firstName");
        String expLast = dataTable.get(0).get("c_lastName");
        String expEmail = dataTable.get(0).get("c_email");
        String expDOB = dataTable.get(0).get("c_dob");
        String expSSN = dataTable.get(0).get("c_ssn");

        List<Map<String, Object>> actual = DBUtils.getListOfMaps("select * from tbl_mortagage where c_firstName = ' "+expFirst+"' ");
        String actualFirst = (String) (actual.get(0).get("c_firstName") );
        String actualLast = (String) (actual.get(0).get("c_lastName") );
        String actualEmail = (String) (actual.get(0).get("c_email") );
        String actualDOB = (String) (actual.get(0).get("c_dob"));
        String actualSSN = (String) (actual.get(0).get("c_ssn") );

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualFirst).isEqualTo(expFirst);
        softAssertions.assertThat(actualLast).isEqualTo(expLast);
        softAssertions.assertThat(actualEmail).isEqualTo(expEmail);
        softAssertions.assertThat(actualDOB).isEqualTo(expDOB);
        softAssertions.assertThat(actualSSN).isEqualTo(expSSN);
        softAssertions.assertAll();
    }


    @And("the name {string} should be cleaned up in the database")
    public void theNameShouldBeCleanedUpInTheDatabase(String name) throws SQLException  {
        DBUtils.executeUpdate("DELETE FROM tbl_mortagage where c_firstName = ' "+name+" ' ");
    }
}
