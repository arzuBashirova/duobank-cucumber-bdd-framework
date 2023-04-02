package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[2]/div/div[3]/a")
    private WebElement signUpLink;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(id = "sign-up-button")
    public WebElement signUpButton;

    @FindBy(tagName = "Welcome Back!")
    public WebElement welcomeBackMessage;





    public void clickSignUpLink() {
        signUpLink.click();
    }


    public void fillTheFormWithRandomData() {
//        Faker faker = new Faker();
        firstName.sendKeys("John");
        lastName.sendKeys("Smith");
        String email = "john.smith@gmail.com";
        this.email.sendKeys(email);
        String password = "123456";
        this.password.sendKeys(password);
    }


    public void clickSignUpButton() {
        signUpButton.click();
    }

    public String getWelcomeBackMessage() {
        return welcomeBackMessage.getText();
    }


}




