Feature: User creation

	
	Scenario: Creating new user 
		Given "https://reqres.in/api/users" endpoint
		When I post following data to given url
		Then response code should be 201
		And user should get name as "morpheus" in response
		

	 