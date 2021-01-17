package org.planitdemowebshop.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshoplogin {
	
	WebDriver driver;  
    
    @FindBy(xpath = "//a[normalize-space()='Log in']")  
    WebElement Loginbutton;  
   
    public Demowebshoplogin (WebDriver driver) {  
         this.driver = driver;  
         PageFactory.initElements(driver, this);  
    }  
  
    // This method is to click on login button in home page  
    public Demowebshoplogin Click_loginbutton() {  
    	Loginbutton.click();
    	 return new Demowebshoplogin(driver);
    }
        

}
