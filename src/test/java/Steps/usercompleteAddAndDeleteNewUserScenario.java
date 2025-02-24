
package Steps;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.adminPage;
import Pages.dashboardPage;
import Pages.loginPage;
import
Tests.TestesBase;
import io.cucumber.java.en.Given;
import
io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class usercompleteAddAndDeleteNewUserScenario extends TestesBase{
	
	loginPage loginObject;
    dashboardPage dashboardObject;
    adminPage adminObject;

    // Instance variables for data persistence
    private int initialCount;
    private int updatedCount;
    private int initialCount2;
    private int updatedCount2;
    private String newUserName;
    
    @Given("I log in with username {string} and password {string}")
    public void i_log_in_with_username_and_password(String username, String password) {
        loginObject = new loginPage(driver);
        loginObject.userCanLogin(username, password);
    }

    @When("I navigate to the Admin tab")
    public void i_navigate_to_the_admin_tab() {
        dashboardObject = new dashboardPage(driver);
        dashboardObject.clickOnAdminTab();
    }

    @Then("I should be on the Admin page")
    public void i_should_be_on_the_admin_page() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("admin"));
    }

    @Given("I am on the Admin page")
    public void i_am_on_the_admin_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @When("I get the initial number of records")
    public void i_get_the_initial_number_of_records() {
        adminObject = new adminPage(driver);
        String text = adminObject.existRecordsNumber.getText().trim();
        String numberOnly = text.replaceAll("\\D+", ""); 
        initialCount = Integer.parseInt(numberOnly);
        System.out.println("Initial Record Count: " + initialCount);
    }

    @When("I click on the add button")
    public void i_click_on_the_add_button() {
        adminObject.clickOnAddBtn();
    }

    @When("I select a user role")
    public void i_select_a_user_role() throws AWTException, InterruptedException {
        adminObject.selectUserRole();
    }

    @When("I select user status")
    public void i_select_user_status() throws AWTException, InterruptedException {
        adminObject.selectUserStatus();
    }

    @When("I fill in the required fields with employee name {string}, password {string}, new username {string}, and user password {string}")
    public void i_fill_in_the_required_fields(String employeeName, String password, String newUser, String userPassword) throws AWTException, InterruptedException {
        //this.newUserName = newUser; // Store for later use
        adminObject.fillTheRequiredInputFields(employeeName, password, newUser, userPassword);
    }

    @When("I save the user details")
    public void i_save_the_user_details() {
        adminObject.saveTheUserDetails();
    }

    @Then("the number of records should increase by 1")
    public void the_number_of_records_should_increase_by_1() {
    	adminObject = new adminPage(driver);
        String text = adminObject.existRecordsNumber.getText().trim();
        String numberOnly = text.replaceAll("\\D+", "");
        updatedCount = Integer.parseInt(numberOnly);
        System.out.println("Updated Record Count: " + updatedCount);
        Assert.assertEquals(updatedCount-1, initialCount);
    }

    @When("I get the current number of records")
    public void i_get_the_current_number_of_records() {
    	adminObject = new adminPage(driver);
        String text = adminObject.existRecordsNumber.getText().trim();
        String numberOnly = text.replaceAll("\\D+", "");
        initialCount2 = Integer.parseInt(numberOnly);
        System.out.println("Current Record Count Before Deletion: " + initialCount2);
    }

    @When("I search for the user {string}")
    public void i_search_for_the_user(String searchTarget) {
        adminObject.SearchByUserName(searchTarget);
    }

    @When("I delete the user")
    public void i_delete_the_user() throws InterruptedException {
        adminObject.DleteUser();
    }

    @When("I refresh the page")
    public void i_refresh_the_page() {
        driver.navigate().refresh();
    }

    @Then("the number of records should decrease by 1")
    public void the_number_of_records_should_decrease_by_1() {
    	adminObject = new adminPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")));

        String text = adminObject.existRecordsNumber.getText().trim();
        String numberOnly = text.replaceAll("\\D+", "");
        updatedCount2 = Integer.parseInt(numberOnly);
        System.out.println("Updated Record Count After Deletion: " + updatedCount2);
        Assert.assertEquals(updatedCount2, initialCount2 - 1);
    }

}
