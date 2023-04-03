package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MortgageNigarPage {

    public MortgageNigarPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//span[@class = 'select2-selection__arrow']//b[@role = 'presentation'])[2]")
    private WebElement dropDownMenu;
    public WebElement getDropDownMenu() {return dropDownMenu;}



    @FindBy(xpath = "//li[@class = 'select2-results__option select2-results__option--highlighted']")
    private WebElement checkingSaving;
    public WebElement getCheckingSaving() {return checkingSaving;}

    @FindBy(xpath = "//span[@class = 'select2-selection__rendered'][2]")
    private WebElement equity;

    public WebElement getEquity(){return equity;}

    @FindBy(id = "select2-src_down_payment-sf-result-y4c9-Other type of Down Payment")
    private WebElement otherOptions;
    public WebElement getOtherOptions(){return  otherOptions;}


}
