package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {
	WebDriver driver;
	ConfigFileReader reader;
	String browser;
	
	public DriverUtils() {
		reader = new ConfigFileReader();
		browser = reader.getBrowser();
	}
	
	public WebDriver getDriver() {
		switch (browser) {     
        case "chrome" : 
        	WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
        break;
        case "firefox" : 
        	WebDriverManager.chromedriver().setup();
         	driver = new ChromeDriver();
     	break;
        }
		return driver;
	}
}
