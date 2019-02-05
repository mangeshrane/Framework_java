Feature: Google search 
  
  Background:
   	Given the user is on search Page
  
  @web  @google
  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"
    
  @web  @google
  Scenario Outline: Finding some cheese
    Given I am on the Google search page
    When I search for <term>
    Then the page title should start with <term>
    
   Examples:
    	|	 term		|
    	|	"test"		|
    	|	"cheese"	|
    	|	"selenium"	|