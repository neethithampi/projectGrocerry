package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.ExplicitWaitClass;
import utility.GeneralUtility;

public class ManageOrdersPage {
	
	WebDriver driver;
	GeneralUtility gl = new GeneralUtility();
	ExplicitWaitClass ewc = new ExplicitWaitClass();
	ExcelRedClass erc = new ExcelRedClass();
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-basket']")
	WebElement manageOrders;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//input[@id='od']")
	WebElement orderId;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement search2;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//td[1]")
	WebElement result;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//td[7]//a[@class='btn btn-block btn-outline-info btn-sm']")
	WebElement view;
	
	@FindBy(xpath="//*[text()='shibigha R']")
	WebElement displayedRes;
	
	public ManageOrdersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickManageOrders()
	{
		gl.clickElement(manageOrders);
	}
	
	public void clickSearch()
	{
		gl.clickElement(search);
	}
	
	public void enterOrderId(String text)
	{
		gl.typeText(orderId, text);
	}
	
	public void clickSearch2()
	{
		gl.clickElement(search2);
	}
	
	public String getResultText()
	{
		return gl.getText(result);
	}
	
	public void clickView()
	{
		gl.clickElement(view);
	}
	
	public boolean isResultDisplayed()
	{
		return gl.isDisplayed(displayedRes);
	}
	
	public void scrollToFindView()
	{
		gl.scrollToFindElement(driver, view);
	}
	
	public void performActionOnView()
	{
		gl.performAction(driver,view);
	}
	
	public void clickScrollview()
	{
		gl.clickScroll(driver, view);
	}
	
	public void explicitWaitForView()
	{
		ewc.waitElementToBeClickable(driver, view);
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
