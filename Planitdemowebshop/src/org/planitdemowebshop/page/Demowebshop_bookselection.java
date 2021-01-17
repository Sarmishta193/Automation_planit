package org.planitdemowebshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demowebshop_bookselection {
	
WebDriver driver;  
	
	@FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']")   
    WebElement clickhomepage;
	@FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Books']")   
    WebElement clickbooks;
	
	public Demowebshop_bookselection(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  
	
	//this method is for selecting books category and clicking selected book

	public Demowebshop_bookselection select_book() {
		
		//selecting books category
		clickhomepage.click();
		clickbooks.click();
		
		System.out.println("books category selected");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        
        //selecting book
        //driver.findElement(By.xpath("//*[contains(text(),'Computing and Internet')]")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Computing and Internet']")).click();
        System.out.println("one book selected");
     
		
		return new Demowebshop_bookselection (driver);
		
	}
	

}
