package executeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashBoardPage;
import elementRepository.LoginPage;

public class ExecuteDashBoardPage extends BaseClass {
	
	LoginPage lp;
	DashBoardPage dbp;
	

  @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderClass.class, groups = {"functional"})
  public void verifyDashBoardIsVisibleAfterLoginOrNot(String name, String pass) throws IOException {
	  lp = new LoginPage(driver);
	  dbp = new DashBoardPage(driver);
	  lp.enterUserName(dbp.readUsername(0, 1));
	  lp.enterPassword(dbp.readPassword(1, 1));
	  lp.clickOnLogin();
	 
	  String expectedPage = "Dashboard";
	  String actualPage = dbp.getDashBoardText();
	  
	  Assert.assertEquals(actualPage, expectedPage);
	  
  }
  
  @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderClass.class,groups = {"functional"})
  
  public void verifyManageTileIsPresentOrNot(String name, String pass)
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(name);
	  lp.enterPassword(pass);
	  lp.clickOnLogin();
	  dbp = new DashBoardPage(driver);
	  boolean ManagePageTile = dbp.isManageTileDisplayed();
	  
	  Assert.assertTrue(ManagePageTile);
	
  }
  
  @Test(dataProvider = "dataProvider1", dataProviderClass = DataProviderClass.class, groups = {"functional"})
  
  public void verifyListPagesIsDisplayedWhenClickedOnManagePagesMoreInfo(String name, String pass)
  {
	  lp = new LoginPage(driver);
	  lp.enterUserName(name);
	  lp.enterPassword(pass);
	  lp.clickOnLogin();
	  dbp = new DashBoardPage(driver);
	  dbp.clickOnMoreInfo();
	  String expectedText = "List Pages";
	  String actualText = dbp.getListPageText();
	  
	  Assert.assertEquals(actualText, expectedText);
  }
}


