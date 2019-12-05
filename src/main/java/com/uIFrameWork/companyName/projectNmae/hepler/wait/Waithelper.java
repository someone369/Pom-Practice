package com.uIFrameWork.companyName.projectNmae.hepler.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;

public class Waithelper {
		private WebDriver driver;
		private Logger log =LoggerHelper.getLogger(Waithelper.class);
		
	public Waithelper(WebDriver driver){
		this.driver = driver;
		log.info("waithelper object created");
	}
		
	/**
	 * This is implicit wait
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit){
		log.info("Implicit wait has been set to :"+timeout+" "+"Seconds");
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		driver.manage().window().maximize();
	}
	
	public void pageLoadTime(long timeout, TimeUnit unit){
		log.info("Waiting for page to load for "+timeout+" Sec");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded");
		
	}
	/**
	 * This will help us to get webdriver object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);	
		return wait;		
	}
	
	/**
	 * This method will make sure element to be visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void waitForElementVisibleWithpollingTime(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
		String elementName = element.getText();
		log.info("waiting for :"+elementName+" for :" +timeOutInSeconds+" seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(elementName+" is visible now");	
	}
	
	/**
	 * This method will make sure element to be Clickable
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void waitForelementToBeClickable(WebElement element, long  timeOutInSeconds){
		String elementName = element.getText();
		log.info("waiting for :"+element.getText()+"to be clickable for :"+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info(elementName+" is clickable now");	
	}
	
	public void waitForelementToBevisibile(WebElement element, long  timeOutInSeconds){
		String elementName = element.getText();
		log.info("waiting for :"+element.getText()+"to be visible for :"+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(elementName+" is visible now");	
	}
	
	/**
	 * This method will make sure element to be invisibleString elementName = "element";
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	
	public void waitForElementNotPresent(WebElement element, long  timeOutInSeconds){
		String elementName = element.getText();
		log.info("waiting for :"+element.getText()+"to be invisible for :"+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
		log.info(elementName+" is invisible now");
	}
	
	/**
	 * This method will make sure frame to be available and switch to it
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long  timeOutInSeconds){
		String elementName = element.getText();
		log.info("waiting for :"+element.getText()+"to be available for :"+timeOutInSeconds+" seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info(elementName+" Frame is available and switched to the frame");
	}
	/**
	 * This method will give is fluentWait object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	
	/*private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}
	*/
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	/*public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}*/
	
	
	
	
}
