package com.uIFrameWork.companyName.projectNmae.hepler.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;

public class Retry implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private int maxRetryCoaunt = 3;
	
	private Logger log = LoggerHelper.getLogger(Retry.class);

	public boolean retry(ITestResult arg0) {
		if(retryCount < maxRetryCoaunt){
			log.info("Retrying test "+arg0.getName()+" with status "+getResultStatusName(arg0.getStatus())+" for the "+(retryCount+1)+" times");
			retryCount++;
			return true;
		}
		return false;
	}
	public String getResultStatusName(int status){
		String resultName = null;
		if(status == 1){
			resultName = "SUCCESS";
		}
		if(status == 2){
			resultName = "FAILURE";
		}
		if(status == 3){
			resultName = "SKIP";
		}
		return resultName;
		
	}
}
