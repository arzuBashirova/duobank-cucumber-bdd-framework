package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.EmploymentAndIncomePageArzu;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class EmploymentAndIncomeStepDefArzu {


    @When("the user signin for sprint")
    public void theUserSigninForSprint() {

        new EmploymentAndIncomePageArzu().signinFor2Sprint();
    }
    @Given("User on the Employment and Income page")
    public void userOnTheEmploymentAndIncomePage() {

        new EmploymentAndIncomePageArzu().getEmploymentIncomePage().click();

    }

    @Then("the page should contains following fields")
    public void the_page_should_contains_following_fields(List<String> expectedFields) {

        List<String> Efields = new ArrayList<>(expectedFields);
        List<String> fields2 = List.of("Employer Name", "Position", "City", "State", "Start Date");
        List<WebElement> elList = new EmploymentAndIncomePageArzu().getListOfFields(fields2);
        List<String> actFieldList = new ArrayList<>();
       SeleniumUtils.waitFor(2);
        for (int i = 0; i < elList.size(); i++) {
            actFieldList.add(elList.get(i).getText());

        }
        Assert.assertEquals(Efields, actFieldList);
    }

    @And("fills out all the fields on preapprovals page")
    public void fillsOutAllTheFieldsOnPreapprovalsPage() {

        new EmploymentAndIncomePageArzu().fillOutPreApprovalPage();
    }

    @And("fills out personal info fields and expenses")
    public void fillsOutPersonalInfoFields() {
        new EmploymentAndIncomePageArzu().fillOutPersonalInfoFieldsandExpenses();
    }

    @When("User left the Employer Name field blank")
    public void user_left_the_employer_name_field_blank() {
        SeleniumUtils.waitFor(5);
        Driver.getDriver().findElement(By.linkText("Next")).click();
        SeleniumUtils.waitFor(5);
    }
    @Then("name field should be required")
    public void name_field_should_be_required() {

        Assert.assertTrue(new EmploymentAndIncomePageArzu().getEmployerNameFieldErrorMessage().isDisplayed());
    }

    @Then("State dropdown should have {int} States")
    public void state_dropdown_should_have_states(Integer numberOfStates) {

        Assert.assertEquals((int)numberOfStates, new EmploymentAndIncomePageArzu().getStateDropDownList().size());
    }

    @Then("checkbox should be unchecked by default")
    public void checkboxShouldBeUncheckedByDefault() {

       // SeleniumUtils.jsClick( new EmploymentAndIncomePageArzu().getCurrentJobCheckBox());
        Assert.assertFalse(new EmploymentAndIncomePageArzu().getCurrentJobCheckBox().isSelected());

    }

    @When("user clicks clear button Employment and Income page")
    public void userClicksClearButtonEmploymentAndIncomePage() {

        new EmploymentAndIncomePageArzu().clickClear();
    }

    @Then("clear option should display")
    public void clearOptionShouldDisplay() {
        Assert.assertTrue(new EmploymentAndIncomePageArzu().getClearPopup().isDisplayed());
    }


    @And("accept the popup message")
    public void acceptThePopupMessage() {

        new EmploymentAndIncomePageArzu().clickYesButtonPopoup();

    }

    @Then("in that section information should be deleted not another pages")
    public void inThatSectionInformationShouldBeDeletedNotAnotherPages() {

        List<String> fields2 = List.of("Employer Name", "Position", "City", "State", "Start Date");
        List<WebElement> listOfFields = new EmploymentAndIncomePageArzu().getListOfFields(fields2);
        List<String> ListOfValues = new ArrayList<>();
        for (int i = 0; i < fields2.size(); i++) {
            ListOfValues.add(listOfFields.get(i).getAttribute("value"));

        }

        System.out.println(ListOfValues);
        List<String> tempExpeted = new ArrayList<>();
        if (ListOfValues.get(0) != null) {
            Assert.fail();
        }


    }

//    @When("user enters invalid information in each field on the page following info")
//    public void user_enters_invalid_information_in_each_field_on_the_page_following_info(List<String> dataTable2) {
//
////        EmploymentAndIncomePageArzu employmentIncome=new EmploymentAndIncomePageArzu();
////        employmentIncome.getEmployerNameField().sendKeys(dataTable2.get(0));
////        employmentIncome.getPositionField().sendKeys(dataTable2.get(1));
////        employmentIncome.getCityField().sendKeys(dataTable2.get(2));
////        Select select =new Select(employmentIncome.getStateField());
////        select.selectByVisibleText(dataTable2.get(3));
////        employmentIncome.getStartDateField().sendKeys(dataTable2.get(4));
////        Assert.assertTrue(employmentIncome.getEmployerNameFieldErrorMessage().isDisplayed());
//
//    }

    @When("User enter username {string} , position {string} , city {string} ,  state {string} and start date {string}")
    public void iEnterUsernamePositionCityStateAndStartDate(String arg0, String arg1, String arg2, String arg3, String arg4) {

       new EmploymentAndIncomePageArzu().sendKeys(arg0,arg1,arg2,arg3,arg4);

    }


}
