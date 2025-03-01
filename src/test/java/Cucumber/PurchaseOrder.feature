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
Feature: Purchase order from ecommerce website.
  I want to use this template for my feature file

  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes

	Background:
	Given I landed on Ecommerce Page
	
  @Regression
  Scenario Outline: Positive test of submitting the order
    Given I login with my credentials <username> and <password>
    When I add the product <product>
    And Checkout <product> and submit the order.
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage.

    Examples: 
      | username  										| password  | product  		    |
      | automationtesting11@gmail.com | Testing@1 | ADIDAS ORIGINAL |
     
