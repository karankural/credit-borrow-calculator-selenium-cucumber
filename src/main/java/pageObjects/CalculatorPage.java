package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import dataProviders.ConfigFileReader;
import managers.Assertions;
import managers.Helper;
import waits.SmartWait;

public class CalculatorPage {
	
	WebDriver driver;
	
	By numberOfDependent = By.cssSelector(".borrow__question__answer.borrow__question__answer--select>select");
	By incomeField = By.xpath("//div[label[@id='q2q1']]//input");
	By otherIncomeField = By.xpath("//div[label[@id='q2q2']]//input");
	By livingExpenseField = By.xpath("//div[label[@id='q3q1']]//input");
	By currentHomeLoanField = By.xpath("//div[label[@id='q3q2']]//input");
	By otherLoanPaymentField = By.xpath("//div[label[@id='q3q3']]//input");
	By otherCommitmentField = By.xpath("//div[label[@id='q3q4']]//input");
	By totalCreditCardLimitField = By.xpath("//div[label[@id='q3q5']]//input");
	By checkBorrowLimitField = By.cssSelector(".btn.btn--action.btn--borrow__calculate");
	By borrowedAmountEffect = By.xpath("//span[@aria-live='assertive']");
	By retrievedBorrowAmountField = By.cssSelector(".borrow__result__text>span");
	By startOverButton = By.cssSelector(".borrow__result>.box--right>button.start-over");
	By displayMessageField = By.cssSelector(".box--left.text--center>span");
	By yourExpenceHeading = By.xpath("//h3[contains(text(),'Your expenses')]");
	
	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectApplicationType(String type) {
		String applicationType = ConfigFileReader.jsonkeyRead(type);
		System.out.println(applicationType);
		driver.findElement(By.xpath("//label[contains(text(),'"+applicationType+"')]")).click();
	}

	public void selectDependents(String number) {
		WebElement element = driver.findElement(numberOfDependent);
		String dependentNumber = ConfigFileReader.jsonkeyRead(number);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(dependentNumber);
	}
	
	public void propertyType(String propertyType) {
		String propertyToBuy = ConfigFileReader.jsonkeyRead(propertyType);
		driver.findElement(By.xpath("//label[contains(text(),'"+propertyToBuy+"')]")).click();
	}
	
	public void income(String incomeAmount) {
		String income = ConfigFileReader.jsonkeyRead(incomeAmount);
		driver.findElement(incomeField).sendKeys(income);
	}
	
	public void otherIncome(String incomeAmount) {
		String income = ConfigFileReader.jsonkeyRead(incomeAmount);
		driver.findElement(otherIncomeField).sendKeys(income);
		
	}
	
	public void livingExpense(String expenseAmount) throws InterruptedException {
		String expense = ConfigFileReader.jsonkeyRead(expenseAmount);
		WebElement element = driver.findElement(livingExpenseField);
		element.sendKeys(expense);
	}
	
	public void payingHomeLoan(String loanAmount) {
		String loan = ConfigFileReader.jsonkeyRead(loanAmount);
		driver.findElement(currentHomeLoanField).sendKeys(loan);
	}
	
	public void payingOtherLoanAmount(String otherLoanAmount) {
		String otherLoan = ConfigFileReader.jsonkeyRead(otherLoanAmount);
		driver.findElement(otherLoanPaymentField).sendKeys(otherLoan);
	}
	
	public void OtherCommitments(String otherCommitmentAmount) {
		String commitmentAmount = ConfigFileReader.jsonkeyRead(otherCommitmentAmount);
		driver.findElement(otherCommitmentField).sendKeys(commitmentAmount);
	}
	
	public void creditCardPayment(String creditAmount) {
		String credit = ConfigFileReader.jsonkeyRead(creditAmount);
		driver.findElement(totalCreditCardLimitField).sendKeys(credit);
	}
	
	public void clickOnBorrowButton() {
		Helper.scrollPage(200);
		driver.findElement(checkBorrowLimitField).click();
	}
	
	public void borrowingLimit(String expense) throws InterruptedException {
		SmartWait.untilJqueryIsDone(driver);
		SmartWait.waitForElement(driver, driver.findElement(borrowedAmountEffect));
		String resultedBorrowAmount = driver.findElement(retrievedBorrowAmountField).getText();
		Assertions.assertEquals(expense, resultedBorrowAmount);
	}
	
	public void startOver() throws InterruptedException {
		driver.findElement(startOverButton).click();
		Thread.sleep(500);
		SmartWait.untilPageLoadComplete(driver);
		SmartWait.waitForElement(driver, driver.findElement(yourExpenceHeading));
	}
	
	public void messageDisplayed(String message) {
		SmartWait.waitForElement(driver, driver.findElement(borrowedAmountEffect));
		String messageRetrieved = driver.findElement(displayMessageField).getText();
		Assertions.assertEquals(messageRetrieved, message);	
	}
	
	public void resetValueCheck() {
		Assertions.assertEquals(driver.findElement(incomeField).getAttribute("value"), "0");
		Assertions.assertEquals(driver.findElement(otherIncomeField).getAttribute("value"), "0");
		Assertions.assertEquals(driver.findElement(livingExpenseField).getAttribute("value"), "0");
		Assertions.assertEquals(driver.findElement(currentHomeLoanField).getAttribute("value"), "0");
		Assertions.assertEquals(driver.findElement(otherLoanPaymentField).getAttribute("value"), "0");
		Assertions.assertEquals(driver.findElement(otherCommitmentField).getAttribute("value"), "0");
		Assertions.assertEquals(driver.findElement(totalCreditCardLimitField).getAttribute("value"), "0");
	}
}
