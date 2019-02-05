@web
Feature: Customer Management 

	Background:
   		Given admin is logged in.
   		And user is on customer management page
	
	Scenario: Adding customers from customer management 
		When user clicks on add button 
		And user enters data for "Add Customer" module from excel sheet
		Then user should able to see entry on portal
		
#	Scenario: Deleting selected user from user management page
#		When user selects users 
#		And clicks on delete selected button
#		Then selected user records should be deleted