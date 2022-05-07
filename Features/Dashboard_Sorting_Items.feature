@tag
Feature: Sauce Labs test case validations
   sauce labs is an ecommerce platform, validations of test cases helps to assure the quality of web application


Scenario: verify items in dashboard are sorted from A - Z  
    Given navigate to site url
    And enter "standard_user" into email field and "secret_sauce" into password field
    When click on login submit
    Then validate the items are in "Name (A to Z)" sorted order


Scenario: verify items in dashboard, are sorted from "Price (low to high)"
    Given navigate to site url
    And enter "standard_user" into email field and "secret_sauce" into password field
    When click on login submit   
    Then validate the items are sorted from "Price (low to high)"
    