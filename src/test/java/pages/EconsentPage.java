package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import utils.Driver;


public class EconsentPage {


    public EconsentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id=\"steps-uid-0-t-5\"]")
    private WebElement econsentButton;

    @FindBy(xpath = "//*[@id=\"eConsentdeclarerFirstName\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"eConsentdeclarerLastName\"]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"eConsentdeclarerEmail\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-5\"]/ul/li[1]/fieldset/div/label")
    private WebElement agreeButton;


    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-5\"]/ul/li[2]/fieldset/div/label")
    private WebElement dontAgreeButton;

    @FindBy(xpath = "//*[@id=\"steps-uid-0\"]/div[3]/ul/li[2]/a")
    private WebElement nextButton;


    public void fillTheFormWithRandomData() {
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        this.email.sendKeys(email);
    }

    public void clickEconsentButton() {
        econsentButton.click();
    }

    public void clickAgreeButton() {
        agreeButton.click();
    }

    public void clickDontAgreeButton() {
        dontAgreeButton.click();
    }


    public void clickNextButton() {
        nextButton.click();
    }

    public void clickAgreeButtonAndNext() {
        agreeButton.click();
        nextButton.click();
    }

    public void clickDontAgreeButtonAndNext() {
        dontAgreeButton.click();
        nextButton.click();
    }

}