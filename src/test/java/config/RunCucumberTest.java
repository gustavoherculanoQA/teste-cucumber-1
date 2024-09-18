package config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cenarios",
        glue = "steps",
        plugin = {									            // Plugins Cucumber para possivel integracao com Jenkins
                "pretty",
                "html:target/cucumber/report.html"
        }
)
public class RunCucumberTest {
}