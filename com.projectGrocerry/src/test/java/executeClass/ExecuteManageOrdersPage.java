package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;

public class ExecuteManageOrdersPage extends BaseClass{
	
	LoginPage lp;
	ManageOrdersPage mop;
	
  @Test(groups = {"functional"})
  public void verifyTheAdminCanSearchAnOrderByUsingOrderId() throws IOException {
	  
	  lp = new LoginPage(driver);
	  mop = new ManageOrdersPage(driver);
	  lp.enterUserName(mop.readUsername(0, 1));
	  lp.enterPassword(mop.readPassword(1, 1));
	  lp.clickOnLogin();
	  
	  mop.clickManageOrders();
	  mop.clickSearch();
	  mop.enterOrderId("650");
	  mop.clickSearch2();
	  String expectedText = "650";
	  String actualText = mop.getResultText();
	  
	  Assert.assertEquals(actualText, expectedText);
  }
  
  @Test(groups = {"search"})
  
  public void verifyTheAdminCanViewTheOrderDetailsOfSearchedOrder() throws IOException
  {
	  lp = new LoginPage(driver);
	  mop = new ManageOrdersPage(driver);
	  lp.enterUserName(mop.readUsername(0, 1));
	  lp.enterPassword(mop.readPassword(1, 1));
	  lp.clickOnLogin();
	  mop = new ManageOrdersPage(driver);
	  mop.clickManageOrders();
	  mop.clickSearch();
	  mop.enterOrderId("650");
	  mop.clickSearch2();
	  mop.explicitWaitForView();
	  mop.clickScrollview();
	
	  boolean res = mop.isResultDisplayed();
	  
	  Assert.assertTrue(res);
	  
  }
}
