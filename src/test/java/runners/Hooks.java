package runners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataProviders.ConfigFileReader;
import managers.DriverUtils;

public class Hooks {
	
	static WebDriver driver;
	ConfigFileReader reader;
	DriverUtils utils;
	
	@Before
	public void BeforeSteps() {
		 reader = new ConfigFileReader();
		 utils = new DriverUtils();
		 driver = utils.getDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(reader.getURL());		
	}

	@After
	public void AfterSteps() {
		driver.close(); 
	}
	
	public static WebDriver driver() {
		return driver;
	}	
}
