package stepDefinitions.DB;

import com.beust.jcommander.internal.Maps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
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


        List<Map<String, Object>> actualList = DBUtils.getListOfMaps("Select first_name FROM tbl_user WHERE first_name BETWEEN 'Johnny' AND 'Willie' ORDER BY first_name;");


            System.out.println("actual list : "+actualList);

        List<String>actualList2=new ArrayList<>();
            for (int i = 0; i < actualList.size(); i++) {
                actualList2.add((String) (actualList.get(i).get("first_name")));}
            System.out.println("actual list2 : "+actualList2);

            Collections.sort(expectedList2);
            Collections.sort(actualList2);
            Assert.assertEquals(expectedList2,actualList2 );

        }finally {
             DBUtils.executeUpdate("Delete from tbl_user where first_name between 'Johnny' and 'Willie' order by first_name;");
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


    List<Map<String, Object>> expectedList;
    @When("I send a request to retrieve duplicate usernames")
    public void iSendARequestToRetrieveDuplicateUsernames() {

        expectedList = DBUtils.getListOfMaps("select first_name , count(*) from tbl_user group by first_name having count(*)>1");

    }
    @Then("The result should be empty")
    public void theResultShouldBeEmpty() {

        Assert.assertEquals(0,expectedList.size());
    }

    List<Map<String, Object>> expectedList2;
    @When("I send a request to retrieve duplicate emails")
    public void iSendARequestToRetrieveDuplicateEmails() {
        expectedList2 = DBUtils.getListOfMaps("select email , count(*) from tbl_user group by email having count(*)>1;");
    }

    @Then("The result should be empty right away")
    public void theResultShouldBeEmptyRightAway() {
        Assert.assertEquals(0,expectedList2.size());
    }

    List<String> singleColumnValues;
    @When("I send a request to retrieve created_at column")
    public void iSendARequestToRetrieveCreated_atColumn() {
        singleColumnValues = DBUtils.getSingleColumnValues("created_at", "tbl_user");

    }
    @Then("result should not be null")
    public void resultShouldNotBeNull() {
        Assert.assertTrue(!singleColumnValues.isEmpty());
    }
    String pass;
    String first;
    @When("user enters following credentials to sign up")
    public void user_enters_following_credentials_to_sign_up(List<String> dataTable) {

            first = dataTable.get(0);
            String last = dataTable.get(1);
            String email = dataTable.get(2);
            pass = dataTable.get(3);
            System.out.println("credentials "+first+last+email+pass);
            new SignUpPageDB_Arzu().SIGNUP(first, last, email, pass);

    }

    List<Map<String,Object>> listOfLists;
    @When("I send a request to retrieve the password data from database")
    public void iSendARequestToRetrieveThePasswordDataFromDatabase() {
        listOfLists = DBUtils.getListOfMaps("select password from tbl_user where first_name='"+first+"';");
        System.out.println("password list : "+listOfLists);
    }

    @Then("the data must be encrypted version")
    public void theDataMustBeEncryptedVersion() throws SQLException {

        System.out.println("expected password : "+listOfLists.get(0).get("password"));
        System.out.println("actual password : "+DigestUtils.md5Hex(pass));
        try {
        Assert.assertEquals(listOfLists.get(0).get("password"),DigestUtils.md5Hex(pass));

            System.out.println(listOfLists.get(0).get("password"));
    }finally {
        DBUtils.executeUpdate("Delete from tbl_user where first_name='"+first+"';");
    }
    }
    @When("user enters following credentials to sign up fields")
    public void user_enters_following_credentials_to_sign_up_fields(List<Map<String,String>> dataTable) {

        Map<String, String> data = dataTable.get(0);
        new SignUpPageDB_Arzu().SIGNUP(data.get("first_name"),
                                       data.get("last_name"),
                                       data.get("email"),
                                       data.get("password"));
    }
    @Then("database should have corresponding column names and data")
    public void database_should_have_corresponding_column_names_and_data(List<Map<String,String>> dataTable) throws SQLException {

        String expFirstN=null;
        try{
            expFirstN = dataTable.get(0).get("first_name");
            String expLast = dataTable.get(0).get("last_name");
            String expEmail = dataTable.get(0).get("email");
            String expPass = dataTable.get(0).get("password");

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * from tbl_user where first_name='" + expFirstN + "'");

            String actFirstN = (String)(actual.get(0).get("first_name"));
            String  actLast = (String)(actual.get(0).get("last_name"));
            String  actEmail = (String)(actual.get(0).get("email"));
            String  actPass = (String)(actual.get(0).get("password"));

            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat(actFirstN).isEqualTo(expFirstN);
            softAssertions.assertThat(actLast).isEqualTo(expLast);
            softAssertions.assertThat(actEmail).isEqualTo(expEmail);
            softAssertions.assertThat(actPass).isEqualTo(DigestUtils.md5Hex(expPass));

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_user where first_name='"+expFirstN+"'");
        }
    }
    }


