package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLInputElement;
import utils.ConfigReader;
import utils.Driver;

import java.util.Random;

public class SignInPageNigar {

    public SignInPageNigar(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(name ="email")
    private WebElement emailAddress;

    public void addEmail(){
        emailAddress.sendKeys(ConfigReader.getProperty("email"));}

    @FindBy(id = "password")
    private WebElement password;

    public void addPassword(){
        password.sendKeys(ConfigReader.getProperty("password"));}

    @FindBy(id = "signin")
    private WebElement SingInButton;

    public void singIn(){
        SingInButton.click();
    }

    @FindBy(xpath = "//span[@data-i18n='eCommerce']")
    private WebElement mortgageApplicationButton;

    public void setMortgageApplicationButton(){
        mortgageApplicationButton.click();
    }


    @FindBy( id = "realtorinfo")
        private WebElement realtor;

    public void insertRealtorInfo(){
        realtor.sendKeys("Jane Doe");
    }

    @FindBy(name = "est_purchase_price")
    private WebElement price;

    public void addEstimatedPurchase(){price.sendKeys("270000");}

    @FindBy(id = "downpayment")
    private WebElement downPayment;

    public void addDownPayment(){
        downPayment.sendKeys("2000");
    }

    @FindBy(name = "down_payment_percent")
    private WebElement downPaymentPercent;

    public void addDownPaymentPercent(){
        downPaymentPercent.sendKeys("2");

    }
@FindBy(xpath = "//a[@class = 'btn btn-light-primary'][.='Next']")
    private WebElement nextButton;
    public void clickNextButton() {

        nextButton.click();
    }
    @FindBy(xpath = "(//span[normalize-space()='Mortgage Application'])[1]")
    private WebElement mortgageButton;
    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy(name = "est_purchase_price")
    private WebElement purchasePrice;
    @FindBy(id = "downpayment")
    private WebElement downpayment;

    @FindBy(id = "b_firstName")
    private WebElement firstName;
    @FindBy(id = "b_lastName")
    private WebElement lastName;
    @FindBy(id = "b_email")
    private WebElement b_email;
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
    private WebElement DOB;

    @FindBy(id = "employername1")
    private WebElement employerName;
    @FindBy(id = "position1")
    private WebElement position;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "state1")
    private WebElement state;
    @FindBy(id = "start_date1")
    private WebElement startDate;
    @FindBy(id = "grossmonthlyincome")
    private WebElement grossMontlyIncome;


   public void employmentAndIncome(){
        employerName.sendKeys(new Faker().job().field());
        position.sendKeys(new Faker().job().position());
        city.sendKeys(new Faker().address().cityName());
       new Select(state).selectByVisibleText(new Faker().address().state());
       startDate.sendKeys("04/03/2020");
       grossMontlyIncome.sendKeys("30000");

    }
    public void personalInfo(){
        Faker faker = new Faker();
        Random random =  new Random();
        mortgageButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(500001) + 500000;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downpaymentPrice = random.nextInt(50001) + 50000;
        downpayment.sendKeys(String.valueOf(downpaymentPrice));
        nextButton.click();

        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        b_email.sendKeys(faker.internet().emailAddress());
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
        DOB.sendKeys("01/25/1978");
        nextButton.click();
    }
}



