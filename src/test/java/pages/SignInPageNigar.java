package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class SignInPageNigar {

    public SignInPageNigar(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(id="email")
    private WebElement emailAddress;

    public void addEmail(){
        emailAddress.sendKeys(ConfigReader.getProperty("username"));}

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




    }



