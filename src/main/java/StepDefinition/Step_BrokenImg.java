package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Broken_ImgPage;

import static StepDefinition.Hooks.homePage;
import static org.testng.Assert.assertEquals;

public class Step_BrokenImg{
    Broken_ImgPage broken_imgPage;

    @Given("user navigate to the broken img page")
    public void user_navigate_to_the_page() {
        broken_imgPage = homePage.navigateToBrokenImg();
    }

    @When("user check the broken img")
    public void userCheckTheBrokenImg() {
        broken_imgPage.checkImg();
    }
    @And("check title of the page")
    public void check_Title_Of_The_Page() {
        String expTitle = "Broken Images";
        assertEquals(broken_imgPage.verifyHeaderDisplay(),expTitle, "Header is not match!");
        broken_imgPage.goBack();
    }
}
