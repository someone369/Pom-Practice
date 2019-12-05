package com.uIFrameWork.companyName.projectNmae.hepler.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;


public class WindowHelper {
	
	private WebDriver driver;
	private Logger log =LoggerHelper.getLogger(WindowHelper.class);
	
	public WindowHelper(WebDriver driver){
		this.driver = driver;	
	}
	
	/**
	 * This method will switch to parent window
	 */
	public void switToparentWindow(){
		log.info("Switching to the parent window ");
		driver.switchTo().defaultContent();
		
	}
	
	/**
	 * This method will help to switch to the window based on the index position
	 * @param indexnumber
	 */
	public void switToWindowBasedOnIndex(int indexnumber){
		Set<String> windows = driver.getWindowHandles();
		int i =1 ;
		for(String window : windows){
			if(i== indexnumber){
				log.info("Switched to :"+indexnumber+" window");
				driver.switchTo().window(window);				
			}
			else{
				i++;
			}
			
		}
		
	}
	
	
	/**
	 * This method will close the all opened windows and switch to the parent window
	 */
	public void closeAllTabsSwitchToMainWindow(){
		Set<String> windows = driver.getWindowHandles();
		String mainwindows = driver.getWindowHandle();
		
		for(String window : windows){
			if(!window.equalsIgnoreCase(mainwindows)){
				driver.close();				
			}
		}
		driver.switchTo().window(mainwindows);	
		log.info("Switched tomain window");
	}
	/**
	 * THis method will do browser back navigation 
	 */
	public void navigateToBack(){
		driver.navigate().back();
		log.info("Navigated to back window");
	}
	
	/**
	 * This method will do browser forward navigation
	 */
	public void navigateToForward(){
		driver.navigate().forward();
		log.info("Navigated to forward window");
	}
	
}
