package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.ExplicitWaitClass;
import utility.GeneralUtility;

public class PushNotificationPage {
	
	WebDriver driver;
	GeneralUtility gl = new GeneralUtility();
	ExcelRedClass erc = new ExcelRedClass();
	ExplicitWaitClass ewc = new ExplicitWaitClass();
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-fas fa-bell']")
	WebElement pushNotfication;
	
	@FindBy(xpath="//h1[@class='m-0 text-dark']")
	WebElement pushDisplay;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement description;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement send;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement sendAlert;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']")
	WebElement reset;
	
	
	public PushNotificationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickPushNotification()
	{
		gl.clickElement(pushNotfication);
	}
	
	public boolean isPushNotificationDisplayed()
	{
		return gl.isDisplayed(pushDisplay);
	}
	
	public void enterTitle(String text)
	{
		gl.typeText(title, text);
	}
	
	public void enterDescription(String text)
	{
		gl.typeText(description, text);
	}
	
	public void clickSend()
	{
		gl.clickElement(send);
	}
	
	public boolean isSendAlertDisplayed()
	{
		return gl.isDisplayed(sendAlert);
	}
	
	public String getResetText()
	{
		return gl.getText(reset);
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
