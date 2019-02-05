Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"
    
   
  Scenario Outline: Today is or is not Friday 
    Given today is <day>                      
    When I ask whether it's Friday yet        
    Then I should be told <answer>  
    
    Examples:
    	|	day		|	answer		|
    	|	"Friday"|	"TGIF"		|
    	|	"Sunday"|	"Nope"		|
    	|	"Any"	|	"No"		|
    
   Scenario: Using data tables in scenarios
   	Given the following user details:
   		|	FirstName	|
   		|	LastName	|
   		|	age			|
   		|	City		|
   	When I check for details size
   	Then I should get size as 4
 