package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.SeleniumUtils;

public class PersonalInfoExpenses {




    public PersonalInfoExpenses(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "coborrower2")
    private WebElement coborrower;

    @FindBy(id = "b_firstName")
    private WebElement firstName;

    @FindBy(id = "b_lastName")
    private WebElement lastName;

    @FindBy(id = "b_email")
    private WebElement email;

    @FindBy(id = "b_ssn")
    private WebElement SSN;

    @FindBy(id = "b_marital")
    private WebElement maritalStatus;

    @FindBy(id = "b_cell")
    private WebElement cell;

    @FindBy(id = "b_home")
    private WebElement homeNumber;



    @FindBy(id = "privacypolicy")
    private WebElement privatePolicy;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;



    public void fillInPersonalInfoPage ()  {
        SeleniumUtils.jsClick(this.coborrower);
        this.firstName.sendKeys(new Faker().name().firstName());
        this.lastName.sendKeys(new Faker().name().lastName());
        this.email.sendKeys(new Faker().internet().emailAddress());
        this.SSN.sendKeys(new Faker().idNumber().ssnValid());
        new Select(maritalStatus).selectByValue("Married");
        this.cell.sendKeys(new Faker().phoneNumber().cellPhone());
        this.homeNumber.sendKeys(new Faker().phoneNumber().phoneNumber());
        if(!this.privatePolicy.isSelected()){
            this.privatePolicy.click();
        }
        SeleniumUtils.jsClick(this.nextButton);





    }










}
