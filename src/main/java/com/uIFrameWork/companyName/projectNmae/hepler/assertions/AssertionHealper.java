package com.uIFrameWork.companyName.projectNmae.hepler.assertions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class AssertionHealper {
	
	private static Logger log = LoggerHelper.getLogger(AssertionHealper.class);
		
	public static void veryfyText(String s1, String s2){
		log.info("verifying text..:"+s1+" with "+s2);
		Assert.assertEquals(s1, s2);	
		
	}
	
	public static void makePass(){
		log.info("Making script PASS.........");
		Assert.assertTrue(true);
	}
	
	public static void makePass(String message){
		log.info("Making script PASS.........with :"+message);
		Assert.assertTrue(true, message);
	}
	
	public static void makeFail(){
		log.info("Making script Fail.........");
		Assert.assertTrue(false);
	}
	
	public static void makeFail(String message){
		log.info("Making script FAil.........with :"+message);
		Assert.assertTrue(false, message);
	}
	
	public static void verifyTrue(boolean status){
		Assert.assertTrue(status);
		
	}
	
	public static void verifyFalse(boolean status){
		Assert.assertFalse(status);
		
	}
	
	public static void verifyNull(String s1){
		log.info("verifying object is null");
		Assert.assertNull(s1);
	}
	
	public static void verifyNotNull(String s1){
		log.info("verifying object is not null");
		Assert.assertNotNull(s1);
	}
	
	public static void pass(){
		Assert.assertTrue(true);
	}
	
	public static void fail(){
		Assert.assertTrue(false);
	}
	
	public static void updataTestStatus(boolean status){
		if(status){
			pass();
			log.info("Status updated as pass");
			TestBase.logExtentReport("Status updated as pass");
		}else{
			fail();
			log.info("status updates as fail");
			TestBase.logExtentReport("Status updated as fail");
		}
	}
}
