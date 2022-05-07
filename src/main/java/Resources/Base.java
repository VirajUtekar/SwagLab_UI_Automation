package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		String file = System.getProperty("user.dir")+"/src/main/java/Resources/data.properties";
		
		FileInputStream fis = new FileInputStream(file);
		
		prop = new Properties();
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			String ch = System.getProperty("user.dir")+"/driver/chromedriver";
			System.setProperty("webdriver.chrome.driver", ch);
			driver = new ChromeDriver();
			if(browserName.equals("chrome-headless")) {
			   ChromeOptions co = new ChromeOptions();
			   co.addArguments("headless");
			   driver = new ChromeDriver(co);
			}
		}
		else
		{
			System.out.println("no driver found");
		}
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
}
