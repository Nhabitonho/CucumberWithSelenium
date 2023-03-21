package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BaseSetup;
import pages.HomePage;

import java.awt.*;
import java.io.IOException;

import static pages.BaseSetup.driver;

public class Hooks {
    public static BaseSetup setup;
    public static HomePage homePage;

    public static WebDriver getDriver() {
        return driver;
    }


    @Before
    public static void initSetup() throws AWTException, IOException {
        setup = new BaseSetup();
        setup.setupDriver("chrome");
        homePage = setup.navigateToHomePage();
        // TODO:
        //setup.gobacktoHomePage();
    }


//    @After(order=0) // Cucumber After hook with order 0
//    public  void quitDriver() throws Exception {
//        driver.quit();
//    }


    @After(order = 1) // Cucumber After Hook with order 1
    public void takeScreenShotOnFailedScenario(Scenario scenario) {
        System.out.println("This is from After hook, order=1");
        if ((scenario.isFailed())) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            //embed it in html report
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
        driver.quit();
    }
}
