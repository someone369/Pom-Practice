package com.uIFrameWork.companyName.projectNmae.hepler.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;

public class DropDownHealper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropDownHealper.class);
	
	public DropDownHealper(WebDriver driver){
		this.driver = driver;
		log.info("Drop down object is initilized");
	}
	 public void selectUsingValue(WebElement element,String value){
		 Select select = new Select(element);
		 select.selectByValue(value);
		 log.info("Drop down is selected with the given value :"+value);
	 }
	 
	 public void selectByIndex(WebElement element,int index){
		 Select select = new Select(element);
		 select.selectByIndex(index);
		 log.info("Drop down is selected with the index position :"+index);
	 }
	 
	 public void selectByVisibleText(WebElement element,String visibletext){
		 Select select = new Select(element);
		 select.selectByVisibleText(visibletext);
		 log.info("Drop down is selected with the visibletext value :"+visibletext);
	 }
	 
	 public void deselectUsingValue(WebElement element,String value){
		 Select select = new Select(element);
		 select.selectByValue(value);
		 log.info("Drop down is deselected with the given value :"+value);
	 }
	 
	 public void deselectByIndex(WebElement element,int index){
		 Select select = new Select(element);
		 select.selectByIndex(index);
		 log.info("Drop down is deselected with the index position :"+index);
	 }
	 
	 public void deselectByVisibleText(WebElement element,String visibletext){
		 Select select = new Select(element);
		 select.selectByVisibleText(visibletext);
		 log.info("Drop down is deselected with the visibletext value :"+visibletext);
	 }
	  public  List<String> getAllDropDowndata(WebElement element){
		  Select select =new Select(element);
		  List<WebElement> dropdownlist = select.getOptions();
		  List<String> valuelist = new LinkedList<String>();
		  
		  for(WebElement we : dropdownlist){
			  log.info(we.getText());
			  valuelist.add(we.getText());	  
		  }
		  return valuelist;
	  }
}
