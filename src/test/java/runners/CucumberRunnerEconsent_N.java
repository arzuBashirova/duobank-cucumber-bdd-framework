package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            tags = "@DB_now",
            features = "src/test/resources/DB",
            glue = "stepDefinitions",
            stepNotifications = true,
            dryRun = true,
            plugin = {
                    "pretty",
                    "html:target/basic-report/report.html"}


    )


    public class CucumberRunnerEconsent_N {



    }




