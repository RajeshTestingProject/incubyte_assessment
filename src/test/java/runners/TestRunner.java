package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/features",  // Path to feature files
        glue = {"stepDefinitions"},                   // Path to step definition classes
        plugin = {"pretty", "html:target/cucumber-reports"}// Cucumber report generation

)
public class TestRunner extends AbstractTestNGCucumberTests {
}
