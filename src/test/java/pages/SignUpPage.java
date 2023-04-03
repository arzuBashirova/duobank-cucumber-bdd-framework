package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class SignUpPage {

    public SignUpPage() {
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

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/section/div/div/div/div[1]/div/div[3]/div/div/a")
    public WebElement registrationSignInLink;


    public void clickSignUpLink() {
        signUpLink.click();
    }


    public void fillTheFormWithRandomData() {
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
        String password = faker.internet().password();
        this.password.sendKeys(password);
    }


    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void clickRegistrationSignInLink() {
        registrationSignInLink.click();
    }


}