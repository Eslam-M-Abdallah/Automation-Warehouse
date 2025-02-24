package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends pagesBase {

	public loginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (name = "username")
	WebElement UserNameInputField ;
	
	@FindBy (name = "password")
	WebElement passwordInputField ;
	
	@FindBy (css = "button[type = \"submit\"]")
	WebElement loginBtn ;
	
	public void userCanLogin(String userName , String pass) 
	{
		sendTxtToInputTxt(UserNameInputField, userName);
		sendTxtToInputTxt(passwordInputField, pass);
		clickBtn(loginBtn);
	}
	
}
