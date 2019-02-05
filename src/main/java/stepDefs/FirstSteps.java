package stepDefs;

import static org.testng.Assert.assertEquals;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstSteps {
	public String day = "";
	public String answer = "";
	List<String> list = null;
	int listSize = 0;
	
	
	
	@Given("^today is Sunday$")
	public void today_is_Sunday() throws Throwable {
		day = "Sunday";
	}
	
	@Given("^today is \"([^\"]*)\"$")
	public void today_is(String arg1) throws Throwable {
	    day = arg1;
	}

	@When("^I ask whether it's Friday yet$")
	public void i_ask_whether_it_s_Friday_yet() throws Throwable {
		answer = "Nope";
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String arg1) throws Throwable {
		assertEquals(answer, arg1);
	}
	
	
	@Given("^the following user details:$")
	public void the_following_user_details(List<String> data) throws Throwable {
			list = data;
	}

	@When("^I check for details size$")
	public void i_check_for_details_size() throws Throwable {
	   listSize = list.size();
	}

	@Then("^I should get size as (\\d+)$")
	public void i_should_get_size_as(int arg1) throws Throwable {
		assertEquals(arg1, listSize);
	}
}
