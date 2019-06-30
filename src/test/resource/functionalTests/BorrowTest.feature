
Feature: Borrowing calculator.
Description : The purpose of this feature is to the test the functionality of the borrowing calcualator to make sure the 
the calculator is working as intended or not.
  

  Scenario: Check my borrowing limit as per my earnings and expenses.
    Given user is on calculator tool page
    When user enters the applicator type as "Single"
    And choose "0" number of dependents
    And buying a property as "Home to live in"
    And with income of "$80000" 
    And other income of "$10000"
    And living expense of "$500"
    And paying the "0" home loan 
    And other loan repayment of "$100"
    And other commitments as "0"
    And with total credit card limit of "$10000"
    And user click on borrow button
    Then user see borrowing limit of "$467,000"
    When user click on startover
    Then user sees all values reset to 0
    
    
 Scenario: Check my borrowing limit as per my earning and living expense of $1
  	Given user is on calculator tool page
    When living expense of "$1" 
    And user click on borrow button
    Then user should see a message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641."
    
