package stepDefs;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;

public class DataTables {
	
	@Given("^data as following$")
	public void data_as_following(Map<String, String> map) throws Throwable {
	    System.out.println(map.toString());
	}
	
	@Given("^following data$")
	public void following_data(List<Map<String, String>> list) throws Throwable {
	    System.out.println(list.toString());
	}
	
	@Given("^following data as list$")
	public void following_data1(List<List<String>> list) throws Throwable {
	    System.out.println(list.toString());
	}
	
	@Given("^following data as a map$")
	public void following_data_as_a_map(Map<String, List<String>> data) throws Throwable {
	    System.out.println(data.toString());
	}
	
	@Given("^following raw data$")
	public void following_raw_data(Map<String, Map<String, String>> data) throws Throwable {
		for (String key: data.keySet()){
			Map<String , String> tmp = data.get(key);
			System.out.print(key);
			for (String k1: tmp.keySet()){
				System.out.println(" -> " + k1 + ": " + tmp.get(k1));
			}
		}
	    System.out.println(data.toString());
	}
}
