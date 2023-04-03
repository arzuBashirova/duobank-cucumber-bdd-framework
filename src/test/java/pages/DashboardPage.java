package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy(xpath = "//*[@id=\"my-heading\"]")
    WebElement DuoBankLogo;

    public WebElement DuoBankLogo(){return DuoBankLogo;}

    @FindBy(xpath = "/html/body/div[4]")
    WebElement HomePage;

    public WebElement HomePage(){return HomePage;}

    @FindBy(xpath = "/html/body/div[4]/div[2]")
    WebElement MortgageApplication;

    public WebElement MortgageApplication(){return MortgageApplication;}

    @FindBy(xpath = "//*[@id=\"navbar-mobile\"]/ul/li/a/span/img")
    WebElement ProfilePicture;
    public WebElement ProfilePicture(){return ProfilePicture();}


    @FindBy(xpath = "//*[@id=\"navbar-mobile\"]/ul/li/div/a")
    WebElement LogOut;
    public WebElement LogOut(){return LogOut();}

    @FindBy(xpath = "//*[@id=\"auth-login\"]")
    WebElement SignIn;
    public WebElement SignIn(){return SignIn;}


    }

