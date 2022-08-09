package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.GeneralUtility;

public class ManageExpensePage {
	
	WebDriver driver;
	GeneralUtility gl = new GeneralUtility();
	ExcelRedClass erc = new ExcelRedClass();
	
	@FindBy(xpath="(//i[@class='fas fa-angle-left right'])[1]")
	WebElement manageExpense;
	
	@FindBy(xpath="//*[text()='Expense Category']")
	WebElement expenseCategory;
	
	@FindBy(xpath="(//h4[contains(text(),'Expense Category')])[2]")
	WebElement expenseCategoryTitle;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newExpense;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement newTitle;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement newAlertMsg;
	
	@FindBy(xpath="(//button[@class='btn btn-block-sm btn-danger'])[2]")
	WebElement save;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")	
	WebElement search;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement searchTitle;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	WebElement searchResult;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement clickEdit;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement editTitle;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	WebElement updateEdit;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlert;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement delete;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement delAlert;
	
	public ManageExpensePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickManageExpense()
	{
		gl.clickElement(manageExpense);
	}
	
	public void clickExpenseCategory()
	{
		gl.clickElement(expenseCategory);
	}
	
	public String getExpenseCategoryTitle()
	{
		return gl.getText(expenseCategoryTitle);
	}
	
	public void clickNew()
	{
		gl.clickElement(newExpense);
	}
	
	public void typeNewExpense(String text)
	{
		gl.typeText(newTitle,text);
	}
	
	public void clickSave()
	{
		gl.clickElement(save);
	}
	
	public boolean isNewAlertMsgDisplayed()
	{
		return gl.isDisplayed(newAlertMsg);
	}
	
	public void clickSearch()
	{
		gl.clickElement(search);
	}
	
	public void typeSearchTitle(String text)
	{
		gl.typeText(search, text);
	}
	public String getSearchText()
	{
		return gl.getText(searchResult);
	}
	
	public void clickEditButton()
	{
		gl.clickElement(clickEdit);
	}
	
	public void typeEditedExpense(String text)
	{
		gl.typeText(editTitle, text);
	}
	
	public void clickUpdateButton()
	{
		gl.clickElement(updateEdit);
	}
	
	public boolean isEditAlertMsgDisplayed()
	{
		return gl.isDisplayed(updateAlert);
	}
	
	public void clickDel()
	{
		gl.clickElement(delete);
	}
	
	public void acceptDelAlert()
	{
		gl.alertHandling(driver);
	}
	
	public void editTileClear()
	{
		gl.clearText(editTitle);
	}
	
	public boolean isDelAlertMsgDisplayed()
	{
		return gl.isDisplayed(delAlert);
	}
	
	public String readUsername(int r, int c) throws IOException
	{
		return erc.readStringData(r,c);
	}
	
	public String readPassword(int r,int c) throws IOException
	{
		return erc.readStringData(r,c);
	}

}
