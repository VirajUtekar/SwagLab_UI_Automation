package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageObject {

	public WebDriver driver;
	
	
	public By itemListTitle = By.cssSelector("div#inventory_container > div:nth-Child(1) > div > div > div > div:nth-Child(2) > div  > a > div");
	public By itemSelectDropDown = By.cssSelector("div#header_container > div:nth-Child(2) > div:nth-Child(3) > span > select");
	public By itemSelectOptionsList = By.cssSelector("div#header_container > div:nth-Child(2) > div:nth-Child(3) > span > select > option");
	public By itemPriceList = By.cssSelector("div#inventory_container > div:nth-Child(1) > div > div > div  :nth-Child(2) > div:nth-Child(2) > div");
	
	public DashboardPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public List<WebElement> getItemListTitle(){
		return driver.findElements(itemListTitle);
	}
	
	public WebElement getItemsDropDown() {
		return driver.findElement(itemSelectDropDown);
	}
	
	public List<WebElement> getItemsDropDownOptions(){
		return driver.findElements(itemSelectOptionsList);
	}
	
	public List<WebElement> getItemPriceList(){
		return driver.findElements(itemPriceList);
	}
}
