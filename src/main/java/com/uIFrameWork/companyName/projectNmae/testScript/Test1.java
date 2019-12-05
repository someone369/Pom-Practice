package com.uIFrameWork.companyName.projectNmae.testScript;

import org.testng.annotations.Test;

import com.uIFrameWork.companyName.projectNmae.hepler.assertions.AssertionHealper;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class Test1 extends TestBase {

	
		@Test
		public void testLogin(){
			AssertionHealper.makePass();
		}
		
		@Test
		public void testLogin1(){
			AssertionHealper.makeFail();
		}

		@Test
		public void testLogin2(){
			AssertionHealper.makePass();
		}
		
		@Test
		public void testLogin3(){
			AssertionHealper.makeFail();
		}
}
