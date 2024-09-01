package stepdefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.LoginPageObject;
import pageobject.SearchPIMPageObject;
import utilities.ReadConfig;

public class LoginSteps extends BaseClass {

	
	@Before
	public void setUp() throws FileNotFoundException
	{
		p=new ReadConfig();
		FileInputStream file=new FileInputStream("config.properties");
		
		log=LogManager.getLogger("LoginSteps");
		
		String browser=p.getBrowser();
		switch(browser.toLowerCase())
		{
		case "chrome":
		WebDriverManager.chromedriver().setup();
	      driver=new ChromeDriver();
	      break;
	      
		case "edge":
		WebDriverManager.edgedriver().setup();
	      driver=new EdgeDriver();
	      break;  
	      
	    default:
	    	driver=null;
	    	break;
	      
		}
		
	      log.info("setUp method executed");
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
            
      loginpage=new LoginPageObject(driver);
      sps=new SearchPIMPageObject(driver);
      
	}

	@When("user opens the URL {string}")
	public void user_opens_the_url(String url) {
       driver.get(url);
       driver.manage().window().maximize();
	}

	
	///////////Login/////////////
	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String useremail, String userpass) {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         loginpage.enterEmail(useremail);
         loginpage.enterPassword(userpass);
	}

	@When("Click on Login")
	public void click_on_login() {
        loginpage.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expected) {
     String actual=driver.getTitle();
     if(actual.equals(expected))
     {
    	 log.warn("Test Passed: Page title matched...");
    	 Assert.assertTrue(true);
     }
     else 
     {
    	 Assert.assertTrue(false);
    	 log.warn("Test Failed: Page title not matched...");
     }
     
	}	

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
         loginpage.logoutButton();
	}
	
	
	
	
	////////////// search scenarios ///////////////////
	
	
	@When("User clicks on PIM option")
	public void user_clicks_on_pim_option() {
		sps.tabPIM();
		sps.tabReports();
	}

	@Then("User should navigate to PIM screen {string}")
	public void user_should_navigate_to_pim_screen(String expected) {
	   String actual=driver.getTitle();
	   System.out.println("Pim screen tile is" +actual);
	   if(actual.equals(expected))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	}

	@When("User enters the Name in search field {string}")
	public void user_enters_the_name_in_search_field(String str) {
           sps.clickAndEnterSearch(str);
	}

	@When("Clicks on Search button")
	public void clicks_on_search_button() {
	    
	}

	@Then("Searched result should get display on the screen")
	public void searched_result_should_get_display_on_the_screen() {
	    
	}
	
	
	//////////// common/////////////

	/*@Then("Close the browser")
	public void close_the_browser() {
      driver.close();
      driver.quit();
	}*/
	
/*	
	@After
	public void tearDown(Scenario sc) throws IOException
	{
		System.out.println("Tear down method executed....");
		if(sc.isFailed()==true)
		{
			String filepath = "C:\\Users\\Admin\\eclipse-workspace\\BDDFrameWorkProject\\Screenshot\\test1.png";
			TakesScreenshot scshoot= ((TakesScreenshot)driver);
			
			//calls getScreenshootAs method to create image file
			File srcfile=scshoot.getScreenshotAs(OutputType.FILE);
			
			//move file to new destination
			File destfile=new File(filepath);
			
			//copy file at destination
			FileUtils.copyFile(srcfile, destfile);
			
		}
		
	}*/
	
	@AfterStep
	public 	void addScreenshot(Scenario sc)
	{
//		if(sc.isFailed())
//		{
			final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//attach image file report(data, media type, name of the attachment)
			sc.attach(screenshot, "image.png", sc.getName());
//       }
	
}

}
