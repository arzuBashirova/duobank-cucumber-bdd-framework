package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

public class MortgageExpenses {


    public MortgageExpenses(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "realtor2")
    private WebElement realtor;

    @FindBy(id = "loanofficer2")
    private WebElement loanOfficer;

    @FindBy(name = "est_purchase_price")
    private WebElement estPurchasePrice;

    @FindBy(id = "downpayment")
    private WebElement downpayment;

    @FindBy(name = "down_payment_percent")
    private WebElement getDownpayment;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;







    public void fillInMortgagePage(){

        SeleniumUtils.jsClick(this.realtor);
        SeleniumUtils.jsClick(this.loanOfficer);
        this.estPurchasePrice.sendKeys("500");
        this.downpayment.sendKeys("100");
        SeleniumUtils.jsClick(this.getDownpayment);
        SeleniumUtils.jsClick(this.nextButton);


    }




}
