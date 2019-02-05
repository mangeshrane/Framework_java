package stepDefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.User;
import pojo.Users;
import utils.Logging;
import utils.ResourceProvider;

public class APIStepDefs {

	Logger log = Logging.getLogger(getClass());
	private RequestSpecification spec;
	private Response response;
	ObjectMapper mapper = new ObjectMapper();
	User user;
	private Users users;

	@Given("^API endpoint as \"([^\"]*)\" and userid \"([^\"]*)\"$")
	public void api_endpoint_as_and_userid1(String url, String id) throws Throwable {
		spec = given().accept(ContentType.JSON).baseUri(url + id);
	}

	@When("^I make get request to endpoint$")
	public void i_make_get_request_to_endpoint() throws Throwable {
		response = spec.get();
	}

	@Then("^response should have username as \"([^\"]*)\"$")
	public void response_should_have_username_as(String name) throws Throwable {
		response.then().body("data.first_name", equalTo(name));
	}

	@Given("^API endpoint as \"([^\"]*)\"$")
	public void api_endpoint_as(String url) throws Throwable {
		spec = given().accept(ContentType.JSON).baseUri(url);
	}

	@When("^I make get request to endpoint with parameter \"([^\"]*)\"=\"([^\"]*)\"$")
	public void i_make_get_request_to_endpoint_with_parameter(String key, String value) throws Throwable {
		spec.queryParam(key, value);
		response = spec.get();
		ObjectMapper mapper = new ObjectMapper();
		users = mapper.readValue(response.getBody().asString(), Users.class);
		log.info(users.toString());
	}

	@Then("^response code should be (\\d+)$")
	public void response_code_should_be(int code) throws Throwable {
		assertEquals(code, response.statusCode());
	}

	@Then("^(\\d+) users data should be returned$")
	public void users_data_should_be_returned(int count) throws Throwable {
		// response.then().body("data", hasSize(count));
		assertEquals(users.getData().size(), 3);
	}

	@Given("^\"([^\"]*)\" endpoint$")
	public void endpoint(String url) throws Throwable {
		spec = given().baseUri(url).contentType(ContentType.JSON);
	}

	@When("^I post following data to given url$")
	public void i_post_following_data_to_given_url() throws Throwable {
		User value = mapper.readValue(new File(new ResourceProvider().getResource("requests/user.json")) , User.class);
		response = spec.body(value).post();
		response.then().log().body();
		log.info(response.getBody().asString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			user = mapper.readValue(response.getBody().asString(), User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^user should get name as \"([^\"]*)\" in response$")
	public void user_should_get_name_as_in_response(String arg1) throws Throwable {
		assertEquals(user.getName(), arg1);
		log.error(user.toString());
		assertNull(user.getAge());
	}

	@Given("^dummy given$")
	public void dummy_given() throws Throwable {
	}

	@When("^I enter following data:$")
	public void i_enter_following_data(List<Map<String, String>> arg1) throws Throwable {
		log.info(arg1.toString());

		for (Map<String, String> m : arg1) {
			System.out.println(m.get("firstName"));
			System.out.println(m.get("lastName"));
			System.out.println(m.get("email"));
			System.out.println(m.get("password"));
			System.out.println();
		}
	}

	@Given("^following data list$")
	public void following_data_list(List<List<String>> data) throws Throwable {
		log.info(data.toString());
	}

}

