package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data

public class Credit_Report_Page {

    public Credit_Report_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Mortgage Application")
    private WebElement mortgageButton;
    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy(name = "est_purchase_price")
    private WebElement purchasePrice;
    @FindBy(id = "downpayment")
    private WebElement downPayment;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;
    @FindBy(id = "b_firstName")
    private WebElement firstName;
    @FindBy(id = "b_lastName")
    private WebElement lastName;
    @FindBy(id = "b_email")
    private WebElement email;
    @FindBy(id = "b_ssn")
    private WebElement ssn;
    @FindBy(id = "select2-b_marital-container")
    private WebElement maritalStatus;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchBar;
    @FindBy(id = "b_cell")
    private WebElement phoneNumber;
    @FindBy(id = "b_home")
    private WebElement homeNumber;
    @FindBy(id = "b_dob")
    private WebElement dateOfBirth;
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
    @FindBy(name = "gross_monthly_income")
    private WebElement monthlyIncome;

    public WebElement getCreditReportPage() {
        return CreditReportPage;
    }

    @FindBy (xpath = "(//label[@for='firstName12'])[3]")
    private WebElement CreditReportPage;
    public WebElement getYesCheckBox() {
        return YesCheckBox;
    }

    public WebElement getCreditReportText() {
        return CreditReportText;
    }

    @FindBy (xpath = "(//h6[@class='pb-50'])[2]")
    private WebElement CreditReportText;

    @FindBy (xpath = "//label[@for='creditreport1']")
    private WebElement YesCheckBox;

    public WebElement getNoCheckBox() {
        return NoCheckBox;
    }

    @FindBy (xpath = "//label[@for='creditreport2']")
    private WebElement NoCheckBox;

    public void YesCheckBoxClick(){
        YesCheckBox.click();
    }

    public void NoCheckBoxClick(){
        NoCheckBox.click();
    }

    public void page1() {
        Faker faker = new Faker();
        Random random = new Random();
        mortgageButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(500001) + 500000;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downPaymentPrice = random.nextInt(50001) + 50000;
        downPayment.sendKeys(String.valueOf(downPaymentPrice));
        nextButton.click();
    }

    public void page2() {
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        dateOfBirth.sendKeys("04052002");
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Single", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
    }

    public void pathToEmployment() {
        page1();
        page2();
        new Expenses_M_Page().scrollUp();
        new Expenses_M_Page().monthlyRentalPaymentCorrectInput();
        new Expenses_M_Page().nextClick();
    }

    public void CreditReport() {
        Faker faker = new Faker();
        pathToEmployment();
        empName.sendKeys(faker.name().fullName());
        position.sendKeys(faker.company().profession());
        city.sendKeys(faker.address().city());
        state.click();
        state.sendKeys("I", Keys.ENTER);
        startDate.sendKeys(faker.backToTheFuture().date());
        int salary = faker.number().numberBetween(3000, 10000);
        monthlyIncome.sendKeys(String.valueOf(salary));
        nextButton.click();
    }
//        WebElement no = getCreditReport().get(getCreditReport().size() - 1);
//        WebElement yes = getCreditReport().get(2);
//        SeleniumUtils.jsClick(yes);
//        SeleniumUtils.jsClick(no);


//        WebElement yesButton = Driver.findElement(By.id("creditreport1"));
//        WebElement noButton = driver.findElement(By.id("creditreport2"));
//        WebElement element3 = driver.findElement(By.id("someId3"));
//        elements.add(yesButton);
//        elements.add(noButton);
//        elements.add(element3);

//        // Access the WebElements in the list
//        WebElement firstElement = elements.get(0);
//        WebElement secondElement = elements.get(1);

//        SeleniumUtils.waitFor(3);
//        List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox'][@name='creditreport']"));
//        SeleniumUtils.waitFor(3);
//        if (checkboxes.size() < 2) {
//            throw new RuntimeException("Expected at least two checkboxes, but found " + checkboxes.size());
//        }
//        checkboxes.get(0).click();
//        checkboxes.get(1).click();
//////        yesButton.click();
//        return null;
//    }
//
//    public Object CreditReportTwo(){
//        noButton.click();
////        List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox' and (@id='creditreport1' or @id='creditreport2')]"));
////        checkboxes.get(1).click();
//////        noButton.click();
//        return null;
//    }


    }



