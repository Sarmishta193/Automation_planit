package org.planitdemowebshop.page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBaseclass {
	
	public static WebDriver driver;
	@BeforeSuite  
    public void initializeWebDriver() throws IOException {  
         
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();  
     
         // To maximize browser  
         driver.manage().window().maximize();  
     
         // Implicit wait  
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
     
         // To open demo shop  
         driver.get(" http://demowebshop.tricentis.com/");  
    }  
   
    @AfterSuite  
    public void quitDriver() {  
         driver.quit();  
    }
}
