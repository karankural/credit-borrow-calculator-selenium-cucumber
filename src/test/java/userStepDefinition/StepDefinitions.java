package userStepDefinition;


import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.Helper;
import pageObjects.CalculatorPage;
import runners.Hooks;
import waits.SmartWait;

public class StepDefinitions{
	
	
	WebDriver driver;
	CalculatorPage calculatorPage;
	SmartWait wait;
	Helper helper;
	
	 @Given("^user is on calculator tool page$")
	 public void user_is_on_Calculator_Tool(){
		 driver = Hooks.driver();
		 calculatorPage = new CalculatorPage(driver);
		 SmartWait.untilPageLoadComplete(driver);
		 helper = new Helper(driver);
		 
	 }
	 
	 @When("user enters the applicator type as \"(.*)\"")
	 public void user_enters_applicator_type(String type) throws InterruptedException {
		calculatorPage.selectApplicationType(type);
	 }
	 
	 @And("choose \"(.*)\" number of dependents")
	 public void choose_number_dependents(String number) throws InterruptedException {
		calculatorPage.selectDependents(number);
		Helper.scrollPage(200);	
	 }
	 
	 @And("buying a property as \"(.*)\"")
	 public void buying_proerty(String propertyType) {
		 calculatorPage.propertyType(propertyType);
	 }
	 
	 @And("with income of \"(.*)\"")
	 public void income(String incomeAmount) {
		 calculatorPage.income(incomeAmount);
	 }
	 
	 @And("other income of \"(.*)\"")
	 public void other_income(String incomeAmount) {
		 calculatorPage.otherIncome(incomeAmount);
	 }
	 
	 @And("living expense of \"(.*)\"")
	 public void living_expense(String expenseAmount) throws InterruptedException {
		 calculatorPage.livingExpense(expenseAmount);
	 }
	 
	 @And("paying the \"(.*)\" home loan")
	 public void paying_home_loan(String loanAmount) {
		 calculatorPage.payingHomeLoan(loanAmount);
	 }
	 
	 @And("other loan repayment of \"(.*)\"")
	 public void other_loan_payment(String otherLoanAmount) throws InterruptedException {
		 calculatorPage.payingOtherLoanAmount(otherLoanAmount);
		 Helper.scrollPage(500);
		 
	 }
	 
	 @And("other commitments as \"(.*)\"")
	 public void other_commitments(String otherCommitmentAmount) {
		 calculatorPage.OtherCommitments(otherCommitmentAmount);
	 }
	 
	 @And("with total credit card limit of \"(.*)\"")
	 public void credit_card_limit(String creditAmount) {
		 calculatorPage.creditCardPayment(creditAmount);
	 }
	 
	 @And("^user click on borrow button$")
	 public void user_click_on_borrow_button() {
		 calculatorPage.clickOnBorrowButton();
	 }
	 
	 @Then("user see borrowing limit of \"(.*)\"")
	 public void borrowing_limit(String borrowAmount) throws InterruptedException {
		 calculatorPage.borrowingLimit(borrowAmount);
	 }
	 
	 @Given("^I am on new page$")
	 public void page() {
		 System.out.println("new page");
	 }
	 
	 @When("^user click on startover$")
	 public void click_start_over() throws InterruptedException {
		 calculatorPage.startOver();
	 }
	 
	 @Then("^user should see a message \"(.*)\"$")
	 public void message_display(String message) {
		 calculatorPage.messageDisplayed(message);
	 }
	 
	 @Then("^user sees all values reset to 0$")
	 public void resetted_value() {
		 calculatorPage.resetValueCheck();
	 }
}

