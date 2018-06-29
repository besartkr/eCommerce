package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty","html:target/html/"},
        features = {"" + "src/test/java/features"},
        glue = {"steps"},
        tags = "@test")


public class TestRunner extends AbstractTestNGCucumberTests {

}
