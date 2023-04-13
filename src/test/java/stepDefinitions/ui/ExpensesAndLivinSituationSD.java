package stepDefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.SeleniumUtils;

public class ExpensesAndLivinSituationSD {

    @When("the user enters valid information including email, password 1")
    public void the_user_enters_valid_information_including_email_password1() throws InterruptedException {

        new HomePageExpenses().fillSignInField();

    }
    @When("clicks on the sign-in button 1")
    public void clicks_on_the_sign_in_button1() {
        new HomePageExpenses().clickSingUpLink();
    }

    @And("clicks on Mortgage Application button 1")
    public void clicksOnMortgageApplicationButton1() {
        new DashboardExpenses().clickMortgageAppLink();
    }

    @And("fills out all the fields 1")
    public void fillsOutAllTheFields1()  {
        new MortgageExpenses().fillInMortgagePage();
    }

    @And("fills out personal info 1")
    public void fillsOutPersonalInfo1()  {
        new PersonalInfoExpenses().fillInPersonalInfoPage();


    }




    @Then("the user is redirected to the expenses page 1")
    public void theUserIsRedirectedToTheExpensesPage1() {
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMessage(),5);
    }
    @Given("the user is on the Expenses page 1")
    public void the_user_is_on_the_expenses_page1() {
        Assert.assertTrue(new ExpensesPage().getMessage().isDisplayed());
    }


    @When("the user should have {int} checkboxes one for Rent and one for Own 1")
    public void the_user_should_have_checkboxes_one_for_rent_and_one_for_own1(Integer numOfCheckboxes) {
        Assert.assertEquals(numOfCheckboxes,Integer.valueOf(new ExpensesPage().getCheckboxes().size()));
    }

    @Then("the user should be able to select only one checkbox. 1")
    public void the_user_should_be_able_to_select_only_one_checkbox1() {
        SeleniumUtils.jsClick(new ExpensesPage().getRentBox());
        Assert.assertTrue(new ExpensesPage().getRentBox().isSelected());
        Assert.assertFalse(new ExpensesPage().getOwnBox().isSelected());

        SeleniumUtils.jsClick(new ExpensesPage().getOwnBox());
        Assert.assertTrue(new ExpensesPage().getOwnBox().isSelected());
        Assert.assertFalse(new ExpensesPage().getRentBox().isSelected());
    }



    @When("the user selects Rent the Monthly Rental Payment field should be required 1")
    public void the_user_selects_rent_the_monthly_rental_payment_field_should_be_required1() {
        SeleniumUtils.jsClick(new ExpensesPage().getRentBox());
    }
    @Then("must be a numeric input field that only allows positive numbers 1")
    public void must_be_a_numeric_input_field_that_only_allows_positive_numbers1()  {
        new ExpensesPage().fillMonthlyRentPayBox("123");
        new ExpensesPage().clickSaveButton();
        Assert.assertFalse(new ExpensesPage().getMessage().isDisplayed());
    }


    @When("must be a numeric input field less then one 1")
    public void must_be_a_numeric_input_field_less_then_one1() {
        new ExpensesPage().clearmonthlyRentPayBox();
        new ExpensesPage().fillMonthlyRentPayBox("-123");
        new ExpensesPage().clickSaveButton();
    }
    @Then("the user should see an error message for input 1")
    public void the_user_should_see_an_error_message_for_input1() {
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMonthlyRentalPaymentError(), 5);
        Assert.assertEquals( "PLEASE ENTER A VALUE GREATER THAN OR EQUAL TO 0.", new ExpensesPage().getMonthlyRentalPaymentError().getText());
    }


    @Then("the user should see an error message for empty input 1")
    public void the_user_should_see_an_error_message_for_empty_input1() {
        new ExpensesPage().clearmonthlyRentPayBox();
        new ExpensesPage().clickSaveButton();
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMonthlyRentalPaymentError(), 5);
        Assert.assertTrue(new ExpensesPage().getMonthlyRentalPaymentError().isDisplayed());
    }






    @When("must be a not numeric input field 1")
    public void must_be_a_not_numeric_input_field()  {
        new ExpensesPage().clearmonthlyRentPayBox();
        new ExpensesPage().fillMonthlyRentPayBox("String");
        new ExpensesPage().clickSaveButton();
    }
    @Then("the user should see an error message for not numeric input 1")
    public void the_user_should_see_an_error_message_for_not_numeric_input() {
        SeleniumUtils.waitForVisibility(new ExpensesPage().getMonthlyRentalPaymentError(), 5);
        Assert.assertEquals( "THIS FIELD IS REQUIRED.", new ExpensesPage().getMonthlyRentalPaymentError().getText());
    }
}
