package org.planitdemowebshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshoploginpage {

	
WebDriver driver;  
    
    @FindBy(xpath = "//*[@id='Email']")  
    WebElement usernameTextBox;
    
    @FindBy(xpath = "//*[@id='Password']")  
    WebElement passwordTextBox; 
    
    @FindBy(xpath = "//*[@class='button-1 login-button']")  
    WebElement Loginwithdata; 

public Demowebshoploginpage (WebDriver driver) {  
    this.driver = driver;  
    PageFactory.initElements(driver, this);  
}  

// This method is to login and validating welcome message on home page and getting value in shopping cart 
public Demowebshoploginpage Login_withuserandpassword() {  
	
	String expvalue="Welcome, Please Sign In!";
	String actualvalue=driver.findElement(By.xpath("//*[contains(text(),'Welcome, Please Sign In!')]")).getText();
	if(actualvalue.contains(expvalue)) {
		System.out.println("Login Page validated sucessfully");	
	}
	
       //providing username and password for login
		usernameTextBox.sendKeys("atest@gmail.com");
		passwordTextBox.sendKeys("123456");
	    Loginwithdata.click();
	    
	    //validating user account id
	    String expuseraccountid="atest@gmail.com";
		String actvalueuseraccount=driver.findElement(By.xpath("//*[@class='account']")).getText();
		if(expuseraccountid.contentEquals(actvalueuseraccount)) {
			System.out.println("User account id validated sucessfully");			
		}
		String cartqnty=driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]")).getText();
		System.out.println("cart quantity after login=" + cartqnty);
		
	 return new Demowebshoploginpage(driver);
}
}
