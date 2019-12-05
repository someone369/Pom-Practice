package com.uIFrameWork.companyName.projectNmae.testScript.LogInPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.uIFrameWork.companyName.projectNmae.hepler.assertions.AssertionHealper;
import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.pageObject.Loginpage;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

/**
 * 
 * @author mlnar
 *
 */
public class LoginTest extends TestBase{
	
		private Logger log = new LoggerHelper().getLogger(LoginTest.class);
		
		@Test(description = "Login test with valid credentials")
		public void testLoginToApplication(){
			getApplicationURL(ObjectReader.reader.getUrl());
			Loginpage loginpage = new Loginpage(driver);
			loginpage.logInToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassWord());
			boolean status = loginpage.verifySuccessLoginPage();
			AssertionHealper.updataTestStatus(status);

		}	
}
