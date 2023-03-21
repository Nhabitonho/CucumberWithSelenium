package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Broken_ImgPage extends BaseSetup {


    @FindBy(xpath = "//*[@id=\"content\"]/div/h3")
    private WebElement title;

    public Broken_ImgPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHeaderDisplay() {
        return title.getText();
    }

    //    public void checkImg() {
//        helper.checkImgBroken(0,"Passed");
//    }
    public void checkImg() {
        helper.checkImgBroken(0,"Passed");
    }


    public void goBack(){
        gobacktoHomePage();
    }
}
