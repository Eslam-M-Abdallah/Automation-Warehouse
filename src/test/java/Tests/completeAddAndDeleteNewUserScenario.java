package Tests;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.adminPage;
import Pages.dashboardPage;
import Pages.loginPage;

public class completeAddAndDeleteNewUserScenario extends TestesBase{
	loginPage loginObject ;
	dashboardPage dashboardObject ;
	adminPage adminObject ;
	
	public String userName = "Admin";
	public String pass = "admin123";
	public String EmployeeName = "axel  blaze";
	public String passConfirmation = "admin123";
	public String newUserName = "Admin3";
	public String userPassword = "admin123";
	public String searchTarget = "Admin3" ;
    
	@Test (priority = 1 , alwaysRun = true)
	public void userNavigateToAdminPage () {
		loginObject = new loginPage(driver);
		loginObject.userCanLogin(userName, pass);
		dashboardObject = new dashboardPage(driver);
		dashboardObject.clickOnAdminTab();
		String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("admin"));
	}
	
	@Test (dependsOnMethods = {"userNavigateToAdminPage"} , priority = 2)
	public void userAddNewUser () throws AWTException, InterruptedException  
	{
		adminObject = new adminPage(driver);
		String text1 = adminObject.existRecordsNumber.getText().trim() ;
		String numberOnly1 = text1.replaceAll("\\D+", "");
		int initialCount = Integer.parseInt(numberOnly1);
		System.out.println(initialCount);
		adminObject.clickOnAddBtn();
		adminObject.selectUserRole();
		adminObject.selectUserStatus();
		adminObject.fillTheRequiredInputFields(EmployeeName, passConfirmation ,newUserName ,userPassword );
		adminObject.saveTheUserDetails();
		String text2 = adminObject.existRecordsNumber.getText().trim() ;
		String numberOnly2 = text2.replaceAll("\\D+", "");
		int updatedCount  = Integer.parseInt(numberOnly2);
		System.out.println(updatedCount);
		Assert.assertEquals(updatedCount-1 , initialCount);
	}
	
	@Test (priority = 3)
	public void userSearchAndDleteUserName() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")));
		adminObject = new adminPage(driver);
		String text3 = adminObject.existRecordsNumber.getText().trim() ;
		String numberOnly1 = text3.replaceAll("\\D+", "");
		int initialCount2 = Integer.parseInt(numberOnly1);
		System.out.println(initialCount2);
		adminObject.SearchByUserName(searchTarget);
		adminObject.DleteUser();
		driver.navigate().refresh();
		String text4 = adminObject.existRecordsNumber.getText().trim() ;
		String numberOnly2 = text4.replaceAll("\\D+", "");
		int updatedCount2  = Integer.parseInt(numberOnly2);
		System.out.println(updatedCount2);
		Assert.assertEquals(updatedCount2 ,initialCount2-1 );
	}
	
	

}
