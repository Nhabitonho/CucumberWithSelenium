package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/Features", glue = {"StepDefinition"}, monochrome = true,
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html",
                "junit:target/XMLReports/xmlReport.xml"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
