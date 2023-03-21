package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Add_RemovePage;

import static StepDefinition.Hooks.homePage;
import static org.testng.Assert.assertEquals;

public class Steps_AddRemoveTest {
    Add_RemovePage add_removePage;

    @Given("user navigate to the add and remove page")
    public void user_navigate_to_the_page() {
        add_removePage = homePage.navigateToAddRemoveEle();
    }


    @When("user verify header")
    public void user_Verify_Header() {
        String expTitle = "Add/Remove Elements";
        assertEquals(add_removePage.verifyHeaderDisplay(),expTitle, "Header is not match!");
    }

    @And("check click add and remove function")
    public void check_Click_Add_And_Remove_Function() {
        add_removePage.verifyClickAddRemoveBtn();
        add_removePage.goBack();
    }
}
