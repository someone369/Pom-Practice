package com.uIFrameWork.companyName.projectNmae.pageObject;

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

import com.uIFrameWork.companyName.projectNmae.hepler.assertions.VerificationHealper;
import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.wait.Waithelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class ShopingcartSummaryPage extends TestBase{
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	Waithelper waithealper;
	Actions action;
	
	@FindBy(xpath = "//span[text()=' Summary']")
	public WebElement SummaryButton;
	
	@FindBy(xpath = "//a[@title='Delete']")
	public List<WebElement> deleteButton;
	
	@FindBy(xpath = "//p[text()='Your shopping cart is empty.']")
	public WebElement emptyShopingCart;
	
	
	public ShopingcartSummaryPage(WebDriver driver){
		this.driver = driver;
		log.info("Driver initialized in th ShopingcartSummaryPge page");
		PageFactory.initElements(driver, this);
		waithealper = new Waithelper(driver);
		waithealper.waitForelementToBeClickable(SummaryButton, ObjectReader.reader.getImplicitwait());
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
		logExtentReport("opened the Shoping cart SummaryPge");
		new TestBase().getNavigationScreen(driver);
	}
	
	public boolean verifyProduct(String prod){
		log.info("selecting product.."+prod);
		WebElement product = driver.findElement(By.xpath("//*[contains(text(),'"+prod+"')]"));
		return new VerificationHealper(driver).isDisplayed(product);
	}
	
	public void deleteProductsFromCart() throws Exception{
		log.info("deleting all the items from the cart");
		Iterator<WebElement> itrD = deleteButton.iterator();
		while(itrD.hasNext()){
			WebElement item = itrD.next();
			item.click();
			Thread.sleep(2000);
			log.info("item deleted");
		}
		
	}
	public boolean verifyShopingCartIsEmpty(){
		return new VerificationHealper(driver).isDisplayed(emptyShopingCart);
	}
}
