package com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.BrowserType;
import com.uIFrameWork.companyName.projectNmae.hepler.resource.ResourecHelper;

public class PropertyReader implements ConfigReader {
	private static FileInputStream file;
	private static Properties prop;

	public PropertyReader() {

		try {
			String filepath = ResourecHelper.getResourcePath("/resources/configfile/config.properties");
			file = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImplicitwait() {
		return Integer.parseInt(prop.getProperty("implicitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(prop.getProperty("pageloadTime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(	prop.getProperty("browserType"));
	}

	public String getUrl() {
		if(System.getProperty("url") !=null){
			return System.getProperty("url");
		}
		return prop.getProperty("applicationURL");
	}

	public String getUserName() {
		if(System.getProperty("UserName") !=null){
			return System.getProperty("UserName");
		}
		return prop.getProperty("UserName");
	}

	public String getPassWord() {
		if(System.getProperty("PassWord") !=null){
			return System.getProperty("PassWord");
		}
		return prop.getProperty("PassWord");
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return prop.getProperty("firstname");
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return prop.getProperty("lastname");
	}

	public String getphonNumber() {
		// TODO Auto-generated method stub
		return prop.getProperty("phonNumber");
	}

}
