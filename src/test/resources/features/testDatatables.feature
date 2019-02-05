Feature: Datatables
	
	Scenario: getting data as map
		Given data as following 
			| FirstName	| 	LastName	|
			| userName	|	userLast	|
			| test		|   test		|
	
	Scenario: getting data as list of maps
		Given following data
			| firstName   | lastName | birthDate  |
			| Annie M. G. | Schmidt  | 1911-03-20 |
			| Roald       | Dahl     | 1916-09-13 |
			| Astrid      | Lindgren | 1907-11-14 |	
	
	Scenario: getting data as list of list
		Given following data list
			| firstName   | lastName | birthDate  |
			| Annie M. G. | Schmidt  | 1911-03-20 |
			| Roald       | Dahl     | 1916-09-13 |
			| Astrid      | Lindgren | 1907-11-14 |	
	
	Scenario: getting data as map
		Given following data as a map
			| KMSY | 29.993333 |  -90.258056 |
			| KSFO | 37.618889 | -122.375000 |
			| KSEA | 47.448889 | -122.309444 |
			| KJFK | 40.639722 |  -73.778889 |
			
	Scenario: getting map of map
		Given following raw data
			|      |       lat |         lon |
			| KMSY | 29.993333 |  -90.258056 |
			| KSFO | 37.618889 | -122.375000 |
			| KSEA | 47.448889 | -122.309444 |
			| KJFK | 40.639722 |  -73.778889 |
	
	Scenario: getting data as object
		Given following data test
			| KMSY | 29.993333 | -90.258056  |
			| KSFO | 37.618889 | -122.375    |
			| KSEA | 47.448889 | -122.309444 |
			| KJFK | 40.639722 | -73.778889  |
	