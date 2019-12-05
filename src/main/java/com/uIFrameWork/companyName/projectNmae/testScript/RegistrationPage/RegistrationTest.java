package com.uIFrameWork.companyName.projectNmae.testScript.RegistrationPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uIFrameWork.companyName.projectNmae.hepler.assertions.AssertionHealper;
import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.pageObject.Loginpage;
import com.uIFrameWork.companyName.projectNmae.pageObject.RegistrationPage;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class RegistrationTest extends TestBase{
	
	private final Logger log = LoggerHelper.getLogger(RegistrationTest.class);
	Loginpage loginpage;
	RegistrationPage registrationPage;
	
	@Test(description = "Regestring the new emailAddress in to the application")
	public void testRegistrationTest(){
			// Going to the application
		getApplicationURL(ObjectReader.reader.getUrl());
		
		loginpage = new Loginpage(driver);
		loginpage.clickOnSignLink();
		
		loginpage.toRegisterEmailId();
		loginpage.clickOnCreateAnAccount();
		
			// Registring with the details
		registrationPage = new RegistrationPage(driver);
		registrationPage.selectMrRadioButton();
		registrationPage.enteringNames(ObjectReader.reader.getFirstName(), ObjectReader.reader.getLastName());
		registrationPage.enteringPassword();
		registrationPage.selectday("3");
		registrationPage.selectMonth("December");
		registrationPage.selectYear("1986");
		registrationPage.enteringAddress("#8 sri sai lakshmi balaji PG jai bheem nagar");
		registrationPage.enteringCity("California");
		registrationPage.selectState("California");
		registrationPage.enteringPostelCode("94014");
		registrationPage.enteringPhonNumber(ObjectReader.reader.getphonNumber());
		registrationPage.clickOnButton();
		
			// verifiying the registration is successfull
		boolean status = registrationPage.verifysuccessRegistrationPage();
		AssertionHealper.updataTestStatus(status);
	}
}
