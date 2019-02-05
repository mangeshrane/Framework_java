package stepDefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import config.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.DataHelper;
import pages.CustomerManagement;
import pages.DashBoard;
import pages.DashBoard.Accounts;
import pages.LoginPage;
import utils.DriverProvider;

public class AddCustomerSteps{

	private WebDriver driver;
	private LoginPage loginPage;
	private DashBoard dashBoard;
	private Accounts accounts;
	private List<Map<String, String>> map;
	int initial;
	int result;

	@Given("^admin is logged in\\.$")
	public void admin_is_logged_in() throws Throwable {
		driver = new DriverProvider().getDriver();
		loginPage = new LoginPage(driver);
		dashBoard = loginPage.login(Config.get("application.username"), Config.get("application.password"));
		assertTrue(driver
				.findElement(dashBoard.checkpoint)
				.isDisplayed());
	}

	@And("^user is on customer management page$")
	public void user_is_on_customer_management_page() throws Throwable {
		accounts = dashBoard.clickAccounts(driver);
	}

	@When("^user clicks on add button$")
	public void user_clicks_on_add_button() throws Throwable {
		// Handled in next step
	}
	
	@When("^user enters data for \"([^\"]*)\" module from excel sheet$")
	public void user_enters_data_for_module_from_excel_sheet(String arg1) throws Throwable {
		map = new DataHelper("testData/data.xlsx").setSheet(0).getDataWithHeader("Add Customer");
		CustomerManagement customers = accounts.clickCustomers();
		initial = driver.findElements(customers.rowsIdentifier).size();
		for (Map<String, String> m : map) {
			customers.add(m);
			driver.findElement(customers.successMsg).isDisplayed();
		}
		result = driver.findElements(customers.rowsIdentifier).size();
	}

	@Then("^user should able to see entry on portal$")
	public void user_should_able_to_see_entry_on_portal() throws Throwable {
		assertEquals(initial + map.size(), result);
		driver.quit();
	}
	
	@When("^user selects users$")
	public void user_selects_users() throws Throwable {
		
	}

	@When("^clicks on delete selected button$")
	public void clicks_on_delete_selected_button() throws Throwable {
	}

	@Then("^selected user records should be deleted$")
	public void selected_user_records_should_be_deleted() throws Throwable {
	}
}
