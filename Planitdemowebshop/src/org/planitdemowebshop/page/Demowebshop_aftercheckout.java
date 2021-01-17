package org.planitdemowebshop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Demowebshop_aftercheckout {

	
WebDriver driver;  
	
	@FindBy(xpath = "//*[@id='billing-address-select']")   
    WebElement billingadd;
	@FindBy(xpath = "//*[@class='button-1 new-address-next-step-button']")   
    WebElement clickcontinuebillingad;
	@FindBy(xpath = "//*[@name='shipping_address_id']")   
    WebElement shippingadd;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")   
    WebElement clickcontiuneshippingad;
	@FindBy(xpath = "//input[@id='shippingoption_1']")   
    WebElement shippingmethod;
	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")   
    WebElement continueshippingmethod;
	@FindBy(xpath = "//input[@id='paymentmethod_0']")   
    WebElement paymentmethod;
	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")   
    WebElement continuepaymentmethod;
	@FindBy(xpath ="//input[@class='button-1 payment-info-next-step-button']")   
    WebElement continuepaymentinformation ;
	@FindBy(xpath ="//input[@value='Confirm']")   
    WebElement confirmorder ;
	
	
	public Demowebshop_aftercheckout(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  
	
	//this method is to provide billing details, shipping address for checkout
	//validating you will pay by cod text message
	public Demowebshop_aftercheckout checkout_details() throws InterruptedException {
		
		//billing address
		Select billing_add= new Select(billingadd);
        billing_add.selectByVisibleText("atest dummy, assd, abc 123, Iceland");
        clickcontinuebillingad.click();
        
        //shipping address
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        Select shipping_add= new Select(shippingadd);
        shipping_add.selectByVisibleText("atest dummy, assd, abc 123, Iceland");
        clickcontiuneshippingad.click();
         
        //shipping method
        Thread.sleep(2000);
        shippingmethod.click();
        continueshippingmethod.click();
        
        //payment method
        Thread.sleep(2000);
        paymentmethod.click();
        js.executeScript("window.scrollBy(0,200)");
        continuepaymentmethod.click();
         
        Thread.sleep(2000);
         String payment_informationtextmessage=driver.findElement(By.xpath("//p[normalize-space()='You will pay by COD']")).getText();
         System.out.println("message is =" + payment_informationtextmessage);
         String act_paymentinformation_txtmsg="You will pay by COD";
         
         if(payment_informationtextmessage.contains(act_paymentinformation_txtmsg)) {
        	 continuepaymentinformation.click();
        	 
         }
         
         //confirm order
         Thread.sleep(2000);
	     js.executeScript("window.scrollBy(0,200)");
	     confirmorder.click();
		
		
		return new Demowebshop_aftercheckout (driver);
	}
	
}
