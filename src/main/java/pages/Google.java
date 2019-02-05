package pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Logging;

public class Google {

	Logger log = Logging.getLogger(getClass());

	WebDriver driver = null;

	public Google(WebDriver driver) {
		this.driver = driver;
		driver.get("http://google.com");
		log.info("Getting http://google.com");
	}

	@FindBy(name = "q")
	WebElement SearchField;

	public void search(String query) {
		SearchField.sendKeys(query + Keys.ENTER);
		log.info("Sending Keys " + query + Keys.ENTER);
	}

	public void isLoaded() {
		log.info("Asserting Title ");
		assertEquals("Google", driver.getTitle());
	}

}
