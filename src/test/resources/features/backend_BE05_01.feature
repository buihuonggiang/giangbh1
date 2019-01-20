@US-BE05_01
Feature: As a tool manager, I want ability add attachment file to News item, so that I can delivery it along with News

  Background: User is Logged In admin
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in

  @tag1
  Scenario: The file can be uploaded is document file such as pdf, doc*, xls* and has max length is 2MB
    Given I staying create News Page
    When I do Add file
    And I select file .xls invalid
    Then I should see file not attach on list file

  @tag2
  Scenario: The list of files is displayed with corresponding file icon
    Given I staying create News Page
    When I do Add file
    And I select file .xls valid
    Then I should see file name and display icon delete

  @tag3
  Scenario: The uploaded file can removable after confirmed
    Given I staying create News Page
    When I do Add file
    And I select file .xls valid
    And I confirm delete file
    Then I should not see file name on list file
   
  @tag4
  Scenario: The uploaded file can removable after confirmed
    Given I staying create News Page
    When I do Add file
    And I select file .xls valid
    And I confirm delete file
    Then I should not see file name on list file
    
