Credit Borrow Calculator
=================

Borrow Calculator : This is a calculator which helps us to see the amount I can borrow as per my 
income and expenses.

We have created a BDD framework to write the Automation script for this Borrow calculator.
It enables you to write and execute automated acceptance tests.


Download a Framework
--------------
* Maven - https://github.com/selenium-cucumber/credit-borrow-calculator-selenium-cucumber

Pre-requisite 
--------------
* IDE (Eclipse preferred)
* mvn CLI.
* Git

Framework Architecture
--------------
	Project-Name
		|
		|_src/main/java
		|	|_dataProviders
		|	|	|_ConfigFileReader.java
		|	|	|...
		|	|_managers
		|	|	|_Assertions.java
		|	|	|_DriverUtils.java
		|	|	|_Helper.java
		|	|	|...
		|	|_pageObjects
		|		|_CalculatorPage.java
		|	|_waits
		|		|_SmartWait.java
		|		|...
		|_src/test/java
		|	|_runners
		|	|	|_Hooks.java
		|	|	|_TestRunner.java
		|	|_userStepDefinition
		|	|	|_StepDefinitions.java
		|	|	|...
		|_src/test/resources
		|	|_functionslTests
		|	|	|_BorrowTest.feature


Predefined steps
-----------------

USING IDE:
 	ECLIPSE:-
* `Clone the project.`
* `Go the Eclipse IDE.`
* `Click on file in toolbar.`
* `click on Import option.`
* `Import as Existing Maven Project.`
* `click on Next.` 
* `Click on Finish.`

USING CLI:
* `Clone the project.`
* `Go inside the project directory.`
* `Run Mvn clean install`
 

Running test
--------------

Go to your project directory from terminal and hit following commands
* `mvn test `


Reporting
--------------
* `Go to your project directory from terminal.`
* `Go inside the target folder and then cucumber-reports`
* `open Index.HTML`



