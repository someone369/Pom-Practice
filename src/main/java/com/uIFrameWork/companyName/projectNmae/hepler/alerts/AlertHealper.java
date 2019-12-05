package com.uIFrameWork.companyName.projectNmae.hepler.alerts;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;

public class AlertHealper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHealper.class);
	
	public AlertHealper(WebDriver driver){
		this.driver = driver;
		log.info("alert healper object is created");
	}
	
	public String getAlertText(){
		String text = driver.switchTo().alert().getText();
		log.info("Text present in the alert is :"+text);
		return text;	
	}
	
	public void acceptAlert(){
		driver.switchTo().alert().accept();
		log.info("Accept alert is done.....");
	}
	
	public void dismissAlert(){
		driver.switchTo().alert().dismiss();
		log.info("Accept got dismissed.....");
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}catch(NoAlertPresentException e){
			log.info(e.getCause());
			return false;
		}
	}
	
	public void acceptAlertIfPresent(){
		if(isAlertPresent()){
			acceptAlert();
		}else{
			log.info("Alert is not present");
		}
	}
	
	public void dismissAlertIfPresent(){
		if(isAlertPresent()){
			dismissAlert();
		}else{
			log.info("Alert is not present");
		}
	}
	
	public Alert getAlert(){
		log.info("alert test: "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptPromt(String text){
		if(isAlertPresent()){
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Filled the text column with the :"+text+" and accepted the text");
		}
	}
}
