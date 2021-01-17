package org.planitdemowebshop.scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demowebshopdatadrievn {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
    
        // To maximize browser  
        driver.manage().window().maximize();  
    
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
    
        // To open demo shop  
        driver.get(" http://demowebshop.tricentis.com/");  
        driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	
        FileInputStream Fis=new FileInputStream(System.getProperty("user.dir")+"\\Testdatadriven\\Testdatabook.xlsx");
        Thread.sleep(2000);
        //WorkBook
        
        XSSFWorkbook WB= new XSSFWorkbook(Fis);
        
        //Sheet
        
        XSSFSheet WS=WB.getSheet("Sheet1");
        
        //Row Count
        
        int Rcount=WS.getLastRowNum();
        System.out.println(Rcount);
        
        //Multiple Iterations ---- For Loop
        
        for (int i=1;i<=Rcount;i++) 
        {
       	 //Row
       	 
       	 XSSFRow WR=WS.getRow(i);
       	 
       	 //Cells
       	 
       	 XSSFCell WC=WR.getCell(0);
         XSSFCell WC1=WR.getCell(1);
        	 
        	 
        	//Cell Values
        	 
         driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
        	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(WC.getStringCellValue());
        	driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(WC1.getStringCellValue());
        	driver.findElement(By.xpath("//*[@class=\"button-1 login-button\"]")).click();  
        	driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
        	
    
        	 }
     
        
       System.out.println("Data driven success");
      WB.close();
      driver.close();
		
		

	}

}
