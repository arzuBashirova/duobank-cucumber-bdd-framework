package pages;

import lombok.Data;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;
@Data
public class EmpAndIncomePage {


    public EmpAndIncomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "employername1")
    private WebElement employerName;

    @FindBy(xpath = "//h6[.='Borrower Gross Monthly Employment Income']")
    private WebElement message;

    @FindBy(xpath = "(//div[@class='form-group']//label[@for='grossmonthlyincome'])[1]")
    private WebElement grossMonthIncomeMessage;

    @FindBy(id = "grossmonthlyincome")
    private WebElement grossMonthIncome;

    @FindBy(id = "grossmonthlyincome-error")
    private WebElement grossMonthIncomeErrorMessage;


    @FindBy(xpath = "(//div[@class='form-group']//label[@for='monthlyovertime'])[1]")
    private WebElement monthlyOverTimeMessage;

    @FindBy(id = "monthlyovertime")
    private WebElement monthlyOverTime;

    @FindBy(xpath = "(//div[@class='form-group']//label[@for='monthlybonuses'])[1]")
    private WebElement monthlyBonusesMessage;

    @FindBy(id = "monthlybonuses")
    private WebElement monthlyBonuses;

    @FindBy(xpath = "(//div[@class='form-group']//label[@for='monthlycommission'])[1]")
    private WebElement monthlyCommissionMessage;

    @FindBy(id = "monthlycommission")
    private WebElement monthlyCommission;

    @FindBy(xpath = "(//div[@class='form-group']//label[@for='monthlydividents'])[1]")
    private WebElement monthlyDividentsMessage;

    @FindBy(id = "monthlydividents")
    private WebElement monthlyDividents;


    @FindBy(xpath = "//div[@class='borrowertotalmonthlyincome']/parent::div")
    private WebElement borrowerTotalMonthIncomemessage;

    @FindBy(xpath = "//p[.='Would you like to order a credit report to help us verify your eligibility for this loan ?']")
    private WebElement preApprovalMemessage;

    @FindBy(xpath = "//div[@class='borrowertotalmonthlyincome']//span")
    private WebElement borrowerTotalMonthIncome;


    @FindBy(xpath = "//select[@name='income_source[]']")
    private List<WebElement> incomeSource;

    @FindBy(xpath = "//input[@name='amount[]']")
    private List<WebElement> amount;


    @FindBy(id = "incomesource1")
    private WebElement incomeSource1;

    @FindBy(id = "incomesource2")
    private WebElement incomeSource2;

    @FindBy(id = "incomesource3")
    private WebElement incomeSource3;


















    public void fieldsSection(String grossMonthIncome, String monthlyOverTime, String monthlyBonuses, String monthlyCommission, String monthlyDividents){
     getGrossMonthIncome().sendKeys(grossMonthIncome);
     getMonthlyOverTime().sendKeys(monthlyOverTime);
     getMonthlyBonuses().sendKeys(monthlyBonuses);
     getMonthlyCommission().sendKeys(monthlyCommission);
     getMonthlyDividents().sendKeys(monthlyDividents);

    }

    public void fillInEmployerName(){
        getEmployerName().sendKeys("wed");
    }

    public int totalNumberPassed(String grossMonthIncome, String monthlyOverTime, String monthlyBonuses, String monthlyCommission, String monthlyDividents){
        int total = Integer.valueOf(grossMonthIncome) + Integer.valueOf(monthlyOverTime) + Integer.valueOf(monthlyBonuses) + Integer.valueOf(monthlyCommission) + Integer.valueOf(monthlyDividents) ;
        return total;

    }

    public void verifyDropDownOptions(WebElement source) {

        List<String> expectedValues = List.of("Select One","Alimony/Child Support", "Social Security/Disability Income", "Unemployment Benefits", "Interest and Dividends", "VA Compensation", "Royalty Payments", "Other Types of Income");
        List<WebElement> options = new Select(source).getOptions();
        List<String> actualValues = new ArrayList<>();

        for (WebElement option : options) {
            actualValues.add(option.getText());

            Assert.assertEquals(expectedValues, actualValues);

        }


    }








}
