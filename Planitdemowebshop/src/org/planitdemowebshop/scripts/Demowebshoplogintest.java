package org.planitdemowebshop.scripts;

import org.planitdemowebshop.page.Demowebshop_aftercheckout;
import org.planitdemowebshop.page.Demowebshop_afterlogin;
import org.planitdemowebshop.page.Demowebshop_bookaddtocart;
import org.planitdemowebshop.page.Demowebshop_bookselection;
import org.planitdemowebshop.page.Demowebshop_checkout;
import org.planitdemowebshop.page.Demowebshop_confirmorder;
import org.planitdemowebshop.page.Demowebshop_logout;
import org.planitdemowebshop.page.Demowebshoplogin;
import org.planitdemowebshop.page.Demowebshoploginpage;
import org.planitdemowebshop.page.TestBaseclass;
import org.testng.annotations.Test;

public class Demowebshoplogintest extends TestBaseclass{
  @Test
  public void Planitshoploginclick() throws InterruptedException {
	 
	  Demowebshoplogin dwsl= new Demowebshoplogin(driver);
	  dwsl.Click_loginbutton();
	  Demowebshoploginpage dwslp= new Demowebshoploginpage(driver);
	  dwslp.Login_withuserandpassword();
	  Demowebshop_afterlogin dwsal= new Demowebshop_afterlogin(driver);
	  dwsal.Clearing_shoppingcart();
	  Demowebshop_bookselection dwsbs=new Demowebshop_bookselection(driver);
	  dwsbs.select_book();
	  Demowebshop_bookaddtocart dwsbac=new Demowebshop_bookaddtocart(driver);
	  dwsbac.book_addtocart();
	  Demowebshop_checkout dwscheckout= new Demowebshop_checkout(driver);
	  dwscheckout.click_checkout();
	  Demowebshop_aftercheckout dwsaftercheckout= new Demowebshop_aftercheckout(driver);
	  dwsaftercheckout.checkout_details();
	  Demowebshop_confirmorder dwsconfirmorder= new Demowebshop_confirmorder(driver);
	  dwsconfirmorder.validate_orderdetails();
	  Demowebshop_logout dwslogout= new Demowebshop_logout(driver);
	  dwslogout.user_logout();
	  
	  
	 
  }
}
