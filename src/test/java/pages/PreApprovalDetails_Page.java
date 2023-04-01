package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class PreApprovalDetails_Page {

    public PreApprovalDetails_Page(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (xpath = "//contains (text(), 'Preapproval Details')")
    WebElement preapprovalDetails;

    public WebElement getPreapprovalDetails() {return preapprovalDetails;}

    @FindBy (xpath = "//*[@id=\"select2-purpose_loan-x3-container\"]")
    List<WebElement> purposeOfLoanDropdown;

    public List<WebElement> getPurposeOfLoanDropdown(){return purposeOfLoanDropdown;}//Assert.assertEquals(3,list.size());

    @FindBy (name = "est_purchase_price")
    WebElement estimatedPurchasePrice;

    public WebElement getEstimatedPurchasePrice() {estimatedPurchasePrice.sendKeys("2000.50");
        return estimatedPurchasePrice;}

    @FindBy (id = "downpayment")
    WebElement downPayment;

    public WebElement getDownPayment() {downPayment.sendKeys("50.30");
        return downPayment;}

    @FindBy (name = "down_payment_percent")
    WebElement downPaymentPercentage;

    public WebElement getDownPaymentPercentage() {downPaymentPercentage.sendKeys("2.50");//1950
        return downPaymentPercentage;}

    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-0\"]/div[5]/div")
    WebElement calculatedAmount;

    public WebElement getCalculatedAmount() {calculatedAmount.getText();
    return calculatedAmount;}
}
