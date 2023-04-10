package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Random;
public class ExpensesPage_Nilu {

    public ExpensesPage_Nilu() {{
        PageFactory.initElements(Driver.getDriver(), this);}}
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
    @FindBy(id = "monthlyrentalpayment-error")
    private WebElement errorMessageRent;
    @FindBy(id = "firtmortagagetotalpayment-error")
    private WebElement errorMessageOwn;
    @FindBy(xpath = "//a[@href='#previous']")
    private WebElement previousButton;
    @FindBy(xpath = "(//li[@role='tab'])[2]")
    private WebElement selectedPage;
    @FindBy(xpath = "//h6[@class='py-50']")
    private WebElement textAfterNextButton;


    public WebElement getExpenses() {return expenses;}
    public WebElement getRentCheckBox() {return rentCheckBox;}
    public WebElement getOwnCheckBox() {return ownCheckBox;}
    public WebElement getErrorMessageRent() {return errorMessageRent;}
    public WebElement getErrorMessageOwn() {return errorMessageOwn;}
    public WebElement getPersonalInfo() {return personalInfo;}
    public WebElement getMonthlyRentalPayment() {return monthlyRentalPayment;}
    public WebElement getMonthlyMortgagePayment() {return monthlyMortgagePayment;}
    public WebElement getTextAfterNextButtonEmployment() {return textAfterNextButton;}

    public void rentCheckBoxClick(){rentCheckBox.click();}
    public void ownCheckBoxClick(){ownCheckBox.click();}
    public void scrollUp(){
        SeleniumUtils.scroll(-200, -200);}
    public void monthlyRentalPaymentCorrectInput(){
        Random random =  new Random();
        int rent = random.nextInt(2501) + 2500;
        monthlyRentalPayment.sendKeys(String.valueOf(rent));
    }
    public void monthlyMortgagePaymentCorrectInput(){
        Random random =  new Random();
        int own = random.nextInt(3501) + 2500;
        monthlyMortgagePayment.sendKeys(String.valueOf(own));
    }
    public void nextClick(){ nextButton.click();}

    public void monthlyRentalPaymentIncorrectInput(){
        monthlyRentalPayment.sendKeys(String.valueOf(-1));
    }
    public void monthlyMortgagePaymentIncorrectInput(){
        monthlyMortgagePayment.sendKeys(String.valueOf(-1));
    }

    public void monthlyRentalPaymentNonNumericInput(){
        monthlyRentalPayment.sendKeys(Keys.BACK_SPACE);
        monthlyRentalPayment.sendKeys(".");
    }
    public void monthlyMortgagePaymentNonNumericInput(){
        monthlyMortgagePayment.sendKeys(Keys.BACK_SPACE);
        monthlyMortgagePayment.sendKeys(".");
    }
    public void previousButtonClick(){previousButton.click();}
}
