package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;

public class adminPage extends pagesBase {

	public adminPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (css = "button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addNewUserBtn;
	
	@FindBy (css = "button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
	WebElement searchBtn;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
	public WebElement  existRecordsNumber ;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")
	WebElement userRoleDropDownIcon;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
	WebElement statusDropDownIcon;
	
	@FindBy(css = "input[placeholder = \"Type for hints...\"]")
	WebElement employeeNameInputFields ;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
	WebElement userNameInputField ;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
	WebElement userPasswordInputField ;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
	WebElement confirmPasswordInputFields ;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
	WebElement saveBtn ;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement userNameSearchInputField ;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/label/span")
	WebElement RecordCheckBox;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]")
	WebElement deleteBtn ;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
	WebElement ConfirmDeleteActionBtn ;
	
	
	public void clickOnAddBtn() 
	{
		clickBtn(addNewUserBtn);
	}
	
	public void selectUserRole() throws AWTException, InterruptedException 
	{
		clickBtn(userRoleDropDownIcon);
		robot = new Robot();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void selectUserStatus() throws AWTException, InterruptedException 
	{
		clickBtn(statusDropDownIcon);
		robot = new Robot();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void fillTheRequiredInputFields(String EmployeeName ,String passConfirmation , String userName , String userPassword) throws AWTException, InterruptedException 
	{
		sendTxtToInputTxt(employeeNameInputFields, EmployeeName);
		robot = new Robot();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		
		sendTxtToInputTxt(userNameInputField, userName);
		sendTxtToInputTxt(userPasswordInputField, userPassword);
		sendTxtToInputTxt(confirmPasswordInputFields, passConfirmation);
	}
	
	public void saveTheUserDetails() 
	{
		clickBtn(saveBtn);
	}
	
	public void SearchByUserName(String searchTarget) 
	{
		sendTxtToInputTxt(userNameSearchInputField, searchTarget);
		clickBtn(searchBtn);
	}
	
	
	public void DleteUser() throws InterruptedException 
	{
		clickBtn(RecordCheckBox);
		Thread.sleep(3000);
		clickBtn(deleteBtn);
		Thread.sleep(3000);
		clickBtn(ConfirmDeleteActionBtn);
	}
	
}
