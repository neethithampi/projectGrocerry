package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelRedClass;
import utility.ExplicitWaitClass;
import utility.GeneralUtility;

public class ManageProductPage {
	
	WebDriver driver;
	GeneralUtility gl = new GeneralUtility();
	ExplicitWaitClass ewc = new ExplicitWaitClass();
	ExcelRedClass erc = new ExcelRedClass();
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-tasks']")
	WebElement manageProduct;
	
	@FindBy(xpath="(//h4[@class='card-title'])[2]")
	WebElement listProducts;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newList;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement listTitle;
	
	@FindBy(xpath="//label[@class='radio-inline']//input[@value='Nonveg']")
	WebElement NonVegRadioButton;

	@FindBy(xpath="//select[@id='cat_id']")
	WebElement category;
	
	@FindBy(xpath="//select[@id='sub_id']")
	WebElement subCategory;
	
	@FindBy(xpath="//input[@id='purpose']")
	WebElement priceType;
	
	@FindBy(xpath="//input[@id='m_weight']")
	WebElement weight;
	
	@FindBy(xpath="//select[@id='w_unit']")
	WebElement weightUnit;
	
	@FindBy(xpath="//input[@id='max_weight']")
	WebElement maxQuanitity;
	
	@FindBy(xpath="//input[@id='w_price']")
	WebElement price;
	
	@FindBy(xpath="//input[@id='w_stock']")
	WebElement stock;
	
	@FindBy(xpath="(//input[@name='stock'])[1]")
	WebElement StockYesRadioButton;
	
	@FindBy(xpath="//input[@name='main_img']")
	WebElement image;
	
	@FindBy(xpath="(//input[@name='featured'])[2]")
	WebElement noRadioButton;
	
	@FindBy(xpath="(//input[@name='combo'])[1]")
	WebElement comboRadioButton;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement saveAlert;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//input[@name='un']")
	WebElement searchTitle;
	
	@FindBy(xpath="(//input[@class='form-control'])[2]")
	WebElement productCode;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement search2;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement search2Display;
	
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement delete;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement delAlert;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-fix']")
	WebElement reset;
	
	@FindBy(xpath="//h1[text()='List Products']")
	WebElement resetDisplay;
	
	@FindBy(xpath="//span[text()='Last']")
	WebElement last;
	
	@FindBy(xpath="//button[text()='P4']")
	WebElement lastDisplay;
	
	public ManageProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickManageProduct()
	{
		gl.clickElement(manageProduct);
	}
	
	public boolean isListDisplayed()
	{
		return gl.isDisplayed(listProducts);
	}
	
	public void clickNew()
	{
		gl.clickElement(newList);
	}
	
	
	public void enterTitle(String text)
	{
		gl.typeText(listTitle, text);
	}
	
	public void clickNonVeg()
	{
		gl.clickElement(NonVegRadioButton);
	}
	
	public void clickCategory()
	{
		gl.clickElement(category);
	}
	
	public void selectCategory()
	{
		gl.performSelect(category, 3);
		
	}
	
	
	public void sleepSubCategory() throws InterruptedException
	{
		gl.threadSleep();
	}
	
	public void clickSubCategory()
	{
		gl.clickElement(subCategory);
	}
	
	public void selectSubCategory()
	{
		gl.performSelect(subCategory, 8);
	}
	
	public void clickPriceType()
	{
		gl.clickElement(priceType);
	}
	
	public void scrollToWeight()
	{
		gl.scrollToFindElement(driver, weight);
	}
	
	public void enterWeight(String text)
	{
		gl.typeText(weight, text);
	}
	
	public void presenceOfWeightUnit()
	{
		ewc.waitPresenceOfElementLocated(driver, "//select[@id='w_unit']");
	}
	
	public void clickWeightUnit()
	{
		gl.clickElement(weightUnit);
	}
	
	public void performSelectWeightUnit()
	{
		gl.performSelect(weightUnit, 2);
	}
	
	public void presenceOfMaximumQuantity()
	{
		ewc.waitPresenceOfElementLocated(driver, "//input[@id='max_weight']");
	}
	
	public void enterMaximumQuantity(String text)
	{
		gl.typeText(maxQuanitity, text);
	}
	
	
	public void enterPrice(String text)
	{
		gl.typeText(price, text);
	}
	
	public void enterStock(String text)
	{
		gl.typeText(stock, text);
	}
	
	public void StockRadioButtonClickable()
	{
		ewc.waitElementToBeClickable(driver, StockYesRadioButton);
	}
	
	public void clickStockRadioButton()
	{
		gl.clickScroll(driver, StockYesRadioButton);
	}
	
	public void presenceOfImage()
	{
		ewc.waitPresenceOfElementLocated(driver, "//input[@name='main_img']");
	}
	
	public void uploadImage()
	{
		gl.imageUpload(driver, image);
	
	}
	
	public void presenceOfNoRadioButton()
	{
		ewc.waitPresenceOfElementLocated(driver, "(//input[@name='featured'])[2]");
	}
	
	public void clickNoRadioButton()
	{
		gl.clickScroll(driver, noRadioButton);
	}
	
	public void presnceOfComboRadioButton()
	{
		ewc.waitPresenceOfElementLocated(driver, "(//input[@name='combo'])[1]");
	}
	public void clickCombo()
	{
		gl.clickScroll(driver, comboRadioButton);
		
	}	

	public void presenceOfSave()
	{
		ewc.waitPresenceOfElementLocated(driver, "//button[@name='create']");
	}
	
	public void scrollToSave()
	{
		gl.clickScroll(driver, save);
	}
	
	public boolean alertSaveDisplayed()
	{
		return gl.isDisplayed(saveAlert);
	}
	
	public void clickSearch()
	{
		gl.clickElement(search);
	}
	
	public void enterSearchTitle(String text)
	{
		gl.typeText(searchTitle, text);
	}
	
	public boolean isSearchResultDisplayed()
	{
		return gl.isDisplayed(search2Display);
	}
	public void enterProductCode(String text)
	{
		gl.typeText(productCode, text);
	}
	
	public void clickSearch2()
	{
		gl.clickElement(search2);
	}
	
	public String  searchResult()
	{
		return gl.getText(search2Display);
	}
	
	public void presenceOfDel()
	{
		ewc.waitPresenceOfElementLocated(driver, "//i[@class='fas fa-trash-alt']");
	}
	
	public void clickDelete()
	{
		gl.clickScroll(driver, delete);
	}
	
	public void delAlertHandling()
	{
		gl.alertHandling(driver);
	}
	
	public boolean isDelAlertDisplayed()
	{
		return gl.isDisplayed(delAlert);
	}
	
	public void clickReset()
	{
		gl.clickElement(reset);
	}
	
	public boolean isResetResultDisplayed()
	{
		return gl.isDisplayed(resetDisplay);
	}
	
	public void scrollToLast() 
	{
		gl.scrollToFindElement(driver, last);
	}
	
	
	public void clickLast()
	{
		gl.clickScroll(driver, last);
	}
	
	public void scrollToLastDisplay()
	{
		gl.scrollToFindElement(driver, lastDisplay);
	}
	
	public void presencOfLast()
	{
		ewc.waitPresenceOfElementLocated(driver,"//table[@class='table table-bordered table-hover table-sm']//tbody//tr[9]//td[1]" );
	}
	
	public String getLastDisplayText()
	{
		return gl.getText(lastDisplay);
	}
	
	
	public void explicitWaitForClickingImage()
	{
		ewc.waitElementToBeClickable(driver, image);
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
