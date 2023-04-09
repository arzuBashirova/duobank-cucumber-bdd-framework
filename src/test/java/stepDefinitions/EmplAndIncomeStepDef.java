package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.EmpAndIncomePage;
import pages.ExpensesPage;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class EmplAndIncomeStepDef {




    @When("the user is redirected to the Employment and Income page")
    public void the_user_is_redirected_to_the_employment_and_income_page() {
        SeleniumUtils.waitForVisibility(new EmpAndIncomePage().getMessage(),5);
      Assert.assertTrue(new EmpAndIncomePage().getMessage().isDisplayed());
    }

    @When("the user enters employer name")
    public void the_user_enters_employer_name() {

    }

    @Then("the user should see fields")
    public void the_user_should_see_fields(List <String> dataTable) {

        String grossMonthInc =  new EmpAndIncomePage().getGrossMonthIncomeMessage().getText().substring(0,new EmpAndIncomePage().getGrossMonthIncomeMessage().getText().length()-1);
        String monthlyOvertime = new EmpAndIncomePage().getMonthlyOverTimeMessage().getText();
        String monthlyBonus = new EmpAndIncomePage().getMonthlyBonusesMessage().getText();
        String monthlyCommission = new EmpAndIncomePage().getMonthlyCommissionMessage().getText();
        String monthlyDividents = new EmpAndIncomePage().getMonthlyDividentsMessage().getText();
        String borrowerTotal = new EmpAndIncomePage().getBorrowerTotalMonthIncomemessage().getText();


        Assert.assertEquals(dataTable.get(0),grossMonthInc);
        Assert.assertEquals(dataTable.get(1),monthlyOvertime);
        Assert.assertEquals(dataTable.get(2),monthlyBonus);
        Assert.assertEquals(dataTable.get(3),monthlyCommission);
        Assert.assertEquals(dataTable.get(4),monthlyDividents);
        Assert.assertEquals(dataTable.get(5),borrowerTotal);


    }


    @When("the user enters info as {string} and {string} and {string} and {string} and {string}")
    public void the_user_enters_info_as_and_and_and_and(String grossMonthIncome, String monthlyOverTime, String monthlyBonuses, String monthlyCommission, String monthlyDividents) {
        new EmpAndIncomePage().fillInEmployerName();
        new EmpAndIncomePage().fieldsSection(grossMonthIncome,monthlyOverTime,monthlyBonuses,monthlyCommission,monthlyDividents);
        //System.out.println(new EmpAndIncomePage().totalNumberPassed(grossMonthIncome,monthlyOverTime,monthlyBonuses,monthlyCommission,monthlyDividents));
    }

    @Then("the user clicks next button")
    public void the_user_clicks_next_button() {
        new ExpensesPage().clickNextButton();
        SeleniumUtils.waitForVisibility(new EmpAndIncomePage().getPreApprovalMemessage(), 5);
        Assert.assertEquals( "Would you like to order a credit report to help us verify your eligibility for this loan ?", new EmpAndIncomePage().getPreApprovalMemessage().getText());
    }

    @Then("GROSS MONTHLY INCOME should be a required input field.")
    public void gross_monthly_income_should_be_a_required_input_field() {
        new EmpAndIncomePage().fillInEmployerName();
        new ExpensesPage().clickNextButton();
        SeleniumUtils.waitForVisibility(new EmpAndIncomePage().getGrossMonthIncomeErrorMessage(), 5);
        Assert.assertTrue(new EmpAndIncomePage().getGrossMonthIncomeErrorMessage().isDisplayed());
    }


    @Then("the Borrower Total Monthly Income field should be automatically calculated based on the {string} and {string} and {string} and {string} and {string}.")
    public void the_borrower_total_monthly_income_field_should_be_automatically_calculated_based_on_the_and_and_and_and(String grossMonthIncome, String monthlyOverTime, String monthlyBonuses, String monthlyCommission, String monthlyDividents) {
        int numPassed = new EmpAndIncomePage().totalNumberPassed(grossMonthIncome, monthlyOverTime, monthlyBonuses, monthlyCommission, monthlyDividents);
        String expected = new EmpAndIncomePage().getBorrowerTotalMonthIncome().getText().split(" ")[0];
        Assert.assertEquals(Integer.parseInt(expected),numPassed);
    }


    @Then("Additional Gross Monthly Income section should contain three sets of INCOME SOURCE dropdowns and Amount fields.")
    public void additional_gross_monthly_income_section_should_contain_three_sets_of_income_source_dropdowns_and_amount_fields() {
        int sizeIncomeSource = new EmpAndIncomePage().getIncomeSource().size();
        int sizeAmount = new EmpAndIncomePage().getAmount().size();
        Assert.assertEquals(3,sizeIncomeSource);
        Assert.assertEquals(3,sizeAmount);
    }


    @Then("INCOME SOURCE dropdown should have Alimony Child Support, Social Security Disability Income, Unemployment Benefits, Interest and Dividends, VA Compensation, Royalty Payments and Other Types of Income options.")
    public void income_source_dropdown_should_have_alimony_child_support_social_security_disability_income_unemployment_benefits_interest_and_dividends_va_compensation_royalty_payments_and_other_types_of_income_options() {

  //        new EmpAndIncomePage().verifyDropDownOptions(new EmpAndIncomePage().getIncomeSource1());
//        new EmpAndIncomePage().verifyDropDownOptions(new EmpAndIncomePage().getIncomeSource2());
//        new EmpAndIncomePage().verifyDropDownOptions(new EmpAndIncomePage().getIncomeSource3());


        List<WebElement> options1 = new Select(new EmpAndIncomePage().getIncomeSource1()).getOptions();
        List<String> expectedValues = List.of("Select One","Alimony/Child Support", "Social Security/Disability Income", "Unemployment Benefits", "Interest and Dividends", "VA Compensation", "Royalty Payments", "Other Types of Income");
        List<String> actualValues = new ArrayList<>();
        for (WebElement option : options1) {
            actualValues.add(option.getText());
        }
        Assert.assertEquals(expectedValues, actualValues);


        List<WebElement> options2 = new Select(new EmpAndIncomePage().getIncomeSource2()).getOptions();
        List<String> actualValues2 = new ArrayList<>();
        for (WebElement option : options2) {
            actualValues2.add(option.getText());

        }
        Assert.assertEquals(expectedValues, actualValues2);


        List<WebElement> options3 = new Select(new EmpAndIncomePage().getIncomeSource3()).getOptions();
        List<String> actualValues3 = new ArrayList<>();
        for (WebElement option : options3) {
            actualValues3.add(option.getText());

        }
        Assert.assertEquals(expectedValues, actualValues3);





    }












}
