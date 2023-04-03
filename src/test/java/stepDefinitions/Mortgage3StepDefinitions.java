package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MortgageNigarPage;
import pages.SignInPageNigar;

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

    @When("user checks \"Additional Funds Available\"")
    public void user_checks() {

        throw new io.cucumber.java.PendingException();
    }


    @Then("user should enter a dollar amount with up to two decimal")
    public void user_should_enter_a_dollar_amount_with_up_to_two_decimal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    }

