package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
         tags = "@this",
            features = "src/test/resources",
            glue = "stepDefinitions",
            stepNotifications = true,
//            dryRun = true,
            plugin = {"html:target/basic-report/report.html"}


    )

    public class CucumberRunnerMortgage3 {



    }


