package com.uIFrameWork.companyName.projectNmae.hepler.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;

public class JavaScriptHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver){
		this.driver = driver;
		log.info("JavaScript helper class has been initilized");
	}
	/**
	 * This method will execute the script
	 * @param script
	 * @return
	 */
	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);

	}
	/**
	 * This method will execute the script with multiple arguments
	 * @param script
	 * @param args
	 * @return
	 */

	public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script, args);

	}
	/**
	 * This method will scroll to perticular view
	 * @param element
	 */
	public void scrollIntoView(WebElement element){
		executeScript("arguments[0].scrollIntoView(true)", element);
		log.info("Scroll to the given element :"+element.getText());
	}
	/**
	 * This methos will scroll to the perticular view and click
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element){
		scrollIntoView(element);
		element.click();
		log.info("Scroll in to the "+element.getText()+" and clicked");
	}
	/**
	 * This method will Scroll to the element
	 * @param element
	 */
	public void scrollToElement(WebElement element){
		log.info("scroll to WebElement...");
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	/**
	 * This method will Scroll to the element and click
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element){
		scrollToElement(element);
		element.click();
		log.info("Scroll in to the "+element.getText()+" and clicked");
	}
	
	/**
	 * this method will scroll down vertivally
	 */
	public void scrollDownVertically(){
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
		log.info("Scrolling down vertically till the height");
	}
	
	/**
	 * This methos will scroll up vertically
	 */
	public void scrollUpVertically(){
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		log.info("Scrolling up vertically till the height");
	}
	
	/**
	 * this method will give the scroll down till the given pixel
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel){
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	/**
	 * this method will give the scroll Up till the given pixel
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel){
		executeScript("window.scrollBY(0,-"+pixel+")");
	}
	
	
	/**
	 * This method will zoom screen by 100%
	 */
	public void zoomInBy100Percentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This method will zoom screen by 60%
	 */
	public void zoomInBy60Percentage(){
		executeScript("document.body.style.zoom='40%'");
	}
	
	/**
	 * This method will click on element
	 * @param element
	 */
	public void clickElement(WebElement element){
		executeScript("arguments[0].click();", element);
		log.info("clicked the :"+element.getText());
	}
}