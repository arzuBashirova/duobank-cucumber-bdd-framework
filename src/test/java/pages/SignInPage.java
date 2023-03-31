package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SignInPage {


    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h4[.='Welcome Back!']")
    WebElement welcomeMessage;

    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    @FindBy (xpath = "//input")
    List<WebElement> inputFields;

    public List<WebElement> getInputFields() {
        return inputFields;
    }

    @FindBy (name = "email")
    WebElement email;

    public void sendKeysToEmailField(String keys){
        email.sendKeys(keys);
    }

    @FindBy (name = "password")
    WebElement password;

    public WebElement getEmail() {
        return email;
    }
    public WebElement getPassword() {
        return password;
    }

    public void sendKeysToPasswordField(String keys){
        password.sendKeys(keys);
    }
    @FindBy (name = "login")
    WebElement SignInButton;

    public void clickOnSignInButton(){

        SignInButton.click();
    }
    public void userEnterInvalidEmail(){

        String email= "asdfghjwuytrfv";
        String password= "VWK@uvx2dzw5rgv1kdx";
        sendKeysToEmailField(email);
        sendKeysToPasswordField(password);
    }



}
