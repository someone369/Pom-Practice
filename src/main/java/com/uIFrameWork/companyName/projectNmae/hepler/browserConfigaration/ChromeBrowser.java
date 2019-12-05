package com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uIFrameWork.companyName.projectNmae.hepler.resource.ResourecHelper;

public class ChromeBrowser {
	/**
	 * 
	 * @author Lakshmi Narasimham
	 * 
	 */
public ChromeOptions getChromeOptions() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities capabilities  = DesiredCapabilities.chrome();
		capabilities .setJavascriptEnabled(true);
		
		capabilities .setCapability(ChromeOptions.CAPABILITY, option );	
		
		//Linux
		if(System.getProperty("os.name").contains("Linux")){
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return option;
		
		
	}

	public WebDriver getChromeDriver(ChromeOptions cap){
		if(System.getProperty("os.name").contains("Mac")){
			System.setProperty("webdriver.chrome.driver", ResourecHelper.getResourcePath("/Driverss/chromedriver"));
			return new ChromeDriver(cap);
		}else if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.chrome.driver", ResourecHelper.getResourcePath("/Driverss/chromedriver.exe"));
			return new ChromeDriver(cap);
		}else if(System.getProperty("os.name").contains("Linux")){
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
			return new ChromeDriver(cap);
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		ChromeBrowser obj = new ChromeBrowser();
		WebDriver driver = obj.getChromeDriver(obj.getChromeOptions());
		driver.get("https://www.bankofamerica.com/");
	}
}
