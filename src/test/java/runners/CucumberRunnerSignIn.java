package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//sign In runner
@CucumberOptions(
       // tags = "@SignInTesting",
        features = "src/test/resources",
        glue = "stepDefinitions",
        stepNotifications = true,
        plugin= {
                "html:target/basic-report/report.html"
        }
        //,dryRun = true

)
public class CucumberRunnerSignIn {




}
