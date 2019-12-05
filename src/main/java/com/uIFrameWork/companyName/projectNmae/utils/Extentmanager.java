package com.uIFrameWork.companyName.projectNmae.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentmanager {
	
	private static ExtentReports extent;
	
		public static ExtentReports getInstance(){
			if(extent == null){
				return createInstance("EctentReports/extent.html");
			}else{
				return extent;
			}
			
		}
		
		public static ExtentReports createInstance(String filename){
			
			ExtentHtmlReporter htmlreporter =new ExtentHtmlReporter(filename);
			htmlreporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			htmlreporter.config().setChartVisibilityOnOpen(true);
			htmlreporter.config().setTheme(Theme.STANDARD);
			htmlreporter.config().setDocumentTitle(filename);
			htmlreporter.config().setEncoding("utf-8");
			htmlreporter.config().setReportName("Automation Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlreporter);
			return extent;
			
		}
}
