package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageExpensePage;

public class ExecuteManageExpensePage extends BaseClass {
	
	LoginPage lp;
	ManageExpensePage emp;
  @Test(priority = 1, groups = {"functional"})
  public void verifyExpenseCategoryListIsDisplayedWhenClickedOnExpenseCategory() throws IOException 
  {
	  lp = new LoginPage(driver);
	  emp = new ManageExpensePage(driver);
	  lp.enterUserName(emp.readUsername(0, 1));
	  lp.enterPassword(emp.readPassword(1, 1));
	  lp.clickOnLogin();
	  
	  emp.clickManageExpense();
	  emp.clickExpenseCategory();
	  String expectedTitle = "Expense Category";
	  String actualTitle = emp.getExpenseCategoryTitle();
	  
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  
  @Test(priority = 2,groups = {"create"})
  
  public void verifyTheAdminCanCreateNewExpenseCategory() throws IOException
  {
	  lp = new LoginPage(driver);
	  emp = new ManageExpensePage(driver);
	  lp.enterUserName(emp.readUsername(0, 1));
	  lp.enterPassword(emp.readPassword(1, 1));
	  lp.clickOnLogin();
	  emp = new ManageExpensePage(driver);
	  emp.clickManageExpense();
	  emp.clickExpenseCategory();
	  emp.clickNew();
	  emp.typeNewExpense("neethi1");
	  emp.clickSave();
	  boolean res = emp.isNewAlertMsgDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 3, groups = {"search"})
  
  public void verifyTheAdminCanSearchNewlyCreatedExpenseCategory() throws IOException
  {
	  lp = new LoginPage(driver);
	  emp = new ManageExpensePage(driver);
	  lp.enterUserName(emp.readUsername(0, 1));
	  lp.enterPassword(emp.readPassword(1, 1));
	  lp.clickOnLogin();
	  emp = new ManageExpensePage(driver);
	  emp.clickManageExpense();
	  emp.clickExpenseCategory();
	  emp.clickSearch();
	  emp.typeSearchTitle("neethi1");
	  String expectedText = "neethi1";
	  String actualText = emp.getSearchText();
	  
	  Assert.assertEquals(actualText, expectedText);
	  
  }
  
  @Test(priority = 4, groups = {"edit"})
  
  public void verifyTheAdminCanEditTheNewlyCreatedExpenseCategory() throws IOException
  {
	  lp = new LoginPage(driver);
	  emp = new ManageExpensePage(driver);
	  lp.enterUserName(emp.readUsername(0, 1));
	  lp.enterPassword(emp.readPassword(1, 1));
	  lp.clickOnLogin();
	  emp = new ManageExpensePage(driver);
	  emp.clickManageExpense();
	  emp.clickExpenseCategory();
	  emp.clickSearch();
	  emp.typeSearchTitle("neethi1");
	  emp.clickSearch();
	  emp.clickEditButton();
	  emp.editTileClear();
	  emp.typeEditedExpense("neeti12");
	  emp.clickUpdateButton();
	  boolean res = emp.isEditAlertMsgDisplayed();
	  
	  Assert.assertTrue(res);
  }
  
  @Test(priority = 5, groups = {"delete"})
  
  public void verifyTheAdminCanDeleteTheCreatedExpenseCategory() throws IOException
  {
	  lp = new LoginPage(driver);
	  emp = new ManageExpensePage(driver);
	  lp.enterUserName(emp.readUsername(0, 1));
	  lp.enterPassword(emp.readPassword(1, 1));
	  lp.clickOnLogin();
	  emp = new ManageExpensePage(driver);
	  emp.clickManageExpense();
	  emp.clickExpenseCategory();
	  emp.clickSearch();
	  emp.typeSearchTitle("neeti12");
	  emp.clickSearch();
	  emp.clickDel();
	  emp.acceptDelAlert();
	  boolean res = emp.isDelAlertMsgDisplayed();
	  
	  Assert.assertTrue(res);
  }
}
