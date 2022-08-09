package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.GeneralUtility;

public class VerifyUsersPage {

	WebDriver driver;
	GeneralUtility gl = new GeneralUtility();
	ExcelRedClass erc = new ExcelRedClass();
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user-check']")
	WebElement verifyUsers;
	
	@FindBy(xpath="//h1[text()='List Users']")
	WebElement listUsers;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//input[@id='un']")
	WebElement name;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	WebElement search2;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	WebElement searchDisplay;
	
	@FindBy(xpath="//input[@id='ph']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//td[2]")
	WebElement searchDisplay2;
	
	
	public VerifyUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickVerifyUsers()
	{
		gl.clickElement(verifyUsers);
	}
	
	public boolean isListUsersDisplayed()
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
		return gl.isDisplayed(searchDisplay);
	}
	
	public void enterPhoneNumber(String text)
	{
		gl.typeText(phoneNumber, text);
	}
	
	public boolean isNumberDisplayed()
	{
		return gl.isDisplayed(searchDisplay2);
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

