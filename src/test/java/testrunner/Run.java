package testrunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(
		
		features = ".//Features/Login.feature",
		// features = ".//Features/" (if want to execute all the features)
		// features = {".//Features/Login.feature", ".//Features/searchfeature.feature"} (if want to execute optional features)
		
		glue="stepdefination",
		dryRun= false,
		monochrome = true,
		//tags="@Regression or @Sanity",  // will run scenarios which is tagged with Sanity or Regression
		//tags="@Regression and @Sanity",  // will run scenarios which is tagged with Sanity os well as Regression
		//tags="@Regression and not @Sanity",  // will run scenarios which is tagged with Regression but not Sanity
		
		//plugin = {"com.aventstack:extentreports:5.1.2:"}
		
		plugin = {"pretty", "html:target/Reports/reports1.html"}
		//extent report plugin
		//plugin = {"pretty", "json:target/Reports/reports1.json"}
		//plugin = {"pretty", "junit:target/Reports/reports1_xml.xml"}
		
			// if want all type reports in one go
		//plugin = {"pretty", "html:target/Reports/reports1.html", "json:target/Reports/reports1.json", 
		//              "junit:target/Reports/reports1_xml.xml"} -->
		
		) 

public class Run extends AbstractTestNGCucumberTests {

}
