package stepDefinitions.ui;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import pages.Credit_Report_Page;
import pages.PreApprovalDetails_Page;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.time.Duration;
import java.util.List;



public class Credit_Report_StepDefinitions {

    @Given("The user is logged in and able to navigate through the pages to get to the Credit Report page")
    public void the_user_is_logged_in_and_able_to_navigate_through_the_pages_to_get_to_the_credit_report_page() {
    }

    @When("The user is signed in, they are able to navigate through the pages")
    public void the_user_is_signed_in_they_are_able_to_navigate_through_the_pages() {
        PreApprovalDetails_Page preApprovalDetails_page = new PreApprovalDetails_Page();
        SeleniumUtils.waitFor(4);
        preApprovalDetails_page.sendKeysToEmailField("farrokh.bulsara@gmail.com");
        SeleniumUtils.waitFor(2);
        preApprovalDetails_page.sendKeysToPasswordField("VWK@uvx2dzw5rgv1kdx");
        SeleniumUtils.waitFor(2);
        preApprovalDetails_page.SignInButton2.click();
        SeleniumUtils.waitFor(2);
        preApprovalDetails_page.clickMortgageApplication();
    }

    @Then("The user is able to get to the Credit Report page")
    public void the_user_is_able_to_get_to_the_credit_report_page() {
        new Credit_Report_Page().CreditReport();
        SeleniumUtils.scrollToElement(new Credit_Report_Page().getCreditReportText());
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new Credit_Report_Page().getCreditReportText().getText()));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new Credit_Report_Page().getYesCheckBox().getText()));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(new Credit_Report_Page().getNoCheckBox().getText()));
    }

    @When("the user is on the required page and chooses yes")
    public void the_user_is_on_the_required_page_and_chooses_yes() {
        new Credit_Report_Page().YesCheckBoxClick();

    }

    @Then("a third party website will open in a new tab")
    public void a_third_party_website_will_open_in_a_new_tab() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php",Driver.getDriver().getCurrentUrl());
    }

    @When("the user chooses no")
    public void the_user_chooses_no() {
        new Credit_Report_Page().NoCheckBoxClick();

    }

    @Then("no third party website is opened")
    public void no_third_party_website_is_opened() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php",Driver.getDriver().getCurrentUrl());
    }
}


