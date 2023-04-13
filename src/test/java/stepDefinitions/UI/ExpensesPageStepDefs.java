package stepDefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.SeleniumUtils;

public class ExpensesPageStepDefs {




    @When("the user enters valid information including email, password")
    public void the_user_enters_valid_information_including_email_password() throws InterruptedException {

        new HomePageExpenses().fillSignInField();

    }
    @When("clicks on the sign-in button")
    public void clicks_on_the_sign_in_button() {
        new HomePageExpenses().clickSingUpLink();
    }

    @And("clicks on Mortgage Application button")
    public void clicksOnMortgageApplicationButton() {
        new DashboardExpenses().clickMortgageAppLink();
    }

    @And("fills out all the fields")
    public void fillsOutAllTheFields()  {
        new MortgageExpenses().fillInMortgagePage();
    }

    @And("fills out personal info")
    public void fillsOutPersonalInfo()  {
        new PersonalInfoExpenses().fillInPersonalInfoPage();


    }




    @Then("the user is redirected to the expenses page")
    public void theUserIsRedirectedToTheExpensesPage() {
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMessage(),5);
    }
    @Given("the user is on the Expenses page")
    public void the_user_is_on_the_expenses_page() {
        Assert.assertTrue(new ExpensesPage().getMessage().isDisplayed());
    }


    @When("the user should have {int} checkboxes one for Rent and one for Own")
    public void the_user_should_have_checkboxes_one_for_rent_and_one_for_own(Integer numOfCheckboxes) {
        Assert.assertEquals(numOfCheckboxes,Integer.valueOf(new ExpensesPage().getCheckboxes().size()));
    }

    @Then("the user should be able to select only one checkbox.")
    public void the_user_should_be_able_to_select_only_one_checkbox() {
        SeleniumUtils.jsClick(new ExpensesPage().getRentBox());
        Assert.assertTrue(new ExpensesPage().getRentBox().isSelected());
        Assert.assertFalse(new ExpensesPage().getOwnBox().isSelected());

        SeleniumUtils.jsClick(new ExpensesPage().getOwnBox());
        Assert.assertTrue(new ExpensesPage().getOwnBox().isSelected());
        Assert.assertFalse(new ExpensesPage().getRentBox().isSelected());
    }



    @When("the user selects Rent the Monthly Rental Payment field should be required")
    public void the_user_selects_rent_the_monthly_rental_payment_field_should_be_required() {
        SeleniumUtils.jsClick(new ExpensesPage().getRentBox());
    }
    @Then("must be a numeric input field that only allows positive numbers")
    public void must_be_a_numeric_input_field_that_only_allows_positive_numbers()  {
       new ExpensesPage().fillMonthlyRentPayBox("123");
        new ExpensesPage().clickNextButton();
        //Assert.assertFalse(new ExpensesPage().getMessage().isDisplayed());
    }


    @When("must be a numeric input field less then one")
    public void must_be_a_numeric_input_field_less_then_one() {
        new ExpensesPage().clearmonthlyRentPayBox();
        new ExpensesPage().fillMonthlyRentPayBox("-123");
        new ExpensesPage().clickSaveButton();
    }
    @Then("the user should see an error message for input")
    public void the_user_should_see_an_error_message_for_input() {
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMonthlyRentalPaymentError(), 5);
        Assert.assertEquals( "PLEASE ENTER A VALUE GREATER THAN OR EQUAL TO 0.", new ExpensesPage().getMonthlyRentalPaymentError().getText());
    }


    @Then("the user should see an error message for empty input")
    public void the_user_should_see_an_error_message_for_empty_input() {
        new ExpensesPage().clearmonthlyRentPayBox();
        new ExpensesPage().clickSaveButton();
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMonthlyRentalPaymentError(), 5);
        Assert.assertTrue(new ExpensesPage().getMonthlyRentalPaymentError().isDisplayed());
    }






    @When("must be a not numeric input field")
    public void must_be_a_not_numeric_input_field()  {
        new ExpensesPage().clearmonthlyRentPayBox();
        new ExpensesPage().fillMonthlyRentPayBox("String");
        new ExpensesPage().clickSaveButton();
    }
    @Then("the user should see an error message for not numeric input")
    public void the_user_should_see_an_error_message_for_not_numeric_input() {
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMonthlyRentalPaymentError(), 5);
        Assert.assertEquals( "Please enter a valid number.", new ExpensesPage().getMonthlyRentalPaymentError().getText());
    }









}
