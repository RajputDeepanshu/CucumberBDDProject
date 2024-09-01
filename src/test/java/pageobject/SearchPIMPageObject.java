package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPIMPageObject {
	
	WebDriver ldriver;
	public SearchPIMPageObject(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='PIM']")
	WebElement PIMtab;
	
	@FindBy(xpath="//a[normalize-space()='Reports']")
	WebElement reportstab;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement searchfield;
	
	@FindBy(xpath="//div[@role='option']")
	WebElement searchsuggestion;
	
	public void tabPIM()
	{
		PIMtab.click();
	}

	public void tabReports()
	{
		reportstab.click();
	}
	
	public void clickAndEnterSearch(String str)
	{
		searchfield.sendKeys(str);
		searchsuggestion.click();
	}

}
