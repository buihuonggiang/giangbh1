@US-BE06_02
Feature: As a tool manager, I want ability to manage the subscriber information, so that I can modify, remove or add new subscriber

  Background: User is Logged In admin
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in

  @tag1
  Scenario: List of Subscriber is displayed with alphabet order 
    Given I staying Sign news Page
    When I get list Subscriber registered
    Then I should see Subscriber displayed with alphabet order
