package stepDefinitions.DB;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SignUpPageDB_Arzu;
import utils.DBUtils;
import utils.SeleniumUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class signUpDbStepDef_Arzu {


    @Then("User enter firstName {string} , lastName {string} , email {string} , password {string} and enter")
    public void userEnterFirstNameLastNameEmailPasswordAndEnter(String firstN, String lastN, String email, String password) {
            new SignUpPageDB_Arzu().SIGNUP(firstN, lastN, email, password);

    }


    @Then("The database should be able to handle without slowing down  the system")
    public void the_database_should_be_able_to_handle_without_slowing_down_the_system(List<String> expectedList) throws SQLException {

        try {

        List<String> expectedList2= new ArrayList<>(expectedList);
        System.out.println("expected"+expectedList2);


        List<Map<String, Object>> actualList = DBUtils.getListOfMaps("Select first_name FROM tbl_user WHERE first_name BETWEEN 'Bruce' AND 'Willie' ORDER BY first_name;");


            System.out.println("actual list : "+actualList);
        List<String>actualList2=new ArrayList<>();
            for (int i = 0; i < actualList.size(); i++) {
                actualList2.add((String) (actualList.get(i).get("first_name")));}
            System.out.println("actual list2 : "+actualList2);

            Collections.sort(expectedList2);
            Collections.sort(actualList2);
            Assert.assertEquals(expectedList2,actualList2);

        }finally {
             DBUtils.executeUpdate("Delete from tbl_user where first_name between 'Bruce1' and 'Willie1' order by first_name;");
        }
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
