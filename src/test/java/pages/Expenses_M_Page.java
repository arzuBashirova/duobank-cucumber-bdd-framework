package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Random;

public class Expenses_M_Page {

    public Expenses_M_Page(){PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath = "(//h6[@class='py-50'])[4]")
    private WebElement expenses;
    @FindBy(xpath = "(//h6[@class='py-50'])[2]")
    private WebElement personalInfo;
    @FindBy(xpath = "//label[@for='expense1']")
    private WebElement rentCheckBox;
    @FindBy(xpath = "//label[@for='expense2']")
    private WebElement ownCheckBox;
    @FindBy(id = "monthlyrentalpayment")
    private WebElement monthlyRentalPayment;
    @FindBy(id = "firtmortagagetotalpayment")
    private WebElement monthlyMortgagePayment;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;


    public WebElement getExpenses() {return expenses;}

    public WebElement getRentCheckBox() {return rentCheckBox;}

    public WebElement getOwnCheckBox() {return ownCheckBox;}

    public WebElement getPersonalInfo() {return personalInfo;}

    public WebElement getMonthlyRentalPayment() {return monthlyRentalPayment;}

    public WebElement getMonthlyMortgagePayment() {return monthlyMortgagePayment;}

    public void rentCheckBoxClick(){rentCheckBox.click();}

    public void scrollUp(){SeleniumUtils.scroll(-200, -200);}
    public void monthlyRentalPaymentCorrectInput(){
        Random random =  new Random();
        int rent = random.nextInt(3550) + 3000;
        monthlyRentalPayment.sendKeys(String.valueOf(rent));
    }
    public void monthlyMortgagePaymentCorrectInput(){
        Random random =  new Random();
        int own = random.nextInt(3000) + 500;
        monthlyMortgagePayment.sendKeys(String.valueOf(own));
    }
    public void nextClick(){ nextButton.click();}

}
