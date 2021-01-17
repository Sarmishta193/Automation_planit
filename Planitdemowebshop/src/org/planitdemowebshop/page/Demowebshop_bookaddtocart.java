package org.planitdemowebshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshop_bookaddtocart {
WebDriver driver; 
	
	@FindBy(xpath = "//*[@id='addtocart_13_EnteredQuantity']")   
    WebElement bookquantity;
	@FindBy(xpath = "//*[@id='add-to-cart-button-13']")   
    WebElement bookaddtocart;
	@FindBy(xpath = " //span[@class='cart-qty']")   
    WebElement clickcartforcheckout;
	
	
	public Demowebshop_bookaddtocart(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  
	
	//this method is to get book price and providing quantity of book and click add to cart
	//validating product has been added to your shopping cart message 
	//clicking shopping cart for checkout
	public Demowebshop_bookaddtocart book_addtocart() throws InterruptedException {
		
		//get book price and provide quantity and click add to cart
		String bookprice=driver.findElement(By.xpath("//span[@class='price-value-13']")).getText();
        System.out.println(bookprice);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        bookquantity.click();
        bookquantity.clear();
        bookquantity.sendKeys("4");
        
        bookaddtocart.click();
        System.out.println("product added");
        
        Thread.sleep(3000);
        
        //validating text message
        String expmsg="The product has been added to your shopping cart";
        
    	String actualmsg=driver.findElement(By.xpath("//*[contains(text(),'The product has been added to your')]")).getText();   
		System.out.println("message notifiction after adding product=" + actualmsg);
		if(expmsg.contains(actualmsg)) {
			System.out.println("product added successfully");
		}
		else {
			System.out.println("product not added");
		}
		
		String bookaddedcartvalue=  driver.findElement(By.xpath("//span[@class='cart-qty']")).getText();
        System.out.println("cart quantity after book addition=" + bookaddedcartvalue);
        Thread.sleep(1000);
      
        //click shopping cart for checkout
        clickcartforcheckout.click();
        		
		return new Demowebshop_bookaddtocart (driver);
	}

}
