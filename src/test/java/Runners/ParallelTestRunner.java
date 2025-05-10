package Runners;

import Utilities.GWD;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class ParallelTestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browserType")
    public void beforeClass(String browser) {
        GWD.threadBrowserName.set(browser);
    }
}
