package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.ABPage;

import static StepDefinition.Hooks.homePage;
import static org.testng.Assert.assertEquals;

public class Steps_ABTesting {
    ABPage abPage;

    @Given("User is on the ABTesting page")
    public void user_navigate_to_the_page() {
        abPage = homePage.navigateToABTesting();
    }

    @And("Check title in ABTesting page")
    public void check_title_in_ABTesting() {
        String expTitle = "A/B Test Variation 1";
        assertEquals(abPage.verifyHeaderDisplay(), expTitle, "Header is not match!");
        abPage.goBack();
    }


}
