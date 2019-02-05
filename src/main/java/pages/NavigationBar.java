package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
	
	WebDriver driver;
	
	public NavigationBar(WebDriver driver){
		this.driver = driver;
	}

	By profile = By.linkText("Profile");
	By logOut = By.linkText("Log Out");
	
	By search = By.xpath("//input[@id='sidebar-query']");
	By frontEnd = By.xpath("//*[text()='Frontend']");
	By updates = By.xpath("//*[text()='Updates']");
	
	public FrontPage clickFrontEnd(){
		return new FrontPage(driver);
	}
	
	public Updates clickUpdates(){
		return new Updates(driver);
	}
	
	
	
	
}
