package stepdefination;

import io.cucumber.java.en.Then;

public class CloseSteps extends BaseClass {

	@Then("Close the browser")
	public void close_the_browser() {
      driver.close();	 
      driver.quit();
	}
	
}
