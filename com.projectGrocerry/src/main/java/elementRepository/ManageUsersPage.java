package elementRepository;

import java.io.IOException;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.NewClassRefForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.ExplicitWaitClass;
import utility.GeneralUtility;

public class ManageUsersPage {
	
	WebDriver driver;
	GeneralUtility gl = new GeneralUtility();
	ExcelRedClass erc = new ExcelRedClass();
	ExplicitWaitClass ewc = new ExplicitWaitClass();
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user']")
	WebElement manageUsers;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement listUsers;
	
	@FindBy(xpath="//i[@class=' fa fa-search']")
	WebElement search;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement name;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	WebElement search2;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	WebElement nameDisplay;
	
	@FindBy(xpath="//input[@id='ut']")
	WebElement email;
	
	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-sm']//tbody//td[1])[1]")
	WebElement emailDisplay;
	
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-success btncss'])[3]")
	WebElement status;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement statusAlert;
	
	public ManageUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickManageUsers()
	{
		gl.clickElement(manageUsers);
	}
	
	public boolean isListUserDisplayed()
	{
		return gl.isDisplayed(listUsers);
	}
	
	public void clickSearch()
	{
		gl.clickElement(search);
	}
	
	public void enterName(String text)
	{
		gl.typeText(name, text);
	}
	
	public void clickSearch2()
	{
		gl.clickElement(search2);
	}
	
	public boolean isNameDisplayed()
	{
		return gl.isDisplayed(nameDisplay);
	}
	
	public void enterEmail(String text)
	{
		gl.typeText(email, text);
	}
	
	public boolean isEmailDisplayed()
	{
		return gl.isDisplayed(emailDisplay);
	}
	
	public String readUsername(int r, int c) throws IOException
	{
		return erc.readStringData(r,c);
	}
	
	public String readPassword(int r,int c) throws IOException
	{
		return erc.readStringData(r,c);
	}
	
	public void presenceOfStatus()
	{
		ewc.waitPresenceOfElementLocated(driver, "(//a[@class='btn btn-sm btn btn-success btncss'])[3]");
	}
	
	public void clickStatus()
	{
		gl.clickScroll(driver, status);
	}
	
	public boolean isStatusAlertDisplayed()
	{
		return gl.isDisplayed(statusAlert);
	}


}
