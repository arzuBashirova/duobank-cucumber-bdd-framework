package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;


import java.util.List;
import java.util.Random;


public class EmplAndIncome_Page_DB {


    public EmplAndIncome_Page_DB() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//fieldset[@id='steps-uid-0-p-3']//div[@id='employer1']//div[@class='form-group']//label")
    private List<WebElement> sixRowsText;
    @FindBy(xpath = "//div[@id='employer2']//div[@class='form-group']//label")
    private List<WebElement> sixRowsText2;
    @FindBy(xpath = "//label[@for='currentjob1']")
    private WebElement currentCheckBox;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;
    @FindBy(id = "employername1-error")
    private WebElement errorNameMessage;
    @FindBy(name = "state[]")
    private WebElement states;
    @FindBy(xpath = "//label[@for='currentjob1']")
    private WebElement currentJobCheckBox;
    @FindBy(id = "clear1")
    private WebElement clear;
    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-warning']")
    private WebElement popUpYes;
    @FindBy(id = "grossmonthlyincome")
    private WebElement income;
    @FindBy(id = "addemployer")
    private WebElement addEmployerButton;
    @FindBy(xpath = "(//a[@href='#employer2'])[2]")
    private WebElement employer2;
    @FindBy(id = "clear2")
    private WebElement clear2;
    @FindBy(id = "remove2")
    private WebElement remove;
    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-warning']")
    private WebElement removerPopUpYes;
    @FindBy(id = "employername1")
    private WebElement empName;
    @FindBy(id = "position1")
    private WebElement position;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "state1")
    private WebElement state;
    @FindBy(id = "start_date1")
    private WebElement startDate;
    @FindBy(id = "end_date1")
    private WebElement endDate;
    @FindBy(xpath = "//div[@id='employer1']//input[@class='form-control']")
    private List<WebElement> fieldsToFillOut;
    @FindBy(xpath = "//label[@for='grossmonthlyincome']")
    private WebElement monthlyIncomeText;
    @FindBy(xpath = "//label[@for='monthlyovertime']")
    private WebElement monthlyOvertimeText;
    @FindBy(xpath = "//label[@for='monthlybonuses']")
    private WebElement monthlyBonusText;
    @FindBy(xpath = "//label[@for='monthlycommission']")
    private WebElement monthlyCommissionText;
    @FindBy(xpath = "//label[@for='monthlydividents']")
    private WebElement monthlyInterestText;
    @FindBy(id = "grossmonthlyincome")
    private WebElement monthlyIncome;
    @FindBy(id = "monthlyovertime")
    private WebElement monthlyOvertime;
    @FindBy(id = "monthlybonuses")
    private WebElement monthlyBonus;
    @FindBy(id = "monthlycommission")
    private WebElement monthlyCommission;
    @FindBy(id = "monthlydividents")
    private WebElement monthlyInterest;
    @FindBy(id = "grossmonthlyincome-error")
    private WebElement incomeError;
    @FindBy(id = "monthlyovertime-error")
    private WebElement overtimeError;
    @FindBy(id = "monthlybonuses-error")
    private WebElement bonusError;
    @FindBy(id = "monthlycommission-error")
    private WebElement commisionError;
    @FindBy(id = "monthlydividents-error")
    private WebElement interestError;
    @FindBy(xpath = "//div[@class='borrowertotalmonthlyincome'] //span")
    private WebElement calculatedNum;
    @FindBy(name = "income_source[]")
    private WebElement incomeSourceDropDown;
    @FindBy(xpath = "//a[@href='#previous']")
    private WebElement previousButton;
    @FindBy(xpath = "(//h6[@class='pb-50'])[2]")
    private WebElement nextPageText;
    @FindBy(xpath = "(//a[@href='#employer2'])[2]")
    private WebElement employer2Text;

    public WebElement getErrorNameMessage() {
        return errorNameMessage;
    }

    public WebElement getCurrentJobCheckBox() {
        return currentJobCheckBox;
    }

    public WebElement getClear() {
        return clear;
    }

    public WebElement getIncome(String s) {
        return income;
    }

    public WebElement getEmployer2() {
        return employer2;
    }

    public WebElement getClear2() {
        return clear2;
    }

    public WebElement getRemove() {
        return remove;
    }

    public List<WebElement> getFieldsToFillOut() {
        return fieldsToFillOut;
    }

    public WebElement getEmpName() {
        return empName;
    }

    public WebElement getPosition() {
        return position;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public WebElement getEndDate() {
        return endDate;
    }

    public WebElement getIncomeError() {
        return incomeError;
    }

    public WebElement getOvertimeError() {
        return overtimeError;
    }

    public WebElement getBonusError() {
        return bonusError;
    }

    public WebElement getCommisionError() {
        return commisionError;
    }

    public WebElement getInterestError() {
        return interestError;
    }

    public WebElement getCalculatedNum() {
        return calculatedNum;
    }

    public WebElement getNextPageText() {
        return nextPageText;
    }

    public WebElement getEmployer2Text() {
        return employer2Text;
    }

    public WebElement getPreviousButton() {
        return previousButton;
    }

    public void cleanNameAndIncome() {
        SeleniumUtils.scroll(-500, -500);
        clearClick();
        popUpClickYes();
        monthlyIncome.clear();
    }

    private void popUpClickYes() {
    }

    private void clearClick() {

    }

    public void fillInNameAndGrossMonthlyIncome() {
        Faker faker = new Faker();
        empName.sendKeys(faker.name().fullName());
        monthlyIncome.sendKeys("5000");


    }

}


