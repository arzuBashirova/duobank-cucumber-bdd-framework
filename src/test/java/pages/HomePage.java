package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id=\"auth-login\"]/div/div/div/div[1]/div/div[2]/div/div[3]/a")
    public WebElement signUpLink;

    @FindBy (id = "inputfirstname4")
    public WebElement firstName;

    @FindBy (id = "inputlastname4")
    public WebElement lastName;

    @FindBy (id = "email")
    public WebElement email;

    @FindBy (id = "exampleInputPassword1")
    public WebElement password;

    @FindBy (id = "register")
    public WebElement signUpButton;

    @FindBy (tagName = "Welcome Back!")
    public WebElement welcomeBackMessage;


    public void clickSignUpLink(){
        signUpLink.click();
    }


    public void fillTheFormWithRandomData(){
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
        String password = faker.internet().password();
        this.password.sendKeys(password);
    }


    public void clickSignUpButton(){
        signUpButton.click();
    }

    public String getWelcomeBackMessage(){
        return welcomeBackMessage.getText();
    }

}
