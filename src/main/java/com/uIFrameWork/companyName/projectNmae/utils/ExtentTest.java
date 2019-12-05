package com.uIFrameWork.companyName.projectNmae.utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.testScript.Test1;

public class ExtentTest extends Test1{
	
	private Logger log = LoggerHelper.getLogger(ExtentTest.class);
	
	@Test
	public void loginExtentReports() throws Exception{
		ExtentHtmlReporter htmlreports = new ExtentHtmlReporter("EctentReports/extent1.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlreports);
		com.aventstack.extentreports.ExtentTest test = reports.createTest("ExtentTest", "Thi is my first extent reports test");
		test.log(Status.INFO, "Login hapening");
		test.log(Status.PASS, "Login Successfull");
		test.addScreenCaptureFromPath("/resources/screenShots");
		reports.flush();
	}
}
