package StepsDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features", // Path to your feature files
    glue = "StepsDefinition", // Package where your step definitions are located
    plugin = {"pretty", "html:target/cucumber-reports"}, 
    monochrome = true // Makes the console output readable
)
public class TestRunner {
}
