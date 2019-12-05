package com.uIFrameWork.companyName.projectNmae.testScript.ProductDetailsPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.uIFrameWork.companyName.projectNmae.hepler.browserConfigaration.Config.ObjectReader;
import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.pageObject.ProductCategorypage;
import com.uIFrameWork.companyName.projectNmae.testBase.TestBase;

public class VeryfyLowestFirstPriceFilterTest extends TestBase{
	
	private Logger log =new LoggerHelper().getLogger(VeryfyLowestFirstPriceFilterTest.class);
	
		@Test(description = "Veryfying the Lowest Price Filter working condition ")
		public void lowestPriceFilter(){
		
		getApplicationURL(ObjectReader.reader.getUrl());
		
		ProductCategorypage productCategorypage = new ProductCategorypage(driver);
		
		productCategorypage.clickWomenButton();
		
		productCategorypage.selectSortbyFilter("Price: Lowest first");
		
		List<WebElement> price = productCategorypage.allPriceList();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		Iterator<WebElement> itr = price.iterator();
		
		productCategorypage.convertingPriceInToIntegerValue();
		productCategorypage.getLowestPriceAssendingOrder(array);
	}
	
}
