@US-BE05
Feature: As a tool manager, I want ability to create News, so that I can deliver it to our customer who subscripted from Front-end module

	Background: User is Logged In admin
	Given I navigate to the login page
	When I submit username and password
	Then I should be logged in
	
  @tag1
  Scenario: Group Name Subject and Body are mandatory information
    Given I staying create News Page
    When I do next
    Then I should see messenger "This is required field" under field Name
    And I should see messenger "This is required field" under field Subject 
    And I should see messenger "This is required field" under field Body  

  @tag2
  Scenario: The default for group
    Given I staying create News Page
    Then I should see The default group is "Select group..."  
   
  @tag3
  Scenario: Check validate for maxlenth Name
   Given I staying create News Page
    When I provied valid Group and valid subject and valid body and invalid name
    And I do next
    Then I should see messenger "This not exceeds 100 characters " field Name

