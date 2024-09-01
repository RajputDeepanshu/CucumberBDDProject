package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	//created a WebDriver object
	WebDriver ldriver;

	//Now we will create a constructor
	public LoginPageObject(WebDriver rdriver)
	{
         //inside constructor will assign rdriver into local driver to object lsriver
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passfield;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbttn;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement profiledrpdwn;
	
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutbttn; 
	
	
	public void enterEmail(String str)
	{
		emailfield.sendKeys(str);
	}
	
	public void enterPassword(String str)
	{
		passfield.sendKeys(str);
	}
	
	public void clickLogin()
	{
		loginbttn.click();
	}
	
	public void logoutButton()
	{
		profiledrpdwn.click();
		logoutbttn.click();
	}
	
}
