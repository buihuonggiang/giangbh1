@UCFE01
Feature: As an end user I want the ability to provide my information, so that I may receive the newsletters from provider

#Kiểm tra giá trị default
  
  @tag1
  Scenario Outline: Show default value on form provide information
    Given I staying on the home page
    When I provide valid email and I do regist
    Then I should see Fullname null value on form provide information
    And I should see Gender Unknown value on form provide information
    And I should see Newtype all value on form provide information
    
   Examples: 
     |email|
      |huonggiangdstin4@gmail.com|

#Kiểm tra trường bắt buộc nhập và hiển thị lỗi thông báo tương ứng
	@tag2
	 Scenario: Show default value on form provide information
    Given I staying on the home page
    When I provide valid email and I do regist
    And I provide Fullname null
    And I do accept
    Then I should see messenger error "This is required field" under field fullname
    
#Kiểm tra đăng ký thành công hiển thị thông báo và gửi email xác nhận
	@tag3
	 Scenario: Show default value on form provide information
    Given I staying on the home page
    When I provide valid email and I do regist
    And I provide valid Fullname and valid Gender and valid Newtype
    And I do accept
    And I do agree and wait new mail Confirm registration in Inbox mail 
    And I open Activation Link in inbox mail
    Then I should see message "Đăng ký đã được kích hoạt thành công"
    
    