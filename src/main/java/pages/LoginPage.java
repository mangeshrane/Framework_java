package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get("https://www.phptravels.net/admin");
	}

	By username = By.xpath("/html/body/div/form[1]//input[@name='email']");

	By password = By.xpath("/html/body/div/form[1]//input[@name='password']");

	By rememberMe = By.xpath("/html/body/div/form[1]//label/div/ins[@class='iCheck-helper']");

	By forgotPassword = By.xpath("//a[@id='link-forgot']/strong[.='Forget Password']");

	By loginBtn = By.xpath("/html/body/div/form[1]/button[@type='submit']");

	public DashBoard login(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginBtn).click();
		return new DashBoard(driver);
	}
}
