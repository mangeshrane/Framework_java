package stepDefs;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Google;
import utils.DriverProvider;
import utils.Logging;

public class FirstWebSteps {
	
	WebDriver driver = null;
	Google google = null;
	
	Logger log = Logging.getLogger(getClass());
	
	@Before("@web")
	public void setUp() {
		driver = new DriverProvider().getDriver();
	}
	
	@Given("^the user is on search Page$")
	public void the_user_is_on_search_Page() throws Throwable {
		google = PageFactory.initElements(driver, Google.class);
		google.isLoaded();
	}
	
	@Given("^I am on the Google search page$")
	public void i_am_on_the_Google_search_page() throws Throwable {
		// handled in background
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String query) throws Throwable {
		google.search(query);
	}

	@Then("^the page title should start with \"([^\"]*)\"$")
	public void the_page_title_should_start_with(String title) throws Throwable {
		assertTrue(driver.getTitle().toLowerCase().startsWith(title));
	}
	
	@After("@web")
	public void tearDown() {
		driver.quit();
	}
}
