package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;

public class ExecuteLoginPage extends BaseClass{
	
	LoginPage lp;
	
  @Test(groups = {"functional"})
  public void verifyLoginPageIsVisibleWhileLaunchingTheApplication() {
	  lp = new LoginPage(driver);
	  
	  String expectedurl = "http://groceryapp.uniqassosiates.com/admin/login";
	  String actualurl = lp.getUrlOfTheLogin();
	  
	  Assert.assertEquals(expectedurl, actualurl);
  }
  
 
  @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderClass.class, groups = {"login"})
  
  public void verifySuccessfullLoginWithValidUsernameAndPassword(String name, String pass) throws IOException
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(name);
	  lp.enterPassword(pass);
	  lp.clickOnLogin();
	  String expectedUsername = "Admin";
	  String actualUsername = lp.getAdminText();
	  
	  Assert.assertEquals(actualUsername, expectedUsername);
  }
  
  @Test(groups = {"functional"})
  
  public void verifyRememberMeCheckboxIsSelectedOrNot()
  {
	  lp = new LoginPage(driver);
	  boolean rememberMe = lp.isRemembermeSelected();
	 Assert.assertFalse(rememberMe);
  }
  
  @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderClass.class, groups = {"functional"})
  
  public void isHomePageDisplayedWhileLogin(String name, String pass) throws IOException
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(name);
	  lp.enterPassword(pass);
	  lp.clickOnLogin();
	  String expectedUsername = "Admin";
	  String actualUsername = lp.getAdminText();
	  
	  Assert.assertEquals(expectedUsername, actualUsername);
	  
  }
  
  @Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClass.class,groups = {"login"})
  
  public void verifyUnsuccessfullLogin(String name, String pass) throws IOException
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(name);
	  lp.enterPassword(pass);
	  lp.clickOnLogin();
	  boolean actualAlertmsg = lp.isAlertMsgDisplayed();
	  Assert.assertTrue(actualAlertmsg);
  }
}
