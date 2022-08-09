package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ExecuteManageProduct extends BaseClass{
	
	LoginPage lp;
	ManageProductPage mpp;
	
  @Test(priority = 1, groups = {"functional"})
  public void verifyWhenClickedOnManageProductsListProductsIsDisplayed() throws IOException {
	  
	  lp = new LoginPage(driver);
	  mpp = new ManageProductPage(driver);
	  lp.enterUserName(mpp.readUsername(0, 1));
	  lp.enterPassword(mpp.readPassword(1, 1));
	  lp.clickOnLogin();
	   mpp.clickManageProduct();
	  boolean res = mpp.isListDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 2, groups = {"new"})
  
  public void verifyTheUserIsAbleToAddNewList() throws InterruptedException, IOException
  {
	  lp = new LoginPage(driver);
	  mpp = new ManageProductPage(driver);
	  lp.enterUserName(mpp.readUsername(0, 1));
	  lp.enterPassword(mpp.readPassword(1, 1));
	  lp.clickOnLogin();
	  mpp.clickManageProduct();
	  mpp.clickNew();
	  mpp.enterTitle("fish");
	  mpp.clickNonVeg();
	  mpp.clickCategory();
	  mpp.selectCategory();
	  mpp.sleepSubCategory();
	  mpp.clickSubCategory();
	  mpp.selectSubCategory();
	  mpp.clickPriceType();
	  mpp.scrollToWeight();
	  mpp.enterWeight("2");
	  mpp.presenceOfWeightUnit();
	  mpp.clickWeightUnit();
	  mpp.performSelectWeightUnit();
	  mpp.presenceOfMaximumQuantity();
	  mpp.enterMaximumQuantity("3");
	  mpp.enterPrice("400");
	  mpp.enterStock("4");
	  mpp.StockRadioButtonClickable();
	  mpp.clickStockRadioButton();
	  mpp.presenceOfImage();
	  mpp.uploadImage();
	  mpp.presenceOfNoRadioButton();
	  mpp.clickNoRadioButton();
	  mpp.presnceOfComboRadioButton();
	  mpp.clickCombo();
	  mpp.presenceOfSave();
	  mpp.scrollToSave();
	  boolean res = mpp.alertSaveDisplayed();
	  
	  Assert.assertTrue(res);
	  
  }
  
  @Test(priority = 3, groups = {"search"})
  
  public void verifyUserCanSearchProductUsingProductName() throws IOException
  {
	  lp = new LoginPage(driver);
	  mpp = new ManageProductPage(driver);
	  lp.enterUserName(mpp.readUsername(0, 1));
	  lp.enterPassword(mpp.readPassword(1, 1));
	  lp.clickOnLogin();
	  mpp.clickManageProduct();
	  mpp.clickSearch();
	  mpp.enterSearchTitle("fish");
	  mpp.clickSearch2();
	  boolean res = mpp.isSearchResultDisplayed();
	  
	 Assert.assertTrue(res);
	  
  }
  
  @Test(priority = 4, groups = {"delete"})
  
  public void verifyTheUserCanDeleteCreatedProductOrNot() throws IOException
  {
	  lp = new LoginPage(driver);
	  mpp = new ManageProductPage(driver);
	  lp.enterUserName(mpp.readUsername(0, 1));
	  lp.enterPassword(mpp.readPassword(1, 1));
	  lp.clickOnLogin();
	  mpp.clickManageProduct();
	  mpp.clickSearch();
	  mpp.enterSearchTitle("fish");
	  mpp.clickSearch2();
	  mpp.clickDelete();
	  mpp.delAlertHandling();
	  boolean res = mpp.isDelAlertDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 5, groups = {"functional"})
  
  public void verifyResetIsWorkingOrNot() throws IOException
  {
	  lp = new LoginPage(driver);
	  mpp = new ManageProductPage(driver);
	  lp.enterUserName(mpp.readUsername(0, 1));
	  lp.enterPassword(mpp.readPassword(1, 1));
	  lp.clickOnLogin();
	  mpp.clickManageProduct();
	  mpp.clickSearch();
	  mpp.enterSearchTitle("fish");
	  mpp.clickSearch2();
	  mpp.clickReset();
	  boolean res = mpp.isResetResultDisplayed();
	  Assert.assertTrue(res);
	  
  }
  
  @Test(priority = 6, groups = {"navigate"})
  
  public void verifyUserCanNavigateToLastPageWhenClickedOnLast() throws IOException
  {
	  lp = new LoginPage(driver);
	  mpp = new ManageProductPage(driver);
	  lp.enterUserName(mpp.readUsername(0, 1));
	  lp.enterPassword(mpp.readPassword(1, 1));
	  lp.clickOnLogin();
	  mpp.clickManageProduct();
	  mpp.scrollToLast();
	  mpp.clickLast();
	  mpp.scrollToLastDisplay();
	  mpp.presencOfLast();
	  
	  String expectedText = "P4";
	  String actualText = mpp.getLastDisplayText();
	  
	  Assert.assertEquals(actualText, expectedText);;
  }
}
