package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
tags = "@estPrice",
        features = "src/test/resources",
        glue = "stepDefinitions",
        stepNotifications = true,
        plugin= {
                "pretty",
                "html:target/basic-report/report.html"
        }

)
public class CucumberRunnerPreapprovalDetails{




}
