package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class HomePageExpenses {


    public HomePageExpenses(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(name = "login")
    private WebElement singInLink;

    @FindBy(id = "exampleInputEmail1")
    private WebElement email;

    @FindBy(id = "exampleInputPassword1")
    private WebElement password;


    public void clickSingUpLink() {
        singInLink.click();
    }

    public void fillSignInField(){
        this.email.sendKeys(ConfigReader.getProperty("email"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
    }

}
