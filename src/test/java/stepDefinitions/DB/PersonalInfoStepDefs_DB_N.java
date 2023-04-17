package stepDefinitions.DB;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import pages.*;
import utils.ConfigReader;
import utils.DBUtils;
import utils.SeleniumUtils;

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
        expectedCoborrowerName = faker. name().firstName();
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
    @Then("databse should store borrower's and co-borroser's personal information")
    public void databse_should_store_borrower_s_and_co_borroser_s_personal_information() {
        List<List<Object>> resultDB = DBUtils.getListOfLists("select b_firstName from tbl_mortagage where b_firstName='" + expectedBorrowerName + "' ");
        System.out.println(resultDB);
        List<List<Object>> resultDbCob = DBUtils.getListOfLists("select c_firstName from tbl_mortagage where c_firstName = '" + expectedCoborrowerName + " '");
        System.out.println("Coborrower name is " + resultDbCob);
        Assert.assertEquals(expectedBorrowerName, resultDB.get(0).get(0));

        List<Map<String, Object>> result = DBUtils.getListOfMaps("select b_email from tbl_mortagage where b_email='"+ConfigReader.getProperty("email")+"'");
        System.out.println(result);
        Assert.assertEquals(borroweLastName, result.get(0).get("b_lastName"));

    }


    @When("users added personal information")
    public void users_added_personal_information() {

    }
    @Then("database should have columns")
    public void database_should_have_columns(io.cucumber.datatable.DataTable dataTable) {

    }



}
