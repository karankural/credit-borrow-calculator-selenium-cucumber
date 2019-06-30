package managers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Helper {

	WebDriver driver;
	static JavascriptExecutor js;
	String JsonPath = "src/test/java/testDataResource/Data.json";
	
	public Helper(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
	}
	
	public static void scrollPage(int pixels) {
		js.executeScript("window.scrollBy(0,"+pixels+")");
	}
}
