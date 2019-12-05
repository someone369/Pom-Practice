package com.uIFrameWork.companyName.projectNmae.hepler.Frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;

public class FrameHelper{
	
	private WebDriver driver;
	private Logger log =LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver){
		this.driver=driver;	
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param frameindex
	 */
	public void switchToFrameBasedOnINdex(int frameindex){
		driver.switchTo().frame(frameindex);
		log.info("Sitched to frame based on the index number that is :"+frameindex);
	}
	
	
	/**
	 * This method will switch to frame based on name
	 * @param frameindex
	 */
	public void switchToFrameBasedOnName(int framename){
		driver.switchTo().frame(framename);
		log.info("Sitched to frame based on the index number that is :"+framename);
	}
	
	/**
	 * This method will switch to frame based on webelement
	 * @param frameindex
	 */
	public void switchToFrameBasedOnWebelement(WebElement elemet){
		driver.switchTo().frame(elemet);
		log.info("Sitched to frame based on the index number that is :"+elemet);
	}

}
