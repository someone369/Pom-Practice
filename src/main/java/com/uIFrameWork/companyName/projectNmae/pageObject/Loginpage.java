package com.uIFrameWork.companyName.projectNmae.pageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uIFrameWork.companyName.projectNmae.hepler.assertions.VerificationHealper;
import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.javaScript.JavaScriptHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.wait.Waithelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;
/**
 * 
 * @author Lakshmi Narasimham
 *
 */

public class Loginpage  {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(Loginpage.class);
	Waithelper waithealper;
	JavaScriptHelper javaScriptHelper;
	
	
	
	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	public WebElement signin;
	
	@FindBy(xpath = "//h3[text()='Already registered?']")
	public WebElement alreadyRegisteredText;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailAddress;
	
	@FindBy(xpath = "//input[@id='passwd']")
	public WebElement password;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	public WebElement submitSignIn;
	
	@FindBy(xpath = "//input[@id='email_create']")
	public WebElement registrationEmailId;
	
	@FindBy(xpath = "//button[@name='SubmitCreate']")
	public WebElement createAnAccountButton;
	
	@FindBy(xpath="//*[@id='center_column']/p")
	public WebElement successMsgObject;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	public WebElement search;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement searchbutton;
	
	@FindBy(xpath = "//span[text()='Register']")
	public WebElement registerButton;
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	public WebElement logout;
	
	public Loginpage(WebDriver driver){
		this.driver = driver;
		log.info("loginPage");
		PageFactory.initElements(driver, this);
		waithealper = new Waithelper(driver);
		waithealper.waitForelementToBeClickable(signin, ObjectReader.reader.getImplicitwait());
		waithealper.pageLoadTime(60, TimeUnit.SECONDS);
		new TestBase().getNavigationScreen(driver);
	}
	
	public void clickOnSignLink(){
		signin.click();
		log.info("Clicked on Signin link");
		TestBase.logExtentReport("Clicked on Signin link");
		waithealper.waitForelementToBeClickable(submitSignIn, 60);
	}
	
	public void getTextForalreadyRegistered(){
		 String text = alreadyRegisteredText.getText().toString();
		 System.out.println(text);
	}
	public void enterEmailAddress(String emailaddress){
		this.emailAddress.sendKeys(emailaddress);
		log.info("entered the email address in th textbox is :"+emailaddress);
		TestBase.logExtentReport("entered the email address in th textbox is :"+emailaddress);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
		log.info("Entered the password in the password text box :"+password);
		TestBase.logExtentReport("Entered the password in the password text box :"+password);
	}
	
	public HomePage clickOnSubmitButton(){
		new JavaScriptHelper(driver).scrollIntoView(submitSignIn);
		submitSignIn.click();
		log.info("entering to the homepage");
		TestBase.logExtentReport("entering to the homepage");
		return new HomePage(driver);
	}
	public boolean verifySuccessLoginPage(){
		waithealper.waitForelementToBevisibile(successMsgObject, 60);
		return new VerificationHealper(driver).isDisplayed(successMsgObject);
		
	}
	public void toRegisterEmailId(){
		String NewRegisterEmailId = System.currentTimeMillis()+"@gmail.com";
		registrationEmailId.sendKeys(NewRegisterEmailId);
		log.info("NewRegisterEmailId entered in to the textbox is : "+NewRegisterEmailId);
	}
	 public RegistrationPage clickOnCreateAnAccount(){
		 createAnAccountButton.click();
		 log.info("Clicked to createAnAccountButton");
		 TestBase.logExtentReport("Clicked to createAnAccountButton");
		 javaScriptHelper = new JavaScriptHelper(driver);
		 javaScriptHelper.scrollIntoView(registerButton);
		 waithealper.waitForelementToBevisibile(registerButton, 60);
		 log.info("Successfully enteredtothe registration page ");
		 TestBase.logExtentReport("Successfully entered to the registration page ");
		 return new RegistrationPage(driver);
	 }
	 
	 public void logInToApplication(String Username, String PassWord){
		 clickOnSignLink();
		 getTextForalreadyRegistered();
		 enterEmailAddress(Username);
		 enterPassword(PassWord); 
		 clickOnSubmitButton();
		 verifySuccessLoginPage();
	 }
	 public void logoutLoginPage(){
		 logout.click();
		 log.info("clicked on the soignout button");
		 TestBase.logExtentReport("clicked on the soignout button");
		 waithealper.waitForelementToBeClickable(signin, 60);
	 }
	 
	 public boolean logoutVerify(){
		 waithealper.waitForelementToBevisibile(successMsgObject, 60);
		return new VerificationHealper(driver).isDisplayed(signin); 
	 }
	 /*public void logExtentReport(String s){
		 TestBase.test.log(Status.INFO, s);
	 }*/
	

}
