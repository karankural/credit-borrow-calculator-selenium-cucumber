package dataProviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConfigFileReader {
	
	private Properties property;
	private final String filePath = "config/config.properties";
	private static String jsonPath = "src/test/resource/testDataResource/Data.json";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			property = new Properties();
			try {
				property.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
			 throw new RuntimeException("COnfig file not found " + filePath);
		 } 
	}
	
	public String getBrowser() {
		String browser = property.getProperty("browser");
		if(browser == null || browser.equalsIgnoreCase("chrome")) {
			return browser;
		} else if (browser.equalsIgnoreCase("firefox")) {
			return browser;
		} else if (browser.equalsIgnoreCase("safari")) {
			return browser;
		}
		else throw new RuntimeException("Browser is not mentioned in config"); 		
	}
	
	public String getURL() {
		String url = property.getProperty("url");
		if(url!=null) {
			return url;
		}
		else throw new RuntimeException("url is not mentioned in config"); 		
	}
	
	public static String jsonkeyRead(String key) {
		String keyValue = null;
		InputStream input;
		try {
			JSONParser parser = new JSONParser();
			input = new FileInputStream(jsonPath);
			Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
			Object obj = parser.parse(reader); 
			JSONObject jo = (JSONObject) obj;
			keyValue = (String) jo.get(key);
		}catch(Exception e) {
			e.getMessage();
		}
		
		return keyValue;
	}
	
}
