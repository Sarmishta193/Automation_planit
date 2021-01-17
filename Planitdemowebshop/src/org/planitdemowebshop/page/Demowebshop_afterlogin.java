package org.planitdemowebshop.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshop_afterlogin {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[2]")  
    WebElement Cartqntyafterlogin;
	
	public Demowebshop_afterlogin(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  
	
//this method is for clearing shopping cart before purchasing
	public Demowebshop_afterlogin Clearing_shoppingcart() {
	List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
	System.out.println("total checkboxes ="+allCheckbox.size());
	if(allCheckbox.size()!=0) {
		for (WebElement ele : allCheckbox) {
		      ele.click();
		      System.out.println("clicked");			   
		}
		driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		System.out.println("cart cleared");
		String cartqntyfinal=driver.findElement(By.xpath("//span[@class='cart-qty']")).getText();
		System.out.println("cart quantity after clearing=" + cartqntyfinal);
		driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']")).click();
	}
	else {
		System.out.println("cart is empty");
	}
	
	
	
	return new Demowebshop_afterlogin(driver);
	
}
}
