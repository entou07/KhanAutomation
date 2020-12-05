@smokeTest
Feature: Validate login function and verify the total price with shipping in MY Store 

Scenario: User able to validate login function and varify pricing in MY Store 
	Given user go to automation practice home page 
	Then user verify the page title as "My Store" 
	And user click the sign in button on the right 
	And user enter valid username and password
	And user click the sing in button 
	And user click on the upper left corner Dresses link and display should show 5 dresses 
	And user Print all the dress prices in descending order on the console 
	And user select the second dress on that current list and remember the price (the list may change so it is dynamic) 
	Then user click on the next page Proceed to checkout 
    When user On the next page verify there is a Total price with shipping 
	Then user click on the sing out button from Mystore and close the window