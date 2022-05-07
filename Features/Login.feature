#Author: your.email@your.domain.com

@tag
Feature: Sauce Labs test case validations
   sauce labs is an ecommerce platform, validations of test cases helps to assure the quality of web application
   
 
 Scenario: verify when user tries to login with only password, should prompt to enter username
 Given navigate to site url
 And enter "test2" into password field
 Then click on login submit
 Then should prompt "Epic sadface: Username is required" as alert  


 Scenario: verify when user tries to login with only username, should prompt to enter password
 Given navigate to site url
 And enter "test2" into email field
 Then click on login submit
 Then should prompt "Epic sadface: Password is required" as alert

     
   Scenario: verify when user tries to login with empty credentials should ask for username 
   Given navigate to site url
   When click on login submit
   Then should prompt "Epic sadface: Username is required" as alert
  
  Scenario: verify when user tries to login with invalid credentials should prompt as invalid credentials
    Given navigate to site url
    And enter "test" into email field and "test" into password field
    When click on login submit
    Then should prompt "Epic sadface: Username and password do not match any user in this service" as alert

 
 Scenario: verify when user tries to login with valid credentials, should redirect to user dashboard
   Given navigate to site url
   And enter "standard_user" into email field and "secret_sauce" into password field
   When click on login submit
   Then user should redirect to dashboard page
   
 