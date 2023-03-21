package untils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseSetup;

import java.util.List;

public class Helper extends BaseSetup {
    public Helper(WebDriver driver) {
        this.driver = driver;
    }
    public void checkImgBroken(int iBrokenImageCount, String status) {
        try {
            iBrokenImageCount = 0;
            List<WebElement> image_list = driver.findElements(By.tagName("img"));
            /* Print the total number of images on the page */
//            System.out.println("The page under test has " + image_list.size() + " images");
//            Log.info("The page under test has " + image_list.size() + " images");
            System.out.println("The page under test has " + image_list.size() + " images");
            for (WebElement img : image_list) {
                if (img != null) {
                    if (img.getAttribute("naturalWidth").equals("0")) {
//                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
//                        Log.info(img.getAttribute("outerHTML") + " is broken.");
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        iBrokenImageCount++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
            System.out.println(e.getMessage());
        }
        status = "passed";
        System.out.println(iBrokenImageCount + " broken images");
//        Log.info(iBrokenImageCount + " broken images");
    }
}
