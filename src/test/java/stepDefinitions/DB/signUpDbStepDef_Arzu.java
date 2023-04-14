package stepDefinitions.DB;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SignUpPageDB_Arzu;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class signUpDbStepDef_Arzu {


    @Then("User enter firstName {string} , lastName {string} , email {string} , password {string} and enter")
    public void userEnterFirstNameLastNameEmailPasswordAndEnter(String firstN, String lastN, String email, String password) {
        new SignUpPageDB_Arzu().SIGNUP(firstN,lastN,email,password);
    }


    @Then("The database should be able to handle without slowing down  the system")
    public void theDatabaseShouldBeAbleToHandleWithoutSlowingDownTheSystem() {

        String expectedName="willie";
        List<Map<String, Object>> result = DBUtils.getListOfMaps("select * from tbl_user where first_name='willie'");
        System.out.println(result);
        Assert.assertEquals(expectedName,result.get(0).get("first_name"));

    }

    @Then("DB should contain the following columns")
    public void db_should_contain_the_following_columns(List<String>list) {

        List<String>expectedColumnNames=new ArrayList<>(list);
        Collections.sort(expectedColumnNames);
        List<String> actualColumnNames = DBUtils.getColumnNames("select * from tbl_user");
        System.out.println(actualColumnNames);
        Collections.sort(actualColumnNames);
        Assert.assertEquals(expectedColumnNames,actualColumnNames);

    }



}
