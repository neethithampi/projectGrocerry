package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;

public class ExecuteManageUsersPage extends BaseClass{
	
	LoginPage lp;
	ManageUsersPage mup;
  @Test(priority = 1, groups = {"functional"})
  public void verifyListUsersPageIsDisplayedWhenClickedOnManageUsersPage() throws IOException {
	  
	  lp = new LoginPage(driver);
	  mup = new ManageUsersPage(driver);
	  lp.enterUserName(mup.readUsername(0, 1));
	  lp.enterPassword(mup.readPassword(1, 1));
	  lp.clickOnLogin();
	  
	  mup.clickManageUsers();
	  boolean res = mup.isListUserDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 2, groups = {"search"})
  
  public void verifyUserCanPerformSearchUsingName() throws IOException
  {
	  lp = new LoginPage(driver);
	  mup = new ManageUsersPage(driver);
	  lp.enterUserName(mup.readUsername(0, 1));
	  lp.enterPassword(mup.readPassword(1, 1));
	  lp.clickOnLogin();
	  mup = new ManageUsersPage(driver);
	  mup.clickManageUsers();
	  mup.clickSearch();
	  mup.enterName("Aradhana Abraham");
	  mup.clickSearch2();
	  boolean res = mup.isNameDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 3, groups = {"search"})
  
  public void verifyUserCanPerformSearchUsingEmail() throws IOException
  {
	  lp = new LoginPage(driver);
	  mup = new ManageUsersPage(driver);
	  lp.enterUserName(mup.readUsername(0, 1));
	  lp.enterPassword(mup.readPassword(1, 1));
	  lp.clickOnLogin();
	  mup = new ManageUsersPage(driver);
	  mup.clickManageUsers();
	  mup.clickSearch();
	  mup.enterEmail("shahubanu691@gmail.com");
	  mup.clickSearch2();
	  boolean res = mup.isEmailDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 4, groups = {"edit"})
  
  public void verifyTheAdminCanChangeTheStatusOfAnyUser() throws IOException
  {
	  lp = new LoginPage(driver);
	  mup = new ManageUsersPage(driver);
	  lp.enterUserName(mup.readUsername(0, 1));
	  lp.enterPassword(mup.readPassword(1, 1));
	  lp.clickOnLogin();
	  mup.clickManageUsers();
	  mup.presenceOfStatus();
	  mup.clickStatus();
	  boolean res = mup.isStatusAlertDisplayed();
	  
	  Assert.assertTrue(res);
  }
}
