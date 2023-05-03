package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Random;

public class SignInPageNigar {

    public SignInPageNigar() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(name = "email")
    private WebElement emailAddress;

    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "signin")
    private WebElement SingInButton;


    public void singIn() {
        emailAddress.sendKeys(ConfigReader.getProperty("email"));
        password.sendKeys(ConfigReader.getProperty("password"));
        SingInButton.click();
    }

    public void setMortgageApplicationButton(String mortgageApplicationButton) {
        this.mortgageApplicationButton.click();
    }

    public void MortgageInfo() {
        realtor.sendKeys(new Faker().name().firstName());
        price.sendKeys("270000");
        downPayment.sendKeys("2000");
        downPaymentPercent.sendKeys("2");
        clickNextButton();
    }

    @FindBy(xpath = "(//span[normalize-space()='Mortgage Application'])[1]")
    private WebElement mortgageApplicationButton;

    @FindBy(id = "realtorinfo")
    private WebElement realtor;

    @FindBy(name = "est_purchase_price")
    private WebElement price;

    @FindBy(id = "downpayment")
    private WebElement downPayment;

    @FindBy(name = "down_payment_percent")
    private WebElement downPaymentPercent;


    @FindBy(xpath = "//a[@class = 'btn btn-light-primary'][.='Next']")
    private WebElement nextButton;

    public void clickNextButton() {

        nextButton.click();
    }


    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;
    @FindBy(name = "est_purchase_price")
    private WebElement purchasePrice;
    @FindBy(id = "downpayment")
    private WebElement downpayment;

    @FindBy(id = "b_firstName")
    private WebElement firstName;
    @FindBy(id = "b_lastName")
    private WebElement lastName;
    @FindBy(id = "b_email")
    private WebElement b_email;
    @FindBy(id = "b_ssn")
    private WebElement ssn;
    @FindBy(id = "select2-b_marital-container")
    private WebElement maritalStatus;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchBar;
    @FindBy(id = "b_cell")
    private WebElement phoneNumber;
    @FindBy(id = "b_home")
    private WebElement homeNumber;

    @FindBy(id = "b_dob")
    private WebElement DOB;


    public void employmentAndIncome() {
        employerName.sendKeys(new Faker().job().field());
        position.sendKeys(new Faker().job().position());
        city.sendKeys(new Faker().address().cityName());
        new Select(state).selectByVisibleText("Iowa");
        startDate.sendKeys("04/03/2020");
        grossMontlyIncome.sendKeys("30000");

    }

    @FindBy(xpath = "//label[@for='coborrower1']")

    private WebElement coborrower;


    @FindBy(id = "c_firstName")
    private WebElement coborrowerFirstName;

    @FindBy(id = "c_lastName")
    private WebElement coborrowerLastName;
    @FindBy(id = "c_email")
    private WebElement coborrowerEmail;
    @FindBy(id = "c_dob")
    private WebElement coborrowerDOB;
    @FindBy(id = "ssn")
    private WebElement coborrowerSNN;

    @FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[6]")
    private WebElement coborrowerMaritialstatus;

    @FindBy(xpath = "//input[@role='textbox']")
    private WebElement coborrowerSearchBox;

    @FindBy(id = "c_cell")
    private WebElement CoborrowerCell;


    public void personalInfoDB(String name, String lastName, String name2, String lastName2, String email2) {
        SeleniumUtils.jsClick(coborrower);
        Faker faker = new Faker();
        // Random random =  new Random();
//        mortgageButton.click();
//        realtorInfo.sendKeys(faker.name().username());
//        int housePrice = random.nextInt(500001) + 500000;
//        purchasePrice.sendKeys(String.valueOf(housePrice));
//        int downpaymentPrice = random.nextInt(50001) + 50000;
//        downpayment.sendKeys(String.valueOf(downpaymentPrice));
//        nextButton.click();


        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        b_email.sendKeys(ConfigReader.getProperty("email"));
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
        DOB.sendKeys("01/25/1978");
        coborrowerFirstName.sendKeys(name2);
        coborrowerLastName.sendKeys(lastName2);
        coborrowerEmail.sendKeys(email2);
        coborrowerDOB.sendKeys("05/13/1975");
        coborrowerSNN.sendKeys(faker.numerify("#########"));

        coborrowerMaritialstatus.click();
        coborrowerSearchBox.sendKeys("Single", Keys.ENTER);

        CoborrowerCell.sendKeys(faker.phoneNumber().cellPhone());
        clickNextButton();


    }

    public void personalInfoCOB(String name, String lastName, String name2, String lastName2, String email2) {
        SeleniumUtils.jsClick(coborrower);
        Faker faker = new Faker();

        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        b_email.sendKeys(ConfigReader.getProperty("email"));
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
        DOB.sendKeys("01/25/1978");
      coborrowerInfoDB("Coco","Chanel","chanel@gmail.com","06/28/1989", "123-45-8796");
        clickNextButton();


    }
    public void coborrowerInfoDB(String firstC, String lastC, String email, String dob, String ssn) {
        SeleniumUtils.jsClick(coborrower);
        Faker faker = new Faker();
        coborrowerFirstName.sendKeys(firstC);
        coborrowerLastName.sendKeys(lastC);
        coborrowerEmail.sendKeys(email);
        coborrowerDOB.sendKeys("05/13/1975");
        coborrowerSNN.sendKeys(faker.numerify("#########"));

        coborrowerMaritialstatus.click();
        coborrowerSearchBox.sendKeys("Single", Keys.ENTER);

        CoborrowerCell.sendKeys(faker.phoneNumber().cellPhone());
        clickNextButton();

    }

    public void personalInfo() {
        Faker faker = new Faker();
        Random random = new Random();
        mortgageApplicationButton.click();
        realtorInfo.sendKeys(faker.name().username());
        int housePrice = random.nextInt(500001) + 500000;
        purchasePrice.sendKeys(String.valueOf(housePrice));
        int downpaymentPrice = random.nextInt(50001) + 50000;
        downpayment.sendKeys(String.valueOf(downpaymentPrice));
        nextButton.click();

        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        b_email.sendKeys(ConfigReader.getProperty("email"));
        ssn.sendKeys(faker.numerify("#########"));
        maritalStatus.click();
        searchBar.sendKeys("Married", Keys.ENTER);
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        homeNumber.sendKeys(faker.phoneNumber().cellPhone());
        nextButton.click();
        DOB.sendKeys("01/25/1978");
        nextButton.click();
    }


    @FindBy(id = "co-employername1")
    private WebElement cobEmployer;
    @FindBy(id = "co-position1")
    private WebElement cobPosition;

    @FindBy(id = "co-city")
    private WebElement cobCity;

    @FindBy(id = "co-state1")
    private WebElement cobState;

    @FindBy(id = "co-start_date1")
    private WebElement cobStartDate;

    @FindBy(id = "grossmonthlyincome")
    private WebElement cobGrosMontlyIncome;
    @FindBy(id = "employername1")
    private WebElement employerName;
    @FindBy(id = "position1")
    private WebElement position;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "co-state1")
    private WebElement state;
    @FindBy(id = "start_date1")
    private WebElement startDate;
    @FindBy(id = "grossmonthlyincome")
    private WebElement grossMontlyIncome;

    public void employmentAndIncomeDB() {
        Faker faker = new Faker();
        employerName.sendKeys(faker.job().field());
        position.sendKeys(faker.job().position());
        city.sendKeys(faker.address().cityName());
        state.click();
        state.sendKeys(faker.address().state());
        startDate.sendKeys("04/03/2020");
        grossMontlyIncome.sendKeys("30000");
        cobEmployer.sendKeys(faker.job().field());
        cobPosition.sendKeys(faker.job().position());
        cobCity.sendKeys(faker.address().city());
        cobState.click();
        cobState.sendKeys(faker.address().state());
        cobStartDate.sendKeys("05/02/2014");
        cobGrosMontlyIncome.sendKeys("450000");
        SeleniumUtils.jsClick(nextButton);


    }
}




