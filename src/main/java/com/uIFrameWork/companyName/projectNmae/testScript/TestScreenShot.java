package com.uIFrameWork.companyName.projectNmae.testScript;

import org.testng.annotations.Test;

import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;


public class TestScreenShot extends TestBase{
	
	@Test
	public void testScreen(){
		driver.get("https://www.javatpoint.com/array-in-java");
		captureScreen("FirstScreenshoot", driver);
	}

}
