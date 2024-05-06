@login @all
Feature: Login Functionality

Background:
    Given User launch chrome browser
    When User opens URL "https://www.amazon.in/"
	
@valid_credentials
	Scenario Outline:  Login using valid credentials
		And Click signin Link
		And User enters Email as "<Email>"
		And Click continue
		And Enter Password as "<Password>"
		Then Page Title should be "Amazon Sign In" 
		And close browser 
		Examples:
		|Email|Password|
		|example@gmail.com|12345678|
		|example1@gmail.com|1234|
		@invalid_credentials
	Scenario: Login using invalid credentials
    And Click signin Link
    And User enters Email as "example@gmail.com"
    And Click continue
    And Enter Password as "12345"
    And Click SignIn
    Then User should see an error message "There was a problem"
    And close browser