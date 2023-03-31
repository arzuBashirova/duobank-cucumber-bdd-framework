package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "stepDefinitions",
        stepNotifications = true,  // to display detailed step results
        plugin = {
                "pretty", // adds more detailed output log in the cmd console
                "html:target/basic-report/report.html"  // to generate a basic built-in report
        }

)
public class ExpensesPageRunner {
}
