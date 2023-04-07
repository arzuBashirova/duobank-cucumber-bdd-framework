package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
@Data

public class EmploymentAndIncomePage {


    public EmploymentAndIncomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//span[text()='Employment and Income'])[1]")
    private WebElement employmentIncomePage;

    @FindBy(xpath = "//label[@for='employername1']")
    private WebElement employerNameField;

    @FindBy(xpath = "//label[@for='position1']")
    private WebElement positionField;

    @FindBy(xpath = "//label[@for='city1']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@id='state1']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@id='start_date1']")
    private WebElement startDateField;

    public void checkContainFieldsByText(String text){

        String xpath= "//div[@id='employer1']//label[contains (text(),'"+text+"')]";
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


}
