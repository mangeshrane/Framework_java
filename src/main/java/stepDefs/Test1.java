package stepDefs;

import org.testng.annotations.Test;

import dataProvider.TestDataProvider;
import dataProvider.DataFilter;

public class Test1 {

	/*public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("firstName", "MANGESH");
		map.put("lastName", "Rane");
		map.put("Job", "QA");
		map.put("extra", "Sel");

		System.out.println(map);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(Visibility.ANY));
		emp pojo = mapper.convertValue(map, est.class);
		System.out.println(pojo);
		
		 1 2 3
		 * 4 5 6
		 * 7 8 9
		 	
	}*/
		
	@DataFilter(fileName="testData/data.xlsx", filter="Add Customer", header = false)
	@Test(dataProviderClass=TestDataProvider.class, dataProvider="excelLoader")
	public void test(String... k){
		System.out.println(k);
		for ( String o: k){
			System.out.println(o);
		}
	}
	
	
}

/*class emp {

	protected String firstName;
	protected String lastName;
	protected String Job;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}
	
	public String toString(){
		return firstName + " " + lastName + " " + Job;
	}

}*/


/*class est extends emp{
	
	private String extra;

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	public String toString(){
		return firstName + " " + lastName + " " + Job + " extra " + extra;
	}
	*/
	
	
