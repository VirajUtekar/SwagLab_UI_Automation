package StepDefinitions;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.DashboardPageObject;
import PageObject.LoginPageObject;
import Resources.Base;
import io.cucumber.java.en.*;

public class StepDefinitions extends Base {

   public LoginPageObject lpo;
   public DashboardPageObject dpo;
   
   public WebDriver driver;
   
	@Given("navigate to site url")
	public void navigate_to_site_url() throws IOException {
	  driver = initializeDriver();	  
	  driver.get(prop.getProperty("url"));
	  driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      
	  lpo = new LoginPageObject(driver);
 
	}
	
	@And("enter {string} into email field")
	public void enter_test2_into_email_field(String username2) {
		lpo.getUserNameField().clear();
		lpo.getUserNameField().sendKeys(username2);
	}
	
	@And("enter {string} into password field")
	public void enter_test2_into_password_field(String password2) {
		lpo.getPasswordField().clear();
		lpo.getPasswordField().sendKeys(password2);
	}
	
	@And("enter {string} into email field and {string} into password field")
	public void enter_test_into_email_field_and_test_into_password_field(String uname, String pass) {

		 
	  lpo.getUserNameField().clear();
	  lpo.getUserNameField().sendKeys(uname);
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 
	  lpo.getPasswordField().clear();
	  lpo.getPasswordField().sendKeys(pass);
	  
	}
	
	
	@When("click on login submit")
	public void click_on_login_submit() {
        
		lpo.getLoginSubmit().click();
	}

	@Then("should prompt {string} as alert")
	public void should_prompt_epic_sadface_username_and_password_do_not_match_any_user_in_this_service_as_alert(String alert) {

		boolean alertIsDisplayed = lpo.getAlert().isDisplayed();
		if(alertIsDisplayed) {
		   Assert.assertEquals(lpo.getAlert().getText().trim(),alert);	
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.quit();
	}	
	
	@Then("user should redirect to dashboard page")
	public void user_should_redirect_to_dashboard_page() {
	   String currentUrl = driver.getCurrentUrl();
	   Assert.assertEquals(currentUrl,"https://www.saucedemo.com/inventory.html");
		driver.quit();
	}

	@Then("validate the items are in {string} sorted order")
	public void validate_the_items_list_are_in_Name_A_to_Z_sorted_order(String item1) {
        dpo = new DashboardPageObject(driver);        

        List<WebElement> itemsTitle = dpo.getItemListTitle();
        
        List<String> values = new ArrayList<String>();
        for(int i=0; i< itemsTitle.size();i++) {
           values.add(itemsTitle.get(i).getText().trim());   
        }	
      
        dpo.getItemsDropDown().click();
     
        List<WebElement> optionsList = dpo.getItemsDropDownOptions();
        for(int i=0; i<optionsList.size();i++) {
             if(optionsList.get(i).getText().contains(item1)) {
            	 int rowIndex = optionsList.size() - 3;
            	 driver.findElement(By.cssSelector("div#header_container > div:nth-Child(2) > div:nth-Child(3) > span > select > option:nth-Child("+rowIndex+")")).click();
             }         
        }
        
        List<WebElement> itemsTitle2 = dpo.getItemListTitle();
        List<String> value2 = new ArrayList<String>();
        for(int j=0; j<itemsTitle2.size();j++) {
        	value2.add(itemsTitle2.get(j).getText().trim());
        }

        if(value2.equals(values)) {
           System.out.println("Items in list are sorted");
           Assert.assertTrue(true);
        }
        else
        {
        	System.out.println("Items in list are not sorted");
        	Assert.assertTrue(false);
        }
        
        driver.quit();
	}
	
	@Then ("validate the items are sorted from {string}")
	public void validate_the_items_are_sorted_from_Price_low_to_high(String val) {	   
		
		dpo = new DashboardPageObject(driver);

        driver.navigate().refresh();
        
		List<WebElement> priceTitleList = dpo.getItemPriceList();
		List<String> value1 = new ArrayList<String>();
		
        for(int i=0; i< priceTitleList.size(); i++) {
           value1.add(priceTitleList.get(i).getText().trim());
       }
        
        dpo.getItemsDropDown().click();
        
        List<WebElement> optionVal1 = dpo.getItemsDropDownOptions();
        for(int j=0; j< optionVal1.size();j++){
        	 String optionVal = optionVal1.get(j).getText();
        	 if(optionVal.equals(val)) {
        		 int rowIndex = optionVal1.size() - 1;
                 driver.findElement(By.cssSelector("div#header_container > div:nth-Child(2) > div:nth-Child(3) > span > select > option:nth-Child("+rowIndex+")")).click();   
        	 }
        }
        
        
        List<WebElement> priceTitleList2 = dpo.getItemPriceList();
        List<String>  value2 = new ArrayList<String>();
        
        for(int k=0; k<priceTitleList2.size();k++) {
        	   value2.add(priceTitleList2.get(k).getText().trim());
        }
        
        if(value2.equals(value1)) {
        	System.out.println("price list are sorted");
        	Assert.assertTrue(true);
        }
        else
        {
        	System.out.println("price list are unsorted");
        	Assert.assertTrue(false);
        }
	}
}
