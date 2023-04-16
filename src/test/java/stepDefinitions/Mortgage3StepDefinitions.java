package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MortgageNigarPage;
import pages.SignInPageNigar;
import utils.Driver;

import java.util.List;

public class Mortgage3StepDefinitions {



    @Given("The user is on the Preapproval Details page")
    public void the_user_is_on_the_preapproval_details_page() {
        SignInPageNigar sign = new SignInPageNigar();
        sign.addEmail();
        sign.addPassword();
        sign.singIn();
        sign.setMortgageApplicationButton();

    }
    @When("user click source of Down Payment dropdown field")
    public void user_click_field() {
        new MortgageNigarPage().getDropDownMenu().click();
    }

    @Then("drop-down menu should have options")
    public void drop_down_menu_should_have_options(List<String> dataTable) {
//        MortgageNigarPage mortgage = new MortgageNigarPage();
//        String actualCheckingSaving = mortgage.getCheckingSaving().getText();
//        String actualEquity = mortgage.getEquity().getText();
//        String actualOtherOptions = mortgage.getOtherOptions().getText();
        System.out.println(dataTable);
        Assert.assertEquals(3, dataTable.size());

//        Assert.assertEquals(dataTable.get(0),actualCheckingSaving);
//        Assert.assertEquals(dataTable.get(1),actualEquity);
//        Assert.assertEquals(dataTable.get(2),actualOtherOptions);

        }

    @When("user checks Additional Funds Available field\"")
    public void user_checks_additional_funds_available_field() {

        new MortgageNigarPage().additonalFunds.click();
    }


    @Then("user should enter a dollar amount with up to two decimal")
    public void user_should_enter_a_dollar_amount_with_up_to_two_decimal() {

        new MortgageNigarPage().addInfoAdditionalFunds();
        new SignInPageNigar().clickNextButton();

       // Assert.assertTrue();

    }

    @When("user clicks Next button")
    public void user_clicks_next_button() {
        new SignInPageNigar().clickNextButton();
    }

    @Then("user should not proceed until all required fields are completed.")
    public void user_should_not_proceed_until_all_required_fields_are_completed() {
       new MortgageNigarPage().getFieldRequiredError().getText();
       Assert.assertTrue(new MortgageNigarPage().getFieldRequiredError().isDisplayed());

    }

    @When("user filled all the required fields")
    public void user_filled_all_the_required_fields() {
       new SignInPageNigar().MortgageInfo();


    }

    @Then("user should be directed to Personal Infomartion page")
    public void user_should_be_directed_to_personal_infomartion_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
    }


    }









