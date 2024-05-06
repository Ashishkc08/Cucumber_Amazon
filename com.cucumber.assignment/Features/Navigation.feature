@navigation @all
Feature: Navigation Functionality

Background:
    Given User launch chrome browser
    When User opens URL "https://www.amazon.in/"
@search
	Scenario Outline:  Search using item name
		And User enters item name as "<Item>"
		And Click search
		Then Page Title should be "<Title>" 
		And close browser 
		
		Examples:
		|Item|Title|
		|iphone 15|Amazon.in : iphone 15|
		|Kindle|Amazon.in : Kindle|
		@best_seller
	Scenario Outline:  Best Seller Navigation
		And User clicks all link
		And Best Seller
		Then Page Title should be "<Title>"
		And User clicks category as "<Category>"
		Then Expected title should be "<ExpectedTitle>"
		And close browser
		Examples:
		|Title|Category|ExpectedTitle|
		|Amazon.in Bestsellers: The most popular items on Amazon|Sports, Fitness & Outdoors|Amazon.in Bestsellers: The most popular items in Sports, Fitness & Outdoors|
		|Amazon.in Bestsellers: The most popular items on Amazon|Gift Cards|Amazon.in Bestsellers: The most popular items in Gift Cards|
		
		@add_to_cart
		Scenario Outline:  Add to Cart and Remove from Cart
		    Given User launch chrome browser
    		When User opens URL "https://www.amazon.in/"
    		And User enters item name as "<Item>"
    		And Click search
    		Then Page Title should be "<Title>"
    		And User clicks on the first search result
    		And User adds the item to the cart
    		And User views the cart
    		Then User removes the item from the cart
    		And close browser 

    	Examples:
    	| Item      | Title                        |
    	| iphone 15 | Amazon.in : iphone 15        |
