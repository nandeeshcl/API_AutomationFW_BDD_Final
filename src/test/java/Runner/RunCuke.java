package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		plugin = { "json:target/cucumber.json", "pretty", "html:target/cucumber.html" },

		features = "./src/test/Feature_Files", glue ="StepDefnitions", monochrome = true
// tags={"@createcustomerapifeature"}

)
public class RunCuke extends AbstractTestNGCucumberTests {

}
