package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class EmploymentPage_Nilu {

    public EmploymentPage_Nilu(){ PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//fieldset[@id='steps-uid-0-p-3']//div[@id='employer1']//div[@class='form-group']//label")
    private List<WebElement> sixRowsText;
    @FindBy(xpath = "//label[@for='currentjob1']")
    private WebElement currentCheckBox;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;
    @FindBy(id = "employername1-error")
    private WebElement errorNameMessage;
    @FindBy(name = "state[]")
    private WebElement states;

    public WebElement getErrorNameMessage() {return errorNameMessage;}

    public void checkBoxClick(){currentCheckBox.click();}
    public List<String> pageInfo(){
        List<String> info = new ArrayList<>();
        List<String> text = SeleniumUtils.getElementsText(sixRowsText);
        return text;
    }
    public void nextButtonClick(){nextButton.click();}
    public List<String> expectedStates(){
        List<String>  statesCount = List.of("--Select--","Alabama","Alaska","Arizona","Arkansas","California",
                "Colorado","Connecticut","Delaware","District Of Columbia","Florida","Georgia","Hawaii","Idaho","Illinois",
                "Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts",
                "Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire",
                "New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma",
                "Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas",
                "Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming" );

        return statesCount;
    }
    public List <String > actualStates(){
        List <WebElement> statesDropDown = new Select(states).getOptions();
        int optionsCount = new Select(states).getOptions().size();
        List <String> actualModels = new ArrayList<>();

        for(WebElement state : statesDropDown){
            actualModels.add(state.getText());
        }
        return actualModels;
    }

}
