package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.Random;

public class PathPage_Nilu {
    public PathPage_Nilu(){
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
    private  WebElement maritalStatus;
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
    @FindBy(id = "eConsentdeclarerFirstName")
    private WebElement firstNameOnConsent;
    @FindBy(id = "eConsentdeclarerLastName")
    private WebElement lastNameOnConsent;
    @FindBy(id = "eConsentdeclarerEmail")
    private WebElement emailConsent;
    @FindBy(xpath = "(//label[@class='custom-control-label'])[1]")
    private WebElement agreeCheckBox;
    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement submitButton;

    public void page1() {
        Faker faker = new Faker();
        Random random = new Random();
        mortgageButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(2000) + 100;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downpaymantPrice = random.nextInt(300) + 200;
        downPayment.sendKeys(String.valueOf(downpaymantPrice));
        nextButton.click();
    }
    public void page2(){
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        dateOfBirth.sendKeys("07221978");
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
    }

    public void pathToEmployment(){
        page1();
        page2();
        new ExpensesPage_Nilu().scrollUp();
        new ExpensesPage_Nilu().monthlyRentalPaymentCorrectInput();
        new ExpensesPage_Nilu().nextClick();
    }

    public void pathToCreditReport(){
        Faker faker = new Faker();
        pathToEmployment();
        empName.sendKeys(faker.name().fullName());
        position.sendKeys(faker.company().profession());
        city.sendKeys(faker.address().city());
        state.click();
        state.sendKeys("I", Keys.ENTER);
        startDate.sendKeys(faker.backToTheFuture().date());
        int salary = faker.number().numberBetween(3000, 17000);
        monthlyIncome.sendKeys(String.valueOf(salary));
        nextButton.click();
    }
    public void pathToEConsent(){
        pathToCreditReport();
        new ExpensesPage_Nilu().scrollUp();
        nextButton.click();
    }

    public void pathToSummeryPage(){
        Faker faker = new Faker();
        pathToEConsent();
        firstNameOnConsent.sendKeys(faker.name().firstName());
        lastNameOnConsent.sendKeys(faker.name().lastName());
        emailConsent.sendKeys(faker.internet().emailAddress());
        agreeCheckBox.click();
        nextButton.click();
    }
    public void finishOfApplication(){
        pathToSummeryPage();
        submitButton.click();
    }
}
