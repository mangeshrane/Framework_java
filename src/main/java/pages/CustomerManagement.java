package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerManagement extends NavigationBar{

	private WebDriver driver;

	By addBtn = By.xpath(
			"//div[@id='content']//form[@action='https://www.phptravels.net/admin/accounts/customers/add']/button[@type='submit']");
	By deleteSelectedBtn = By.xpath(
			"//div[@id='content']//form[@action='https://www.phptravels.net/admin/accounts/customers/add']/button[@type='submit']");
	By printBtn = By.xpath(
			"//div[@id='content']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='xcrud']//div[@class='btn-group pull-right']/a[1]");

	By exportToCsvBtn = By.xpath(
			"//div[@id='content']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='xcrud']//div[@class='btn-group pull-right']/a[2]");
	
	public final By successMsg = By.cssSelector(".ui-pnotify-title");
	public final By rowsIdentifier = By.cssSelector("[class^='xcrud-row xcrud-row"); 

	public CustomerManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void add(Map<String, String> customer) {
		driver.findElement(this.addBtn).click();
		new addCustomer(driver, customer);
	}
	
	public class customersTable{
		
		private int rowNo;
		
		public customersTable(int rowNo) {
			this.rowNo = rowNo;
		}
		
		By table = By.cssSelector("table");
		
		public By getCheckbox(){
			return By.cssSelector("[class='xcrud-row xcrud-row-" + rowNo + "'] .iCheck-helper");
		}
		
		public By getFirstName(){
			return By.cssSelector("tbody [class^='xcrud-row xcrud-row']:nth-of-type("+ rowNo +") td:nth-of-type(3)");
		}
		
		public By getLastName(){
			return By.cssSelector("[class='xcrud-row xcrud-row-" + rowNo + "'] td:nth-of-type(4)");
		}
		
		public By getEmail(){
			return By.cssSelector("[class='xcrud-row xcrud-row-" + rowNo + "'] td:nth-of-type(5)");
		}
		
		public By getEditBtn(){
			return By.cssSelector("[class='xcrud-row xcrud-row-" + rowNo + "'] [title='Edit']");
		}
		
		public By getDeleteBtn(){
			return By.cssSelector("[class='xcrud-row xcrud-row-" + 0 + "'] [title='DELETE']");
		}
	}

}

class addCustomer extends NavigationBar {

	WebDriver driver;

	public addCustomer(WebDriver driver, Map<String, String> customer) {
		super(driver);
		this.driver = driver;
		driver.findElement(this.firstName).clear();
		driver.findElement(firstName).sendKeys(customer.get("firstName"));
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(customer.get("lastName"));
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(customer.get("email"));
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(customer.get("password"));
		driver.findElement(mobileNumber).clear();
		driver.findElement(mobileNumber).sendKeys(customer.get("mobileNumber"));
		driver.findElement(country).click();
		// driver.findElement(By.xpath("//a[@pathname='void(0)']/span[@innertext='Please Select']")).click();
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(address1).sendKeys(customer.get("address1"));
		driver.findElement(address2).sendKeys(customer.get("address2"));
		if (customer.get("status").equals("1")) {
			driver.findElement(status).click();
		} else {
			driver.findElement(status).clear();
		}
		driver.findElement(submitBtn).click();
	}

	By firstName = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//input[@name='fname']");
	By lastName = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//input[@name='lname']");
	By email = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//input[@name='email']");
	By password = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//input[@name='password']");
	By mobileNumber = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//input[@name='mobile']");
	By country = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='panel-body']/div[6]/div/div/a[@href='javascript:void(0)']/span[@class='select2-chosen']");
	By address1 = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//input[@name='address1']");
	By address2 = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//input[@name='address2']");
	By status = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='panel-body']//select[@name='status']");
	By emailNewsletterSubscribe = By.xpath(
			"//div[@id='content']/form[@action='']/div[@class='panel panel-default']/div[@class='panel-body']//div[@class='col-md-12']/div[@class='row']/label/div/ins[@class='iCheck-helper']");
	By submitBtn = By.xpath("//div[@id='content']/form[@action='']//button[@class='btn btn-primary']");

}