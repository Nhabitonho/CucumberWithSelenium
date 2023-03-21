package pages;

import driverManager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import untils.Helper;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class BaseSetup {
    public static Helper helper;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static SoftAssert softAssert;
    public static Robot robot;
    public static String baseUrl = "https://the-internet.herokuapp.com/";

    public static WebDriver getDriver(){
        return driver;
    }
    public void setupDriver(String browserType) throws AWTException {
        WebDriver driver = DriverFactory.initDriver(browserType);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        robot = new Robot();
        helper = new Helper(driver);
    }
    public HomePage navigateToHomePage() throws IOException {
        driver.get(baseUrl);
        return new HomePage();
    }

    public void gobacktoHomePage() {
        driver.navigate().to(baseUrl);
    }
    public void tearDownDriver() {
        driver.quit();
    }
}
