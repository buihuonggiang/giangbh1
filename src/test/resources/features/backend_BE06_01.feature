@US-BE06_01
Feature: As a Tool manager, I want ability to send created Newsletter, so that I can deliver this Newsletter to subscribed with corresponding group

  Background: User is Logged In admin
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in

  @tag1
  Scenario: The Send now will deliver the Newsletter to corresponding subscribed immediately 
    Given I staying create News Page
    When I provied valid Group and valid subject and valid body and valid name
    And I do next
    And I do Send Now
    Then I should see "The News has been sent successfully."

  @tag2
  Scenario: The save to send later require the date end time which Newsletter will be delivered to subscribers
      Given I staying create News Page
    When I provied valid Group and valid subject and valid body and valid name
    And I do next
    And I provied date and provied time and I do Save to send later
    Then I should see "The News has been sent successfully."