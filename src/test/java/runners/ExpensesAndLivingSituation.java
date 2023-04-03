package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions (
        //@smoke and @positive",
        //@smoke or @positive",
        tags = "not @smoke",



        //tags = "@positive",


        features = "src/test/resources",
        glue = "stepDefinitions",

        plugin = {
                "pretty",
                "html:target/basic-report/report.html"  // to generate a basic built-in report
        }



)

public class ExpensesAndLivingSituation {
}
