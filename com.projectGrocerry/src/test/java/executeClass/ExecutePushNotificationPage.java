package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;
import elementRepository.PushNotificationPage;

public class ExecutePushNotificationPage extends BaseClass {
	
	LoginPage lp;
	PushNotificationPage pnp;
  @Test(priority = 1, groups = {"functional"})
  public void verifyPushNotificationPageIsDisplayedWhenClickedOnPushNotification() throws IOException {
	  
	  lp = new LoginPage(driver);
	  pnp = new PushNotificationPage(driver);
	  lp.enterUserName(pnp.readUsername(0, 1));
	  lp.enterPassword(pnp.readPassword(1, 1));
	  lp.clickOnLogin();
	  pnp.clickPushNotification();
	  boolean res = pnp.isPushNotificationDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 2, groups = {"send"})
  
  public void verifyAdminCanSendNotificationSuccessfullyOrNot() throws IOException
  {
	  lp = new LoginPage(driver);
	  pnp = new PushNotificationPage(driver);
	  lp.enterUserName(pnp.readUsername(0, 1));
	  lp.enterPassword(pnp.readPassword(1, 1));
	  lp.clickOnLogin();
	  pnp.clickPushNotification();
	  pnp.enterTitle("fish");
	  pnp.enterDescription("fresh fish");
	  pnp.clickSend();
	  boolean res = pnp.isSendAlertDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 3, groups = {"functional"})
  
  public void verifyResetButtonIsVisibleOrNot() throws IOException
  {
	  lp = new LoginPage(driver);
	  pnp = new PushNotificationPage(driver);
	  lp.enterUserName(pnp.readUsername(0, 1));
	  lp.enterPassword(pnp.readPassword(1, 1));
	  lp.clickOnLogin();
	  pnp.clickPushNotification();
	  
	  String expectedText = "Reset";
	  String actualText = pnp.getResetText();
	  
	  
	  Assert.assertEquals(actualText, expectedText);
  }
}
