package stepdefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageobject.LoginPageObject;
import pageobject.SearchPIMPageObject;
import utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public LoginPageObject loginpage;
	public SearchPIMPageObject sps;
	public static Logger log;
	public ReadConfig p;
	
	//public String randomEmail()
	
	

}
