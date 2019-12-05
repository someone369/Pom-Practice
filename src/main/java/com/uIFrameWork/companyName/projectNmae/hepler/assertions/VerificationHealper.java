package com.uIFrameWork.companyName.projectNmae.hepler.assertions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class VerificationHealper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHealper.class);
	
	public VerificationHealper(WebDriver driver){
		this.driver = driver;
	}
	 /**
	  * This method will display status the element if it is present
	  * @param element
	  * @return
	  */
	public boolean isDisplayed(WebElement element){
		try{
			element.isDisplayed();
			log.info("element is Displayed..... :"+element.getText());
			TestBase.logExtentReport("element is Displayed..... :"+element.getText());
			return true;
		}catch(Exception e){
			log.info("element is not Displayed...... :"+e.getCause());
			TestBase.logExtentReport("element isnot Displayed...... :"+e.getMessage());
			return false;
		}
		
	}
	
	/**
	  * This method will display status the element if it not is present
	  * @param element
	  * @return
	  */
	public boolean isNotDisplayed(WebElement element){
		try{
			element.isDisplayed();
			log.info("element is Displayed.... :"+element.getText());
			TestBase.logExtentReport("element is Displayed.... :"+element.getText());
			return false;
		}catch(Exception e){
			log.info("element is not Displayed..... :");
			return true;
		}
		
	}
	
	/**
	 * This method will get the text of the element
	 * @param element
	 * @return
	 */
	public String getTextFromElement(WebElement element){
		if(element == null){
			log.info("webelement is null.....");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			log.info("element is Displayed and its text is :" +element.getText());
			return element.getText();
		}else{
			return null;
		}
		
	}
	
	public String getTitle(){
		String title = driver.getTitle();
		log.info("Title of the page is.....:"+title);
		return title;
		
	}
}
