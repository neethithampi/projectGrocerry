package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.GeneralUtility;

public class LoginPage {
	
	WebDriver driver;
	
	GeneralUtility gl = new GeneralUtility();
	ExcelRedClass erc = new ExcelRedClass();
	
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	WebElement userName;
	
	@FindBy(xpath="(//input[@class='form-control'])[2]")
	WebElement password;
	
	@FindBy(id="remember")
	WebElement RemembermeCheckbox;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMsg;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement loginButton;
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	WebElement admin;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUserName(String uName)
	{
		gl.typeText(userName, uName);
	}
	
	public void enterPassword(String pass)
	{
		gl.typeText(password, pass);
	}
	
	public void clickOnLogin()
	{
		gl.clickElement(loginButton);
	}
	
	public boolean isRemembermeSelected()
	{
		return gl.isSelected(RemembermeCheckbox);
	}
	
	public String getUrlOfTheLogin()
	{
		return gl.getCurrentUrl(driver);
	}
	
	public boolean isAlertMsgDisplayed()
	{
		return gl.isDisplayed(alertMsg);
	}
	
	public String getAdminText()
	{
		return gl.getText(admin);
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
