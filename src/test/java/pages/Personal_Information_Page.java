package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;

import java.util.Random;

public class Personal_Information_Page{
    public Personal_Information_Page(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (name = "email")
    private WebElement email;
    public void sendKeysToEmailField(String keys) {email.sendKeys(keys);}

    @FindBy (name = "password")
    private WebElement password;

    public WebElement getEmail() {return email;}

    public WebElement getPassword() {return password;}

    public void sendKeysToPasswordField(String keys) {password.sendKeys(keys);}

    @FindBy (name = "login")
    public WebElement SignInButton2;
    public void clickOnSignInButton2(){//Mohina, instead of repeating the steps I created only one SignIn method to sign in

        sendKeysToEmailField(ConfigReader.getProperty("email"));
        sendKeysToEmailField(ConfigReader.getProperty("password"));
        SignInButton2.click();
    }

    @FindBy(linkText = "Mortgage Application")
    private WebElement mortgageButton;
    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy(name = "est_purchase_price")
    private WebElement purchasePrice;
    @FindBy(id = "downpayment")
    private WebElement downpayment;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;
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


    public void path(){
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
    }


}
