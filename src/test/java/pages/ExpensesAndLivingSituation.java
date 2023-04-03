package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ExpensesAndLivingSituation {

    public ExpensesAndLivingSituation(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath ="//span[@data-i18n='eCommerce']")
    private WebElement mortgageAppLink;

    public void clickMortgageAppLink() {
        this.mortgageAppLink.click();
    }

}
