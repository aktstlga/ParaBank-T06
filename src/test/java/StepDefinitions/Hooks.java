package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    @After
    public void after(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String scenarioName = scenario.getName();

            String dest = System.getProperty("user.dir") + "/screenshots/" + scenarioName + "_" + timeStamp + ".png";
            File destination = new File(dest);

            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved: " + dest);
        }
        GWD.quitDriver();
    }
}