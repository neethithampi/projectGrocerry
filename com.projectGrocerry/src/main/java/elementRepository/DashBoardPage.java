package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.GeneralUtility;

public class DashBoardPage {
	
	WebDriver driver;
	GeneralUtility gl = new GeneralUtility();
	ExcelRedClass erc = new ExcelRedClass();
	

	
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	WebElement dashBoard;
	
	@FindBy(xpath="(//div[@class='small-box bg-info'])[1]")
	WebElement managePages;
	
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[1]")
	WebElement moreInfo;
	
	@FindBy(xpath="//h1[text()='List Pages']")
	WebElement listPages;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public String getDashBoardText()
	{
		return gl.getText(dashBoard);
		
	}
	
	public boolean isManageTileDisplayed()
	{
		return gl.isDisplayed(managePages);
	}
	
	public void clickOnMoreInfo()
	{
		gl.clickElement(moreInfo);
	}
    
	public String getListPageText()
	{
		return gl.getText(listPages);
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
