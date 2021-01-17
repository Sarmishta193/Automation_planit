package org.planitdemowebshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshop_logout {

WebDriver driver;  
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")   
    WebElement logout;
	
	public Demowebshop_logout(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  
	
	//this method is for loggingout after checkout
	public Demowebshop_logout user_logout() {
		
		logout.click();
        System.out.println("logged out successfully");
        
		return new Demowebshop_logout (driver);
	}
}
