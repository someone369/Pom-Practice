package com.uIFrameWork.companyName.projectNmae.pageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.wait.Waithelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

/**
 * 
 * @author Lakshmi
 *
 */
public class NavigationsMenu extends TestBase{
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	Waithelper waithealper;
	
	
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
	
	
	public NavigationsMenu(WebDriver driver){
		this.driver = driver;
		log.info("Driver initialized in th NavigationsMenu page");
		PageFactory.initElements(driver, this);
		waithealper = new Waithelper(driver);
		waithealper.waitForelementToBeClickable(womenMenu, ObjectReader.reader.getImplicitwait());
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
		new TestBase().getNavigationScreen(driver);
	}
	
	public void mouseOver(WebElement target){
		log.info("Doing mouse over on data :"+target);
		Actions action = new Actions(driver);
		action.moveToElement(target).build().perform();		
	}
	
	public ProductCategorypage clickOnItem(WebElement target,WebElement element){
		mouseOver(target);
		log.info("Selecting the product after mouse over to the menu :");
		element.click();
		new TestBase().logExtentReport("clicked on the product and opening "+element+" page");
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
		return new ProductCategorypage(driver);		
	}
	
	public ProductCategorypage tshirtProduct(){
		tShirtsMenu.click();
		log.info("Clicked on T_sirt menu and entering in to the ProductCategorypage");
		return new ProductCategorypage(driver);
	}
	public void tShirtscategorySection(){
		clickOnItem(womenMenu, tShirtscategory);
	}
	
	public void blousescategorySection(){
		clickOnItem(womenMenu, blousescategory);
	}
	
	public void casualDressescategorySection(){
		clickOnItem(dressesMenu, casualDressescategory);
	}
	
	public void eveningDressescategorySection(){
		clickOnItem(dressesMenu, eveningDressescategory);
	}
	
	public void summerDressescategorySection(){
		clickOnItem(dressesMenu, summerDressescategory);
	}
	
	public void navigationsMenu(){
		
		tshirtProduct();
		tShirtscategorySection();
		blousescategorySection();
		casualDressescategorySection();
		eveningDressescategorySection();
		summerDressescategorySection();	
	}
}
