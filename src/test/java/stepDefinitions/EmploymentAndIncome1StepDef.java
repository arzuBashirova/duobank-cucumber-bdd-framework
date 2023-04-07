package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.EmploymentAndIncomePage;

import java.util.List;

public class EmploymentAndIncome1StepDef {


    @Given("User on the Employment and Income page")
    public void userOnTheEmploymentAndIncomePage() {

        new EmploymentAndIncomePage().getEmploymentIncomePage().click();

    }

    @Then("the page should contains following fields")
    public void the_page_should_contains_following_fields(List<String> expectedFields) {

        EmploymentAndIncomePage employmentAndIncomePage= new EmploymentAndIncomePage();
        String actualemployerNameField= employmentAndIncomePage.getEmployerNameField().getText();
        String actualpositionField= employmentAndIncomePage.getPositionField().getText();
        String actualcityField= employmentAndIncomePage.getCityField().getText();
        String actualstateField= employmentAndIncomePage.getStateField().getText();
        String actualstartDateField= employmentAndIncomePage.getStartDateField().getText();
        List<String>actualFields=List.of(actualemployerNameField,actualpositionField,actualcityField,actualstateField,actualstartDateField);
        System.out.println(actualFields);

        Assert.assertEquals(expectedFields,actualFields);

//        SoftAssertions softAssertions= new SoftAssertions();
//        softAssertions.assertThat(containFields.get(0)).isEqualTo(actualemployerNameField);
//        softAssertions.assertThat(containFields.get(1)).isEqualTo(actualpositionField);
//        softAssertions.assertThat(containFields.get(2)).isEqualTo(actualcityField);
//        softAssertions.assertThat(containFields.get(3)).isEqualTo(actualstateField);
//        softAssertions.assertThat(containFields.get(4)).isEqualTo(actualstartDateField);






    }


    @And("fills out all the fields on preapprovals page")
    public void fillsOutAllTheFieldsOnPreapprovalsPage() {

        new EmploymentAndIncomePage().fillOutPreApprovalPage();
    }

    @And("fills out personal info fields and expenses")
    public void fillsOutPersonalInfoFields() {
        new EmploymentAndIncomePage().fillOutPersonalInfoFieldsandExpenses();
    }
}
