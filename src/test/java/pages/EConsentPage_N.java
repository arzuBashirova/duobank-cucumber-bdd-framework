package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class EConsentPage_N {

    public EConsentPage_N(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="(//label[normalize-space()='Agree'])[1]")
    private WebElement agreeButton;

    @FindBy(xpath ="(//label[normalize-space()=\"Don't Agree\"])[1]")
  public WebElement dontAgreeButton;
@FindBy(id = "eConsentdeclarerFirstName")
    private WebElement firstName;
@FindBy(id = "eConsentdeclarerLastName")
    private WebElement lastName;

@FindBy(id = "eConsentdeclarerEmail")
private WebElement email;


    @FindBy(id = "consentagree-error")
private WebElement fieldRequiredMessage;


  public boolean agreeClick() {
           agreeButton.click();
      return true;
  }



    public void UserDontAgree(){
        if (!agreeButton.isSelected()){
        }dontAgreeButton.click();
        System.out.println("User Don't agree with the terms");
    }

    public void dontAgreeClick() {
        SeleniumUtils.waitFor(5);
        firstName.sendKeys(new Faker().name().firstName());
        lastName.sendKeys(new Faker().name().lastName());
        email.sendKeys(new Faker().internet().emailAddress());
       dontAgreeButton.click();
       new SignInPageNigar().clickNextButton();
    }

    public boolean dontAgreeSelected(){
      dontAgreeButton.isSelected();
        return true;
    }

    public WebElement getFieldRequiredMessage() {
        return fieldRequiredMessage;
    }

    public void EconsentInfo(String name, String lastName){

      firstName.sendKeys(name);
      this.lastName.sendKeys(lastName);
      email.sendKeys(ConfigReader.getProperty("email"));
      agreeClick();
      new SignInPageNigar().clickNextButton();
    }

    @FindBy(id = "eConsentdeclarer")
    private WebElement econsentDeclarer;
    public void EconsentInfoDB(String name, String lastName){
        SeleniumUtils.jsClick(econsentDeclarer);
        econsentDeclarer.sendKeys("Borrower");
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        email.sendKeys(ConfigReader.getProperty("email"));
        agreeClick();
        new SignInPageNigar().clickNextButton();
    }

    @FindBy(xpath = "//a[normalize-space()='Submit']")
    private WebElement submitButton;

    public void clickSubmit(){
        submitButton.click();
    }
}
