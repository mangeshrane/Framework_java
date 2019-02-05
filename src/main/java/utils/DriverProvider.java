package utils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import config.Config;

public class DriverProvider {

	Logger log = Logging.getLogger(getClass());
	private browser bName = null;

	enum browser {
		CHROME, FIREFOX, EDGE, IE, SAFARI
	}

	ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {

		if (tDriver.get() == null) {
			log.info("Setting driver from config");
			setDriver();
		}

		log.info("getting driver from local driver Manager");
		return tDriver.get();
	}

	public void setDriver() {
		bName = browser.valueOf(Config.get("webdriver.browser").toUpperCase());

		WebDriver driver;
		switch (bName) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", Config.get("webdriver.chrome.driver"));
			log.info("Setting up chromeDriver");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			option.setAcceptInsecureCerts(true);
			log.info("Setting up driver with capabilities");
			driver = new ChromeDriver(option);
			log.info("Chrome Browser Started");
			break;

		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "webdriver.gecko.driver");
			log.info("Setting up firefox driver");
			driver = new FirefoxDriver();
			log.info("Firefox Browser Started");
			break;

		case IE:
			System.setProperty("webdriver.ie.driver", "webdriver.ie.driver");
			log.info("Setting up IE Driver");
			driver = new InternetExplorerDriver();
			log.info("IE Browser Started");
			break;

		case SAFARI:
			driver = new SafariDriver();
			log.info("SAFARI Browser Started");

		default:
			log.info("Setting up chromedriver");
			driver = new ChromeDriver();
			log.info("using deafult Chrome Browser Started");
			break;
		}
		log.info("IMPLICIT WAIT: " + Config.get("webdriver.implicit.wait"));
		driver.manage().timeouts().implicitlyWait(Long.parseLong(Config.get("webdriver.implicit.wait")),
				TimeUnit.SECONDS);
		log.info("Set implicit wait to driver: " + Config.get("webdriver.implicit.wait"));
		tDriver.set(driver);
	}

}
