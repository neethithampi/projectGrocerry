package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.VerifyUsersPage;

public class ExecuteVerifyUsersPage extends BaseClass {
	
	LoginPage lp;
	VerifyUsersPage vup;
  @Test(priority = 1, groups = {"functional"})
  public void verifyListUsersPageIsDisplayedWhenClickedOnVerifyUsersPage() throws IOException {
	  
	  lp = new LoginPage(driver);
	  vup = new VerifyUsersPage(driver);
	  lp.enterUserName(vup.readUsername(0, 1));
	  lp.enterPassword(vup.readPassword(1, 1));
	  lp.clickOnLogin();
	  vup.clickVerifyUsers();
	  boolean res = vup.isListUsersDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 2, groups = {"search"})
  
  public void verifyUserCanSearchUsingName() throws IOException
  {
	  lp = new LoginPage(driver);
	  vup = new VerifyUsersPage(driver);
	  lp.enterUserName(vup.readUsername(0, 1));
	  lp.enterPassword(vup.readPassword(1, 1));
	  lp.clickOnLogin();
	  vup = new VerifyUsersPage(driver);
	  vup.clickVerifyUsers();
	  vup.clickSearch();
	  vup.enterName("Ani P");
	  vup.clickSearch2();
	  boolean res = vup.isNameDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 3, groups = {"search"})
  
  public void verifyUserCanSearchUsingPhoneNumber() throws IOException
  {
	  lp = new LoginPage(driver);
	  vup = new VerifyUsersPage(driver);
	  lp.enterUserName(vup.readUsername(0, 1));
	  lp.enterPassword(vup.readPassword(1, 1));
	  lp.clickOnLogin();
	  vup = new VerifyUsersPage(driver);
	  vup.clickVerifyUsers();
	  vup.clickSearch();
	  vup.enterPhoneNumber("8589063132");
	  vup.clickSearch2();
	  boolean res = vup.isNumberDisplayed();
	  
	  Assert.assertTrue(res);
  }
}
