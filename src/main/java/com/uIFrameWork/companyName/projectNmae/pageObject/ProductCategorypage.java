package com.uIFrameWork.companyName.projectNmae.pageObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.javaScript.JavaScriptHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.select.DropDownHealper;
import com.uIFrameWork.companyName.projectNmae.hepler.wait.Waithelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

/**
 * 
 * @author Lakshmi
 *
 */
public class ProductCategorypage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	Waithelper waithealper;
	Actions action;
	JavaScriptHelper javaScriptHelper;
	
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tShirtsMenu;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	public WebElement tShirtscategory;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a")
	public WebElement blousescategory;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a")
	public WebElement casualDressescategory;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[2]/a")
	public WebElement eveningDressescategory;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a")
	public WebElement summerDressescategory;
	
	@FindBy(xpath = "//*[@id='ul_layered_category_0']/li[2]")
	public WebElement categoriesSelection;
	
	@FindBy(xpath = "//input[@id='layered_id_attribute_group_1']")
	public WebElement smallSizeSelection;
	
	@FindBy(xpath = "//input[@name='layered_id_attribute_group_13']")
	public WebElement colorSelection;
	
	@FindBy(xpath = "//*[@id='ul_layered_id_feature_5']/li[1]/label/a")
	public WebElement compositionsSelection;
	
	@FindBy(xpath = "//input[@id='layered_id_feature_11']")
	public WebElement styleSelection;
	
	@FindBy(xpath = "//input[@id='layered_id_feature_19']")
	public WebElement propertiesSelection;
	
	@FindBy(xpath = "//input[@id='layered_quantity_1']")
	public WebElement availabilitySelection;
	
	@FindBy(xpath = "//input[@id='layered_manufacturer_1']")
	public WebElement manufacturerSelection;
	
	@FindBy(xpath = "//input[@id='layered_condition_new']")
	public WebElement conditionSelection;
	
	@FindBy(xpath = "//div[@style='left: 0%; width: 78%;']")
	public WebElement priceRangeSelection;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
	public WebElement itemSelection;
	
	@FindBy(xpath = "//a[@data-id-product='1']//span[text()='Add to cart']")
	public WebElement addTocart;
	
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	public WebElement proceedToCheckout;
	
	@FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]/span")
	public WebElement proceedToCheckoutSummery;
	
	@FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
	public WebElement proceedToCheckoutAddress;
	
	@FindBy(xpath = "//*[@id='form']/p/button/span")
	public WebElement proceedToCheckoutShipping;
	
	@FindBy(xpath = "//input[@id='cgv']")
	public WebElement termsOfServices;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li")
	List<WebElement> listOfItems;
	
	@FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[1]/div/div/span[1]")
	List<WebElement> priceList;
	
	@FindBy(xpath = "//select[@id='selectProductSort']")
	WebElement sortBy;
	
	@FindBy(xpath = "//a[@title='View my shopping cart']")
	WebElement cart;
	
	public ProductCategorypage(WebDriver driver){
		this.driver = driver;
		log.info("Driver initialized in th NavigationsMenu page");
		PageFactory.initElements(driver, this);
		waithealper = new Waithelper(driver);
		waithealper.waitForelementToBeClickable(womenMenu, ObjectReader.reader.getImplicitwait());
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
		TestBase.logExtentReport("opened the Product Category page");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void blousesSelection(){
		action = new Actions(driver);
		action.moveToElement(womenMenu).build().perform();
		womenMenu.click();
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
	}
	
	public void mouseOverOnTheItem(int num){
		String Fxpath = "//*[@id='center_column']/ul/li[";
		String Sxpath = "]/div/div[1]/div/a[1]/img";
		WebElement selectitem = driver.findElement(By.xpath(Fxpath+num+Sxpath));
		action = new Actions(driver);
		action.moveToElement(selectitem).build().perform();
	}
	
	public void clickAndAddToCart(){
		log.info("selected item adding in to cart");
		addTocart.click();
	}
	
	public void clickOnproceedToCheckout(){
		log.info("Click on :"+proceedToCheckout.toString());
		proceedToCheckout.click();
	}
	
	public void selectColor(String data){
		String fColour = "//a[contains(text(),'";
		String sColour = "')]/parent::*/preceding-sibling::input[1]";
		WebElement colourelement = driver.findElement(By.xpath(fColour+data+sColour));
		javaScriptHelper.scrollIntoView(colourelement);
		colourelement.click();
	}
	
	public void selectSmallSize(){
		log.info("Selecting the small suze");
		try {
			log.info("checking weather the check box is selected or not");
			boolean select = smallSizeSelection.isSelected();
			if(!select){
				smallSizeSelection.click();
				log.info("checkbox is selected");
			}
		} catch (Exception e) {
			log.info("checkbox is already selected");
			e.printStackTrace();
		}
	}
	
	public void selectFirstProduct(){
		action = new Actions(driver);
		action.moveToElement((WebElement) listOfItems.get(0)).build().perform();
		log.info("Got all the available product and cursor moved to the first displayed item");
		addTocart.click();
		log.info("Selectedthe first item and added to cart");
		waithealper.waitForelementToBeClickable(proceedToCheckout, 60);
		log.info("waiting for proceedToCheckout element to be available");
	}
	
	
	 public void clickWomenButton(){
		womenMenu.click(); 
		log.info("Clicked on the womenMenu "+womenMenu.getText());
		TestBase.logExtentReport("Clicked on the womenMenu "+womenMenu.getText());
	 }
	 
	 public void selectSortbyFilter(String dataToSelect ){
		 waithealper.waitForelementToBevisibile(cart, 60);
		 javaScriptHelper = new JavaScriptHelper(driver);
		 javaScriptHelper.scrollIntoView(sortBy);
		 
		 new DropDownHealper(driver).selectByVisibleText(sortBy, dataToSelect);
	 }
	 
	public void selectLowestPricelist(String visibletext) throws Exception{
		new DropDownHealper(driver).selectByVisibleText(sortBy, visibletext);
		Thread.sleep(8000);
	}
	
	public int getAllPrductList(){
		log.info("To tal number of items are vailable in the lis is :"+listOfItems.size());
		return listOfItems.size();	
	}
	
	public List<WebElement> allPriceList(){
		return priceList;
	}
	
	public void convertingPriceInToIntegerValue(){
		
		// we are creating one array list to store all the price values
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		// Through priceList we can get all the price values through iterator method.
		Iterator<WebElement> itr = priceList.iterator();
		
		while(itr.hasNext()){
			String p = itr.next().getText();
			if(p.contains("$")){
				
	 /* Here p.substring(1) means it will take the data from the 1st index position
		which means it will remove the $ symbol */
				String desiredData = p.substring(1);
				log.info("price after removing the $ symbol is :"+desiredData);
	/* here we are converting the data in to double after removeing the $ smbol */			
				double p1 = Double.parseDouble(desiredData);
	/* here we converting the value from double to int */
				int desiredPrice = (int)(p1);
				log.info("Price after converting in to integer value is : "+desiredPrice);
				array.add(desiredPrice);
			}
		}
	}
	
	public boolean getLowestPriceAssendingOrder(ArrayList<Integer> array){
		
		//This condition will check price should be greater than the previous one
		//next price will be always greater or equal.
		
		for(int i = 0; i<=array.size(); i++){
			
			if(array.get(i)<array.get(i+1)){
				log.info("value of the array.get(i) is : "+array.get(i));
				log.info("value of the array.get(i+1) is : "+array.get(i+1));
			}else{
				log.info("price filter is not working");
			}
			return false;
		}
		return true;
	}
}
