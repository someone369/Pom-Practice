package com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uIFrameWork.companyName.projectNmae.hepler.resource.ResourecHelper;

public class IExploreBrowser {
	
	public InternetExplorerOptions getIExplorerCapabilities(){
		DesiredCapabilities cap =  DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(cap);
		
		return internetExplorerOptions;
	}
	public WebDriver getIExplorerDriver(InternetExplorerOptions cap) {
		System.setProperty("webdriver.ie.driver", ResourecHelper.getResourcePath("/Driverss/IEDriverServer.exe"));
		return new InternetExplorerDriver();
	}
	public static void main(String[] args) {
		IExploreBrowser ieb = new IExploreBrowser();
		WebDriver driver = ieb.getIExplorerDriver(ieb.getIExplorerCapabilities());
		driver.get("https://www.bankofamerica.com/");
		
	}
	
}
