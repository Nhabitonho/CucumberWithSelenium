package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Form_AuthPage;

import static StepDefinition.Hooks.homePage;
import static org.testng.Assert.assertEquals;

public class Steps_FormAuth {
    Form_AuthPage form_authPage;

    @Given("user navigate to the form auth page")
    public void user_navigate_to_the_page() {
        form_authPage = homePage.navigateToFromAuth();
    }

    @When("^user enters the valid \"(.*)\" and \"(.*)\"$")
    public void user_Enters_The_Valid_username_And_password(String userName, String passWord) {
        System.out.println("input userName");
        form_authPage.loginStep(userName, passWord);
        System.out.println("input password");
    }

    @And("clicks on login button")
    public void clicks_On_Login_Button() {
        form_authPage.clickLogin();
    }

    @Then("user is logged in and directed to the form auth page")
    public void user_Is_Logged_In_And_Directed_To_The_Form_Auth_Page() {
        String oriTitle = form_authPage.getTitle();
        String expTitle = "You logged into a secure area!\n" +
                "×";
        assertEquals(oriTitle, expTitle, "Header is not match!");
    }

    @When("user click logout button")
    public void user_Click_Logout_Button() {
        form_authPage.logoutStep();
    }

    @Then("user is logout the form auth page")
    public void user_Is_Logout_The_Form_Auth_Page() {
        String oriTitle = form_authPage.getTitle();
        String expTitle = "You logged out of the secure area!\n" +
                "×";
        assertEquals(oriTitle,expTitle, "Header is not match!");
        form_authPage.goBack();
    }
}
