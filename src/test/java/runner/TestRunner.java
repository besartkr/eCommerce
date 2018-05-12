package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by Karthik on 10/26/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"" +"src/test/java/features"} ,
        glue = {"steps"},
        tags = "@test")



public class TestRunner extends  AbstractTestNGCucumberTests{

}
