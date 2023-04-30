package stepDefinitions.api;

import io.restassured.RestAssured;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {



    @Test

    public void firstDemo(){

        //1. Set the Base URI

        baseURI="https://api.github.com";

        //given()

        given().
                header("Accept","*/*").
            //    queryParam("id","34");

        when().log().all().
                get("/users").
                then().log().all().
                statusCode(200);

    }


}
