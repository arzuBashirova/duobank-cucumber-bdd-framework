package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DBUtils;
import utils.Driver;
@Data
public class SignUpPageDB_Arzu {


    public SignUpPageDB_Arzu() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "Sign up")
    private WebElement signUpLink;
    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "exampleInputPassword1")
    private WebElement password;

    @FindBy(id = "sign-up-button")
    private WebElement signUpButton;


    public void SIGNUP(String first, String last, String email, String password){

        signUpLink.click();
        this.firstName.sendKeys(first);
        this.lastName.sendKeys(last);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signUpButton.click();



    }


}
