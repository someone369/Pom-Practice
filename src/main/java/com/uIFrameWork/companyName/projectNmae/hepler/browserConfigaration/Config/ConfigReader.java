package com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config;

import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.BrowserType;

public interface ConfigReader {
	
	public int getImplicitwait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassWord();
	public String getFirstName();
	public String getLastName();
	public String getphonNumber();
		
	

}
