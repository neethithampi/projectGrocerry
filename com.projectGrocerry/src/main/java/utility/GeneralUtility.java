package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtility {
	
	public void clickElement(WebElement element)
	{
		element.click();
	}
    
	public void typeText(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
		
	}
	
	public boolean isSelected(WebElement element)
	{
		return element.isSelected();
	}
	
	
	
	public boolean isDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public boolean isEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	
	public void threadSleep() throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	public void scrollToFindElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	
	public void clickScroll(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public String getCurrentUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public void alertHandling(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void clearText(WebElement element)
	{
		element.clear();
	}
	
	public void performAction(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);

		actions.click(element).build().perform();
	}
	
	public void performSelect(WebElement element, int x)
	{
		Select select = new Select(element);
		select.selectByIndex(x);
	}
	
	public void refreshPage(WebDriver driver, WebElement element)
	{
		driver.navigate().refresh();
		element.click();
	}
	
	public void imageUpload(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		element = new WebDriverWait(driver,Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(element));
		js.executeScript("arguments[0].click();", element);
		element.sendKeys("C:\\Users\\AMMU\\Desktop\\TestNg\\com.grocerry7mart\\src\\main\\resources\\fish.jpg");
	}
}
