package com.uIFrameWork.companyName.projectNmae.pageObject;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.wait.Waithelper;
import com.uIFrameWork.companyName.projectNmae.hepler.window.WindowHelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

/**
 * 
 * @author Lakshmi
 *
 */

public class MyAccountPage {
	
		private WebDriver driver;
		private Logger log = LoggerHelper.getLogger(MyAccountPage.class);
		Waithelper waithealper;
		
		@FindBy(xpath = "//i[@class='icon-ok']")
		public WebElement successfulRegistrationmsg;
		
		@FindBy(xpath = "//h1[text()='My account']")
		public WebElement myAccountText;
		
		@FindBy(xpath = "//span[text()='My wishlists']")
		public WebElement myWishlist;
		
		@FindBy(xpath = "//span[text()='Order history and details']")
		public WebElement OrderHistoryAndDetails;
		
		
		@FindBy(xpath = "//span[text()='My credit slips']")
		public WebElement myCreditSlips;
		
		
		@FindBy(xpath = "//span[text()='My addresses']")
		public WebElement myaddresses;
		
		@FindBy(xpath = "//span[text()='My personal information']")
		public WebElement mypersonalinformation;
		
		
		public MyAccountPage(WebDriver driver){
			this.driver = driver;
			log.info("driver initilized in the MyAccountPage");
			PageFactory.initElements(driver, this);
			waithealper = new Waithelper(driver);
			waithealper.waitForelementToBeClickable(OrderHistoryAndDetails, ObjectReader.reader.getImplicitwait());
			waithealper.pageLoadTime(60, TimeUnit.SECONDS);
			new TestBase().getNavigationScreen(driver);
		}
		
		public void getTextfromMyAccountPage(){
			String successText = successfulRegistrationmsg.getText();
			System.out.println("Successfully load the my account page :"+successText);
			
			
			String myAccountText = this.myAccountText.getText();
			System.out.println("Confirmation text message fom my acount page is :"+myAccountText);
			
		}
		public void waitback(String logReportMesg,WebElement elemnt){
			waithealper.pageLoadTime(60, TimeUnit.SECONDS);
			new WindowHelper(driver).navigateToBack();
			waithealper.waitForelementToBeClickable(elemnt, ObjectReader.reader.getImplicitwait());
			TestBase.logExtentReport(logReportMesg);
		}
		public void Wishlist(){
			myWishlist.click();
			log.info("clicked on my wishlist");
			waitback("clicked on my wishlist", OrderHistoryAndDetails);
				
		}
		public void orderHistoryAndDetails(){
			OrderHistoryAndDetails.click();
			log.info("clicked on my OrderHistoryAndDetails");
			waitback("clicked on my OrderHistoryAndDetails", myCreditSlips);	
		}
		
		public void CreditSlips(){
			myCreditSlips.click();
			log.info("clicked on my CreditSlipsCreditSlips");
			waitback("clicked on my CreditSlipsCreditSlips", myaddresses);
		}
		
		public void addresses(){
			myaddresses.click();
			log.info("clicked on my myaddresses");
			waitback("clicked on my myaddresses", mypersonalinformation);
		}
		
		public void personalinformation(){
			mypersonalinformation.click();
			log.info("clicked on my mypersonalinformation");
			waitback("clicked on my mypersonalinformation", myWishlist);
		}
		
		public void myAccountPageInApplication(){
			getTextfromMyAccountPage();
			Wishlist();
			orderHistoryAndDetails();
			CreditSlips();
			addresses();
			personalinformation();
			
		}
}
