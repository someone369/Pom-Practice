package com.uIFrameWork.companyName.projectNmae.hepler.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.uIFrameWork.companyName.projectNmae.hepler.resource.ResourecHelper;

public class LoggerHelper {
	
		private static boolean root=false;
		
		public static Logger getLogger(Class cls){
			if(root){
				return Logger.getLogger(cls);
			}
			PropertyConfigurator.configure(ResourecHelper.getResourcePath("//resources//configfile//Log4j.properties"));
			System.out.println(ResourecHelper.getResourcePath("//resources//configfile//Log4j.properties"));
			root = true;
			return Logger.getLogger(cls);
		}
		
		public static void main(String[] args) {
			
			Logger log = LoggerHelper.getLogger(LoggerHelper.class);
			log.info("Logger is configured");
			log.info("Logger is configured");
			log.info("Logger is configured");
		}
}
