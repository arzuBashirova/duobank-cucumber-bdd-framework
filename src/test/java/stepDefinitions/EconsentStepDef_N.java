package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.EConsentPage_N;
import pages.ExpensesPage;
import pages.Personal_Information_Page;
import pages.SignInPageNigar;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class EconsentStepDef_N {

//    @Given("The user is on the Econsent page")
//    public void theUserIsOnTheEconsentPage() {
//        SignInPageNigar sign = new SignInPageNigar();
//        sign.addEmail();
//        sign.addPassword();
//        sign.singIn();
//        sign.personalInfo();
//        new ExpensesPage().fillMonthlyRentPayBox("2500");
//        sign.clickNextButton();
//        sign.employmentAndIncome();
//        sign.clickNextButton();
//        sign.clickNextButton();
//
//    }
//  @Then("user should see \"Agree\" button selected by default")
//    public void userShouldSeeButtonSelectedByDefault(){
//        EConsentPage_N econsent = new EConsentPage_N();
//       String agreeDefault;
//      agreeDefault = String.valueOf(econsent.agreeClick());
//      Assert.assertTrue("Agree is not selected by default", Boolean.parseBoolean(agreeDefault));
// }
//
//    @When("user don't agree to the terms and conditions of the econsent")
//    public void userDonTAgreeToTheTermsAndConditionsOfTheEconsent() {
//        new EConsentPage_N().UserDontAgree();}
//        @Then("the user should click Don't Agree button")
//    public void theUserShouldClickDonTAgreeButton() {
//        new EConsentPage_N().dontAgreeClick();
//            Assert.assertTrue(new EConsentPage_N().dontAgreeSelected());}
//
//    @When("user selects the Don't Agree button")
//    public void user_selects_the_don_t_agree_button() {
//          }
//
//    @Then("user should be directed back to the main application")
//    public void user_should_be_directed_back_to_the_main_application() {
//        Assert.assertNotEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
//
//    }
//    @When("user selects Agree button")
//    public void user_selects_agree_button() {
//        EConsentPage_N econsent = new EConsentPage_N();
//        econsent.agreeClick();
//
//    }
//    @Then("user should proceed to next section")
//    public void user_should_proceed_to_next_section() {
//        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
//
//    }
//    @When("user don't select any radio buttons")
//    public void user_don_t_select_any_radio_buttons() {
//        SeleniumUtils.waitFor(5);
//        new SignInPageNigar().clickNextButton();
//
//    }
//    @Then("user see an error message")
//    public void user_cannot_submit_econsent() {
//        Assert.assertTrue(new EConsentPage_N().getFieldRequiredMessage().isDisplayed());
//
//
//    }
//
//
//
//
//
//
//
//
}