package com.uIFrameWork.companyName.projectNmae.pageObject;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uIFrameWork.companyName.projectNmae.hepler.assertions.VerificationHealper;
import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.javaScript.JavaScriptHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.wait.Waithelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class RegistrationPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(RegistrationPage.class);
	Waithelper waithealper;
	JavaScriptHelper javaScriptHelper;
	
	@FindBy(xpath = "//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	public WebElement successfulRegistrationmsg;
	
	@FindBy(xpath = "//input[@id='email_create']")
	public WebElement registrationEmailId;
	
	@FindBy(xpath = "//button[@name='SubmitCreate']")
	public WebElement createAnAccountButton;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	public WebElement mrRadioButton;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
	public WebElement enterfirstName;
	
	@FindBy(xpath = "//input[@id='customer_lastname']")
	public WebElement enterLastName;
	
	@FindBy(xpath = "//input[@id='passwd']")
	public WebElement enterPassword;
	
	@FindBy(xpath = "//*[@id='days']/option")
	public List<WebElement> daysList;
	
	@FindBy(xpath = "//*[@id='months']/option")
	public List<WebElement> mothsList;
	
	@FindBy(xpath = "//*[@id='years']/option")
	public List<WebElement> yearsList;	
	
	@FindBy(xpath = "//select[@id='id_state']/option")
	public List<WebElement> stateList;
	
	@FindBy(xpath = "//input[@id='address1']")
	public WebElement enterAddress1;
	
	@FindBy(xpath = "//*[@id='phone']")
	public WebElement enterMobileNumber;
	
	@FindBy(xpath = "//input[@id='city']")
	public WebElement enterCityNmae;
	
	@FindBy(xpath = "//input[@id='postcode']")
	public WebElement enterpostlcode;
	
	@FindBy(xpath = "//span[text()='Register']")
	public WebElement registerButton;
	
	public RegistrationPage(WebDriver driver){
		this.driver = driver;
		log.info("Driver initiliaed in the RegistrationPage");
		PageFactory.initElements(driver, this);
		waithealper = new Waithelper(driver);
		waithealper.waitForelementToBeClickable(registerButton, ObjectReader.reader.getImplicitwait());
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
		TestBase.logExtentReport("Registration Page object is created" );
		new TestBase().getNavigationScreen(driver);
		
	}
	
	public void createAnAccount(String newEmail){
		registrationEmailId.sendKeys(newEmail);
		log.info("Entering new emailId in to th text box");
		createAnAccountButton.clear();
		log.info("Clicked the create an account");
		waithealper.waitForelementToBevisibile(successfulRegistrationmsg, 60);
		log.info("Element is visible :"+successfulRegistrationmsg.toString());
	}
	
	public void selectMrRadioButton(){
		javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(mrRadioButton);
		mrRadioButton.click();
		log.info("Selected the Mr radio button");
		TestBase.logExtentReport("Selected the Mr radio button");
	}
	
	public void enteringNames(String FirstName, String lastNmae){
		enterfirstName.sendKeys(FirstName);
		log.info("entered the first name"+ FirstName);
		TestBase.logExtentReport("entered the first name");
		enterLastName.sendKeys(lastNmae);
		log.info("entered the Last name");
		TestBase.logExtentReport("entered the last name"+lastNmae);
	}
	
	public void enteringPassword(){
		String password = System.currentTimeMillis()+"new";
		enterPassword.sendKeys(password);
		log.info("entered the password : "+password);
		TestBase.logExtentReport("entered the password : "+password);
	}
	
	public void selectday(String day){
		Iterator<WebElement> itrD = daysList.iterator();
		while(itrD.hasNext()){
			WebElement d = itrD.next();
			String textDay = d.getText().trim().toString();
			if(textDay.equalsIgnoreCase(day)){
				log.info("selecting day is :"+day);
				d.click();
				break;
			}
		}
	}
	
	public void selectMonth(String month){
		Iterator<WebElement> itrM = mothsList.iterator();
		while(itrM.hasNext()){
			WebElement m = itrM.next();
			String textMonth = m.getText().trim().toString();
			if(textMonth.equalsIgnoreCase(month)){
				log.info("selecting month is :"+month);
				m.click();
				break;
			}
		}
	}
	
	public void selectYear(String year){
		Iterator<WebElement> itrY = yearsList.iterator();
		while(itrY.hasNext()){
			WebElement y = itrY.next();
			String textYear = y.getText().trim().toString();
			if(textYear.equalsIgnoreCase(year)){
				log.info("selecting year is :"+year);
				y.click();
				break;
			}
		}
	}
	
	public void selectState(String state){
		Iterator<WebElement> itrS = stateList.iterator();
		while(itrS.hasNext()){
			WebElement stateS = itrS.next();
			String textState = stateS.getText().trim().toString();
			if(textState.equalsIgnoreCase(state)){
				stateS.click();
				log.info("Selected the given state "+state);
				TestBase.logExtentReport("Selected the given state "+state);
				break;
			}
		}
	}
	
	public void enteringAddress(String address){
		enterAddress1.sendKeys(address);
		log.info("entered the address"+address.toString());
		TestBase.logExtentReport("entered the address"+address.toString());	
	}
	
	public void enteringPostelCode(String postalcode){
		enterpostlcode.sendKeys(postalcode);
		log.info("entered the postalcode "+postalcode.toString());
		TestBase.logExtentReport("entered the postalcode "+postalcode.toString());
	}
	
	public void enteringCity(String city){
		enterCityNmae.sendKeys(city);
		log.info("entered the city name "+city.toString());
		TestBase.logExtentReport("entered the city name"+city.toString());
	}
	public void enteringPhonNumber(String phonNumber){
		enterMobileNumber.sendKeys(phonNumber);
		log.info("entered the phonNumber"+phonNumber.toString());
		TestBase.logExtentReport("entered the phonNumber"+phonNumber.toString());
	}
	
	public MyAccountPage clickOnButton(){
		registerButton.click();
		log.info("clicked on registerButton");
		TestBase.logExtentReport("clicked on registerButton");
		waithealper.waitForelementToBevisibile(successfulRegistrationmsg, 60);
		log.info("Successfully completed registration");
		TestBase.logExtentReport("Successfully completed registration");
		return new MyAccountPage(driver);
	}
	public boolean verifysuccessRegistrationPage(){
		waithealper.waitForelementToBevisibile(successfulRegistrationmsg, 60);
		return new VerificationHealper(driver).isDisplayed(successfulRegistrationmsg);
	}
	
	
}
