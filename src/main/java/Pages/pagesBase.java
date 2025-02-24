package Pages;

import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pagesBase {
	public  WebDriver driver = Hooks.driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;
	public Alert alert ;
	public Robot robot ;
	public  pagesBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	protected static void clickBtn(WebElement button) {
		button.click();
	}
	protected static void sendTxtToInputTxt(WebElement inputField , String value) 
	{
		inputField.sendKeys(value);
	}
	public void scrollToBottom() 
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,700)");
	}
	public void clearInputText(WebElement elment) 
	{
		elment.clear();
	}
	public void doubleCLick(WebElement element) 
	{
		Actions action = new Actions(driver); 
		action.doubleClick(element).perform();
	}
	
	public void HoverAction(WebElement element) 
	{
		Actions action = new Actions(driver); 
		action.moveToElement(element).perform();
	}
}
