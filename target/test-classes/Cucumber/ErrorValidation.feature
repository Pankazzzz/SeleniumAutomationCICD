#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag

Feature: Error Validation

  @ErrorValidtion
  Scenario Outline: Login Error Validation
    Given I landed on Ecommerce Page
    When I login with my credentials <username> and <password>
    Then "Incorrect email or password." message is displayed.

    Examples: 
      | username  										| password  | product  		  	|
      | automationteing11@gmail.com   | Testing@1 | ADIDAS ORIGINAL |
