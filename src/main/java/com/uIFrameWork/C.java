package com.uIFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class C extends TestBase{
	int i = 1;
		@Test
		public void testLoginC(){
			if(i==3){
				Assert.assertTrue(true);
			}else{
			System.out.println(i);
			i++;
			Assert.assertTrue(false);
			}
		}
}
