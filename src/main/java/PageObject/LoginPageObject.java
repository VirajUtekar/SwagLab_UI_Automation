package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	public WebDriver driver;
	
	private By usernameField = By.cssSelector("div#root > div > div > div > div > div > form > div > input#user-name");
	
	private By passwordField = By.cssSelector("div#root > div > div > div > div > div > form > div > input#password");
	
	private By loginSubmit = By.cssSelector("div#root > div > div > div > div > div > form > input#login-button");
	
	private By alert = By.cssSelector("div#root > div > div > div > div > div > form > div.error > h3");
	
	
	public LoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getUserNameField() {
		return driver.findElement(usernameField);
	}
	
	public WebElement getPasswordField() {
		return driver.findElement(passwordField);
	}
	
	public WebElement getLoginSubmit() {
		return driver.findElement(loginSubmit);
	}
	
	public WebElement getAlert() {
		return driver.findElement(alert);
	}
}
