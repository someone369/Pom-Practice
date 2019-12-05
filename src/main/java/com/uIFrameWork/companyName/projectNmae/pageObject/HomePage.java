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
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class HomePage extends TestBase{
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(HomePage.class);
	Waithelper waithealper;
			
	@FindBy(xpath="//*[@id='center_column']/p")
	public WebElement successMsgObject;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		log.info("Driver initiliaed in the Homepage");
		PageFactory.initElements(driver, this);
		waithealper = new Waithelper(driver);
		waithealper.waitForelementToBeClickable(successMsgObject, ObjectReader.reader.getImplicitwait());
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
		new TestBase().getNavigationScreen(driver);
	}


	
}
