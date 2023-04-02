package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class ExpensesPage {


    public ExpensesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h6[.='Current Monthly Housing Expenses']")
    private WebElement message;

    @FindBy(xpath = "//input[@type='checkbox'][@name='rent_own_status']")
    private List<WebElement> checkboxes;

    @FindBy(id = "expense1")
    private WebElement rentBox;

    @FindBy(id = "expense2")
    private WebElement ownBox;

    @FindBy(xpath = "//a[.='Save']")
    private WebElement saveButton;

    @FindBy(id = "monthlyrentalpayment")
    private WebElement monthlyRentPayBox;

    @FindBy(id = "monthlyrentalpayment-error")
    private WebElement monthlyRentalPaymentError;










    public WebElement getRentBox() {
        return rentBox;
    }

    public WebElement getOwnBox() {
        return ownBox;
    }



    public WebElement getMessage() {
        return this.message;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public void clickRentBox() {
        SeleniumUtils.jsClick(rentBox);
    }

    public void clickOwnBox() {
        SeleniumUtils.jsClick(ownBox);
    }

    public void clickSaveButton() {
        SeleniumUtils.jsClick(saveButton);
    }

    public void fillMonthlyRentPayBox(String num){
        monthlyRentPayBox.sendKeys(num);
    }

    public WebElement getMonthlyRentalPaymentError() {
        return monthlyRentalPaymentError;
    }

    public void clicklMonthlyRentPayBox(){
       SeleniumUtils.jsClick(monthlyRentPayBox);
    }

    public void clearmonthlyRentPayBox(){
        monthlyRentPayBox.clear();
    }




}
