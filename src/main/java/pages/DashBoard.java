package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard extends NavigationBar {

	WebDriver driver;

	public DashBoard(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By accounts = By.xpath(
			"//body/div[@class='wrapper']/aside[@class='social-sidebar']/div/div[6]/div[@class='menu-content']/ul[@id='social-sidebar-menu']//a[@href='#ACCOUNTS']");
	
	public By checkpoint = By.xpath("/html//ul[@id='social-sidebar-menu']//a[@href='https://www.phptravels.net/admin']/strong[.='Dashboard']");
	
	public Accounts clickAccounts(WebDriver driver) {
		driver.findElement(this.accounts).click();
		return new Accounts(driver);
	}
	
	public class Accounts {

		private WebDriver driver;

		public Accounts(WebDriver driver) {
			this.driver = driver;
		}

		By ADMINS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/admins/']");
		By SUPPLIERS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/admins/']");
		By CUSTOMERS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/customers/']");
		By GUESTCUSTOMERS = By.xpath("//ul[@id='ACCOUNTS']//a[@href='https://www.phptravels.net/admin/accounts/guest/']");
		
		public CustomerManagement clickCustomers(){
			driver.findElement(this.CUSTOMERS).click();
			return new CustomerManagement(driver);
		}
	}

}


