package org.planitdemowebshop.scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ecommercebasicproperties {


	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Demowebshop_properties\\planitdemowebshop.properties");
		Properties pr=new Properties();
		pr.load(fis);
		
		
		//launch of browser
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(pr.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click on login button
		driver.findElement(By.xpath(pr.getProperty("loginlink"))).click();
		
		//validating please sign in message
		String expvalue="Welcome, Please Sign In!";
		String actualvalue=driver.findElement(By.xpath(pr.getProperty("welcomemessage"))).getText();
		if(actualvalue.contains(expvalue)) {
			System.out.println("Login Page validated sucessfully");	
		}
		
		//login with credentials
		driver.findElement(By.xpath(pr.getProperty("username"))).sendKeys("atest@gmail.com");
		driver.findElement(By.xpath(pr.getProperty("password"))).sendKeys("123456");
		driver.findElement(By.xpath(pr.getProperty("login"))).click();
		//Thread.sleep(1000);
		
		//validate User account id
		String expuseraccountid="atest@gmail.com";
		String actvalueuseraccount=driver.findElement(By.xpath(pr.getProperty("Useraccountid"))).getText();
		if(expuseraccountid.contentEquals(actvalueuseraccount)) {
			System.out.println("User account id validated sucessfully");			
		}
		
		
		//clearing shopping cart
		String cartqnty=driver.findElement(By.xpath(pr.getProperty("shoppingcartvaluebeforeclear"))).getText();
		System.out.println("cart quantity after login=" + cartqnty);
		//driver.findElement(By.xpath(pr.getProperty("shoppingcartvaluebeforeclear"))).click();
	
		driver.findElement(By.xpath(pr.getProperty("shoppingcartvaluebeforeclear"))).click();
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("total checkboxes ="+allCheckbox.size());
		
		if(allCheckbox.size()!=0) {
			/*driver.findElement(By.xpath(pr.getProperty("shoppingcartvaluebeforeclear"))).click();
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("total checkboxes ="+allCheckbox.size());*/

			for (WebElement ele : allCheckbox) {
			      ele.click();
			      System.out.println("clicked");			   
			}
			driver.findElement(By.xpath(pr.getProperty("updatecart"))).click();
			System.out.println("cart cleared");
			//driver.findElement(By.xpath(pr.getProperty("shoppingcartafterclear"))).click();
			String cartqntyfinal=driver.findElement(By.xpath(pr.getProperty("cartquantityfinal"))).getText();
			System.out.println("cart quantity after clearing=" + cartqntyfinal);
			driver.findElement(By.xpath(pr.getProperty("clickhome"))).click();
		}
		else {
			System.out.println("cart is empty");
		}
			/*driver.findElement(By.xpath(pr.getProperty("updatecart"))).click();
			System.out.println("cart cleared");
			//driver.findElement(By.xpath(pr.getProperty("shoppingcartafterclear"))).click();
			String cartqntyfinal=driver.findElement(By.xpath("//span[@class='cart-qty']")).getText();
			System.out.println(cartqntyfinal);*/
			
		//click home after clearing shopping cart and selecting book
			driver.findElement(By.xpath(pr.getProperty("clickhome"))).click();
			driver.findElement(By.xpath(pr.getProperty("clickbookincategories"))).click();
			System.out.println("books category selected");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,200)");
	       
	        driver.findElement(By.xpath(pr.getProperty("selectbook"))).click();
	        
	       //Getting book price and sending quantity 
	        String bookprice=driver.findElement(By.xpath(pr.getProperty("bookpricevalue"))).getText();
	        System.out.println(bookprice);
	        js.executeScript("window.scrollBy(0,200)");
	        
	        WebElement bookquantity=driver.findElement(By.xpath(pr.getProperty("bookquantityvalue")));
	        bookquantity.click();
	        bookquantity.clear();
	        bookquantity.sendKeys("4");       
	        
	        //adding selected book to cart
	        driver.findElement(By.xpath(pr.getProperty("clickaddtocartbook"))).click();
	        System.out.println("product added");
	        
	        Thread.sleep(3000);
	        
	        //validating product added to cart message
	        
	        String expmsg="The product has been added to your shopping cart";
	        String actualmsg=driver.findElement(By.xpath(pr.getProperty("textafterproductadd"))).getText();   
			System.out.println("message notifiction after adding product=" + actualmsg);
	        
			if(expmsg.contains(actualmsg)) {
				System.out.println("product added successfully");
			}
			else {
				System.out.println("product not added");
			}
	               
	      String bookaddedcartvalue=  driver.findElement(By.xpath(pr.getProperty("cartafterbookadd"))).getText();
	        System.out.println("cart quantity after book addition=" + bookaddedcartvalue);
	        Thread.sleep(3000);
	        
	        //clicking cart for checkout
	        driver.findElement(By.xpath(pr.getProperty("clickcartforcheckout"))).click();
	        
	        //validating subtotal and total and printing values and clicking checkout
	      String subtotal=  driver.findElement(By.xpath(pr.getProperty("subtotalvalue"))).getText();
	      System.out.println("subtotal=" + subtotal);
	      String Total = driver.findElement(By.xpath(pr.getProperty("totalvalue"))) .getText();
	      System.out.println("total="+ Total);
	      if (subtotal.contains(Total)) {
	    	  System.out.println("Total value="+ Total + " you can proceed to checkout");
	    	  driver.findElement(By.xpath(pr.getProperty("termscheckbox"))).click();
	    	  js.executeScript("window.scrollBy(0,200)");
	    	  driver.findElement(By.xpath(pr.getProperty("clickcheckout"))).click();
	      }
	      
	      //checkout details
	      //billing address
	        Select billingdd= new Select(driver.findElement(By.xpath(pr.getProperty("billingaddress"))));
	        billingdd.selectByVisibleText("atest dummy, assd, abc 123, Iceland");
	        driver.findElement(By.xpath(pr.getProperty("billingaddresscontinue"))).click();
	        
	        //shipping address
	        js.executeScript("window.scrollBy(0,200)");
	        //Thread.sleep(2000);
	        Select shippingdd= new Select(driver.findElement(By.xpath(pr.getProperty("shippingaddress"))));
	        shippingdd.selectByVisibleText("atest dummy, assd, abc 123, Iceland");
	        driver.findElement(By.xpath(pr.getProperty("shippingaddresscontinue"))).click();
	         
	        //shipping method
	        //Thread.sleep(2000);
	        driver.findElement(By.xpath(pr.getProperty("shippingmethod"))).click();
	        driver.findElement(By.xpath(pr.getProperty("shippingmethodcontinue"))).click();
	        
	        //payment method
	        //Thread.sleep(2000);
	        driver.findElement(By.xpath(pr.getProperty("paymentmethod"))).click();
	        js.executeScript("window.scrollBy(0,200)");
	        driver.findElement(By.xpath(pr.getProperty("paymentmethodcontinue"))).click();
	        
	        //payment information  message validating
	        Thread.sleep(2000);
	         String payment_informationtextmessage=driver.findElement(By.xpath(pr.getProperty("paymentinformation"))).getText();
	         System.out.println("message is =" + payment_informationtextmessage);
	         String act_paymentinformation_txtmsg="You will pay by COD";
	         
	         if(payment_informationtextmessage.contains(act_paymentinformation_txtmsg)) {
	        	 driver.findElement(By.xpath(pr.getProperty("paymentinformationcontinue"))).click();
	        	 
	         }
	         
	         //confirm order
	         Thread.sleep(2000);
		     js.executeScript("window.scrollBy(0,200)");
	         driver.findElement(By.xpath(pr.getProperty("confirmorder"))).click();
	        
	         //validating order success message
	         Thread.sleep(2000);
	       String act_successtxtmsg=  driver.findElement(By.xpath(pr.getProperty("ordersuccessmessage"))).getText();
            String exp_successtxtmsg ="Your order has been successfully processed!";
            
            if(exp_successtxtmsg.contains(act_successtxtmsg)) {
            	System.out.println("Success text message is ="+ act_successtxtmsg);
            	Thread.sleep(2000);
            	String act_ordernumber=driver.findElement(By.xpath(pr.getProperty("ordernumbertext"))).getText();
            	System.out.println("your order number is =" + act_ordernumber);
          
            	//click continue for logout
            driver.findElement(By.xpath(pr.getProperty("continueafterconfirmorder"))).click();
            
            //logout
            driver.findElement(By.xpath(pr.getProperty("logout"))).click();
            System.out.println("logged out successfully");
            
            }
            
            
						
		driver.close();
	}

}
