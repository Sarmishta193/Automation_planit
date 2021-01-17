package org.planitdemowebshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshop_checkout {

WebDriver driver;  
	
	@FindBy(xpath = "//input[@id='termsofservice']")   
    WebElement clicktermscheckbox;
	@FindBy(xpath = "//button[normalize-space()='Checkout']")   
    WebElement clickcheckoutbutton;
	
	
	public Demowebshop_checkout(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  
	
	//this method is to get sub total and total values and click checkout button
	public Demowebshop_checkout click_checkout() {
		
		
		String subtotal=  driver.findElement(By.xpath("//*[@class='product-price']")).getText();
	      System.out.println("subtotal=" + subtotal);
	      String Total = driver.findElement(By.xpath("//*[@class='product-price order-total']")) .getText();
	      System.out.println("total="+ Total);
	      if (subtotal.contains(Total)) {
	    	  System.out.println("Total value="+ Total + " you can proceed to checkout");
	    	  clicktermscheckbox.click();
	    	  JavascriptExecutor js = (JavascriptExecutor) driver;
	    	  js.executeScript("window.scrollBy(0,200)");
	    	  clickcheckoutbutton.click();
	      }
		
		return new Demowebshop_checkout (driver);
	}
	
	
}
