package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Driver;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;

import javax.swing.*;


public class DashboardStepDefinitions {

    @Given("the user is on the Mortgage Application page")
    public void the_user_is_on_the_Mortgage_Application_page() {

    }

    @When("the user clicks on DuoBank logo")
    public void the_user_clicks_on_DuoBank_logo() {
        Assert.assertTrue(new DashboardPage().DuoBankLogo().isSelected());
    }

    @Then("the user is redirected to the main page of DuoBank")
    public void the_user_is_redirected_to_the_main_page_of_DuoBank() {
        Assert.assertEquals(true, new DashboardPage().HomePage());

    }

    @Given("the user is on the main page")
    public void the_user_is_on_the_main_page() {

    }

    @When("the user clicks on profile picture on the right corner of the page")
    public void the_user_clicks_on_profile_picture_on_top_right_corner_of_the_page() throws InterruptedException {
        new DashboardPage().ProfilePicture();


    }


    @And("the user clicks on the Logout link")
    public void the_user_clicks_on_the_Logout_link() throws InterruptedException {
        new DashboardPage().LogOut();
    }


    @Then("the user is redirected out the system to the sign in page")
    public void the_user_is_redirected_out_the_system_to_the_sign_in_page() {

    }
}


