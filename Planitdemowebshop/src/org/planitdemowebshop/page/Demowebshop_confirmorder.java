package org.planitdemowebshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshop_confirmorder {
	
WebDriver driver;  
	
	@FindBy(xpath = "//input[@value='Continue']")   
    WebElement contiuneafterconfirmorder;
	
	public Demowebshop_confirmorder(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  

	//this method is to validate order processed successfully and printing order number
	 //and clicking continue button to redirect to home page
	public Demowebshop_confirmorder validate_orderdetails() throws InterruptedException {
		
		//validating order has been processed successfully
		Thread.sleep(2000);
		String act_successtxtmsg=  driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
        String exp_successtxtmsg ="Your order has been successfully processed!";
        
        //printing order number
        if(exp_successtxtmsg.contains(act_successtxtmsg)) {
        	System.out.println("Success text message is ="+ act_successtxtmsg);
        	Thread.sleep(2000);
        	String act_ordernumber=driver.findElement(By.xpath("//*[contains(text(),'Order number')]")).getText();
        	System.out.println("your order number is =" + act_ordernumber);
        	contiuneafterconfirmorder.click();
		
	}
        return new Demowebshop_confirmorder (driver);
}
}
