package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/java/FeatureFiles/_04_NewAccount.feature",
        glue = "StepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html",
                "json:target/cucumber-reports/json/NewAccountReport.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class _04_NewAccountTestRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("OS", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Tester", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Feature", "US603 - Open New Account");
    }
}
