Feature: Get Users information
	
#	@api	@get
#	Scenario: Getting single user details
#		Given API endpoint as "https://reqres.in/api/users/" and userid "2"
#		When I make get request to endpoint
#		Then response should have username as "Janet"
		
	@api	@get
	Scenario: Getting user on specific page
		Given API endpoint as "https://reqres.in/api/users"
		When I make get request to endpoint with parameter "page"="2"
		Then response code should be 200
		And 3 users data should be returned
		
#	Scenario: test datatables
#		Given dummy given 
 #     	When following data:
  #    		| KMSY | 29.993333 |  -90.258056 |
	#		| KSFO | 37.618889 | -122.375000 |
	#		| KSEA | 47.448889 | -122.309444 |
	#		| KJFK | 40.639722 |  -73.778889 |