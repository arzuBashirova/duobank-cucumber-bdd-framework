package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class HomePageExpensesAndLivingSituation {

    public HomePageExpensesAndLivingSituation(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(name = "login")
    private WebElement singInLink;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;


    public void clickSingUpLink() {
        singInLink.click();
    }

    public void fillSignInField(){
        this.email.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
    }
}
