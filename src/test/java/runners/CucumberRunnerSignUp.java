package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Scenario1 or @Scenario2 or @Scenario3 or @Scenario4",
        features = "src/test/resources",
        glue = "stepDefinitions",
        stepNotifications = true,
        plugin= {
                "html:target/basic-report/report.html"
        }

)
public class CucumberRunnerSignUp {




}
