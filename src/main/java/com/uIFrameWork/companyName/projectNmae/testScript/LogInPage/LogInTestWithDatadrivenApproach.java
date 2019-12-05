package com.uIFrameWork.companyName.projectNmae.testScript.LogInPage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uIFrameWork.companyName.projectNmae.hepler.assertions.AssertionHealper;
import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.pageObject.Loginpage;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class LogInTestWithDatadrivenApproach extends TestBase{
	private final Logger log = new LoggerHelper().getLogger(LogInTestWithDatadrivenApproach.class);
	Loginpage loginpage;
	
	@DataProvider(name = "testData")
	public Object[][] testData(){
		Object[][] data = getExcelData("TestData21.xlsx", "Logindata");
		return data;		
	}
	@BeforeClass
	public void beforeClass(){
		getApplicationURL(ObjectReader.reader.getUrl());
		loginpage = new Loginpage(driver);
	}
	@Test(dataProvider = "testData")
	public void logInTestWithDatadriven(String Username, String PassWord, String runMode){
		if(runMode.equalsIgnoreCase("N")){
			throw new SkipException("Run mode for this set of data is marked as N");
		}
		loginpage.logInToApplication(Username, PassWord);
		
		boolean status = loginpage.verifySuccessLoginPage();
		AssertionHealper.updataTestStatus(status);
		
		loginpage.logoutLoginPage();
	}
}
