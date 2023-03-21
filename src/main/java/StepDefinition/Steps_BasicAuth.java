package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Basic_AuthPage;

import static StepDefinition.Hooks.homePage;
import static org.testng.Assert.assertEquals;

public class Steps_BasicAuth{
    Basic_AuthPage basicAuthPage;

    @Given("user navigate to the Basic auth page")
    public void user_navigate_to_the_page() {
        basicAuthPage = homePage.navigateToBasicAuth();
    }


    @When("user enters the valid username and password")
    public void user_Enters_The_Valid_Username_And_Password() {
        basicAuthPage.verifySendLogin();
    }

    @Then("user is logged in and directed to the Basic auth page")
    public void user_Is_Logged_In_And_Directed_To_The_Basic_Auth_Page() {
        String expTitle = "Congratulations! You must have the proper credentials.";
        assertEquals(basicAuthPage.verifyHeaderDisplay(),expTitle, "Header is not match!");
        basicAuthPage.goBack();
    }
}
