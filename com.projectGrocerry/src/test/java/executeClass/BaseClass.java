package executeClass;

import org.testng.annotations.Test;

import utility.ScreenShotClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.ITestListener;

import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	WebDriver driver;
	ScreenShotClass sh;
	public static Properties property;
	
	public static void readProperty() throws IOException 
	{
		property = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		property.load(fs);
		
	}
  
  @BeforeMethod(groups = {"open"})
  @Parameters("browser")
  public void beforeMethod(String browseValue) throws IOException {
	  
	  readProperty();
	  
	  if(browseValue.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty(property.getProperty("ChromeSystemProperty"),System.getProperty("user.dir")+property.getProperty("ChromeDriverPath"));
		  driver = new ChromeDriver();
	  }
	  
	  else if(browseValue.equalsIgnoreCase("edge"))
	  {
		  System.setProperty(property.getProperty("EdgeSystemProperty"),System.getProperty("user.dir")+property.getProperty("EdgeDriverPath"));
		  driver = new EdgeDriver();
	  }
	  
	  else if(browseValue.equalsIgnoreCase("firefox"))
	  {
		 System.setProperty(property.getProperty("FirefoxSystemProperty"), System.getProperty("user.dir")+property.getProperty("FirefoxDriverPath"));
		 driver = new FirefoxDriver();
	  }
	  
	  driver.get(property.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
  }

  @AfterMethod(groups = {"close"})
  public void afterMethod(ITestResult itr) throws IOException {
	  
	  if(itr.getStatus() == ITestResult.FAILURE)
	  {
		  sh = new ScreenShotClass();
		  sh.takeScreenShot(driver, itr.getName());
	  }
	  
	  driver.close();
  }

}
