package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;
import java.util.Random;

public class PreApprovalDetails_Page {

    public PreApprovalDetails_Page(){PageFactory.initElements(Driver.getDriver(), this);}

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

    public void clickMortgageApplication(){
        //mortgageButton.click();
    }

    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy (xpath = "//contains (text(), 'Preapproval Details')")
    WebElement preapprovalDetails;

    public WebElement getPreapprovalDetails() {return preapprovalDetails;}

    @FindBy (xpath = "//*[@id=\"select2-purpose_loan-x3-container\"]")
    List<WebElement> purposeOfLoanDropdown;

    public List<WebElement> getPurposeOfLoanDropdown(){return purposeOfLoanDropdown;}//Assert.assertEquals(3,list.size());

    @FindBy(name = "est_purchase_price")
    private WebElement purchasePrice;

    @FindBy(id = "downpayment")
    private WebElement downpayment;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;

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


//    @FindBy (name = "est_purchase_price")
//    private WebElement estimatedPurchasePrice;
//
//    public WebElement getEstimatedPurchasePrice() {
//        return estimatedPurchasePrice;
//    }
//
//    //  public WebElement getEstimatedPurchasePrice() {estimatedPurchasePrice.sendKeys("2000.50");
//    //    return estimatedPurchasePrice;}
//    public WebElement sendKeysToEstimatedPurchasePrice(){estimatedPurchasePrice.sendKeys("2000.50");
//        return getEstimatedPurchasePrice();}
//    @FindBy (id = "downpayment")
//    WebElement downPayment;
//
//    public WebElement getDownPayment() {downPayment.sendKeys("50.30");
//        return downPayment;}
//
//    @FindBy (name = "down_payment_percent")
//    private WebElement downPaymentPercentage;
//
//    public WebElement getDownPaymentPercentage() {downPaymentPercentage.sendKeys("2.50");//1950
//        return downPaymentPercentage;}
//
//    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-0\"]/div[5]/div")
//    private   WebElement calculatedAmount;
//
//    public WebElement getCalculatedAmount() {calculatedAmount.getText();
//        return calculatedAmount;}
//
//


//    public void sendKeysToPasswordField(String keys){
//        password.sendKeys(keys);
//    }
//    public void sendKeysToEmailField(String keys){
//        email.sendKeys(keys);
//    }

}

    }