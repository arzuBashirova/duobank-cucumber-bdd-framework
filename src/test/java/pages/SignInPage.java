package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class SignInPage {


    public SignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h4[.='Welcome Back!']")
    private WebElement welcomeMessage;

    public WebElement getWelcomeMessage() {
        return welcomeMessage;
    }

    @FindBy (xpath = "//input")
    private   List<WebElement> inputFields;

    public List<WebElement> getInputFields() {
        return inputFields;
    }

    @FindBy (name = "email")
    private WebElement email;

    public void sendKeysToEmailField(String keys){
        email.sendKeys(keys);
    }

    @FindBy (name = "password")
    private WebElement password;

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
    private WebElement SignInButton;

    public WebElement getSignInButton() {
        return SignInButton;
    }


    public void clickOnSignInButton(){

        SignInButton.click();
    }
    public void userEnterInvalidEmail(){

        String email= "asdfghjwuytrfv";
        String password= "VWK@uvx2dzw5rgv1kdx";
        sendKeysToEmailField(email);
        sendKeysToPasswordField(password);
    }


    public void signIN(){

        email.sendKeys(ConfigReader.getProperty("email"));
        password.sendKeys(ConfigReader.getProperty("password"));
        clickOnSignInButton();

    }
    public void signINWithJS(){

        email.sendKeys(ConfigReader.getProperty("email"));
        password.sendKeys(ConfigReader.getProperty("password"));
        SeleniumUtils.jsClick(SignInButton);

    }


    @FindBy (xpath = "//small[@class='mr-25']")

    private WebElement question1;

    public WebElement getQuestion1() {
        return question1;
    }

}
