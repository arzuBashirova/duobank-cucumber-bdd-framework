package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

@Data

public class EmploymentAndIncomePageArzu {


    public EmploymentAndIncomePageArzu(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//span[text()='Employment and Income'])[1]")
    private WebElement employmentIncomePage;

    @FindBy(id = "employername1")
    private WebElement employerNameField;

    @FindBy(id = "position1")
    private WebElement positionField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "state1")
    private WebElement stateField;

    @FindBy(id = "start_date1")
    private WebElement startDateField;

    @FindBy(xpath = "//label[@id='employername1-error']")
    private WebElement employerNameFieldErrorMessage;

    @FindBy( xpath= "//select[@id='state1']//option")
    private List <WebElement> stateDropDownList;

    @FindBy(xpath = "//label[@for='currentjob1']")
    private WebElement currentJobCheckBox;

    @FindBy(xpath = "//a[@id='clear1']")
    private WebElement clear1;

    public void clickClear(){
        clear1.click();
    }

    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-warning']")
    private WebElement yesButtonPopup;

    public void clickYesButtonPopoup(){
        yesButtonPopup.click();
    }

    @FindBy(xpath = "//div[@class='swal2-container swal2-center swal2-fade swal2-shown']")
    private WebElement clearPopup;

    public WebElement checkContainFieldsByText(String text){

        String xpath= "//div[@id='employer1']//label[contains (text(),'"+text+"')]";

//        SeleniumUtils.jsClick( Driver.getDriver().findElement(By.xpath(xpath)));
        WebElement el= Driver.getDriver().findElement(By.xpath(xpath));

        return el;

    }

    public List<WebElement> getListOfFields(List<String> textsOfField){
        List<WebElement> list=new ArrayList<>();

        for (int i = 0; i < textsOfField.size(); i++) {
            list.add(checkContainFieldsByText(textsOfField.get(i)));
        }
        return list;

    }

    public void signinFor2Sprint(){

        Driver.getDriver().findElement(By.id("email")).sendKeys("casperlee@gmail.com");
        Driver.getDriver().findElement(By.id("password")).sendKeys("casperlee123");
        Driver.getDriver().findElement(By.id("signin")).click();
//        Driver.getDriver().findElement(By.id("email")).sendKeys(ConfigReader.getProperty("email"));
//        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("password"));
//        Driver.getDriver().findElement(By.id("signin")).click();

            }
    public void fillOutPreApprovalPage(){

        Driver.getDriver().findElement(By.xpath("//input[@id='realtorinfo']")).sendKeys("oihgfdfghj");
        Driver.getDriver().findElement(By.xpath("//input[@name='est_purchase_price']")).sendKeys("12345");
        Driver.getDriver().findElement(By.xpath("//input[@id='downpayment']")).sendKeys("123");
        Driver.getDriver().findElement(By.xpath("//input[@name='down_payment_percent']")).sendKeys("12");
        Driver.getDriver().findElement(By.xpath("//input[@id='additionalfunds']")).sendKeys("123");
        Driver.getDriver().findElement(By.linkText("Next")).click();

    }

    public void fillOutPersonalInfoFieldsandExpenses(){
        Driver.getDriver().findElement(By.xpath("//input[@id='b_firstName']")).sendKeys("Eric");
        Driver.getDriver().findElement(By.xpath("//input[@id='b_middleName']")).sendKeys("Fat");
        Driver.getDriver().findElement(By.xpath("//input[@id='b_lastName']")).sendKeys("Cartman");
        Select select=new Select(Driver.getDriver().findElement(By.id("b_suffix")));
        select.selectByIndex(2);
        Driver.getDriver().findElement(By.id("b_email")).sendKeys("ericsouth@gmail.com");
        Driver.getDriver().findElement(By.id("b_dob")).sendKeys("11111999");
        Driver.getDriver().findElement(By.id("b_ssn")).sendKeys("123456789");
        new Select(Driver.getDriver().findElement(By.id("b_marital"))).selectByVisibleText("Married");
        Driver.getDriver().findElement(By.id("b_cell")).sendKeys("1234567899");
        Driver.getDriver().findElement(By.id("b_home")).sendKeys("1234567777");
        Driver.getDriver().findElement(By.linkText("Next")).click();
        Driver.getDriver().findElement(By.id("monthlyrentalpayment")).sendKeys("8000");
        Driver.getDriver().findElement(By.linkText("Next")).click();

    }

    public void sendKeys( String str1, String str2, String str3, String str4, String str5){

        employerNameField.sendKeys(str1);
        positionField.sendKeys(str2);
        cityField.sendKeys(str3);
        Select select= new Select(stateField);
        select.selectByIndex(6);
        startDateField.sendKeys(str5);
    }


}
