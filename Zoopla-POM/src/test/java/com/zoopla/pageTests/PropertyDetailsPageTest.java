package com.zoopla.pageTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.zoopla.TestBase;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.ListingPage;
import com.zoopla.pages.PropertyDetailsPage;

public class PropertyDetailsPageTest extends TestBase
{
	PropertyDetailsPage  PropertyPageObj;
	ListingPage Listingpageobj;
	HomePage HomePageObj;
	String SelectedPropertyAddress;// = Listingpageobj.AddressOfTheFifthProperty(); 
	@BeforeClass
	public void Initialize() 
	{
		TestBase.setUp();
		logger = report.startTest("PropertyDetailsPageTest");
		HomePageObj = new HomePage(driver); 
		HomePageObj.EntercityTextBox("London");
		Listingpageobj = HomePageObj.ClicksearchButton();
		SelectedPropertyAddress = Listingpageobj.AddressOfTheFifthProperty();
		PropertyPageObj = Listingpageobj.clickOnFifthListing();
	}
	
	
	 @Test(priority =1)
	 public void ValidatepageTitle() {
		 String actualUrl= PropertyPageObj.validateSelectedpropertypageURL();
		 String expectedUrl = "https://www.zoopla.co.uk/for-sale/details/58625425/?search_identifier=c14ac08bf282507f6273830c65fcde12";
		 logger.log(LogStatus.INFO,"PropertyDetailsPageUrl" +actualUrl);
		 Assert.assertEquals(actualUrl,expectedUrl,"URL not matched");
		 logger.log(LogStatus.INFO,"URL matched");
		 }
	 @Test(priority=2)
	 public void validateAgentAddress() {
		String actualaddress = PropertyPageObj.validatePropertyAddress();
		String expectedAddress = SelectedPropertyAddress;
		logger.log(LogStatus.INFO,"AgentAddress on selected property" +actualaddress);
		 Assert.assertEquals(actualaddress,expectedAddress);
		 logger.log(LogStatus.INFO,"AgentAddress on selected property verified");
	 }
	 
	 @Test(priority=2)
	 public void ClickOnViewProperty() {
		 PropertyPageObj.clickOnAgentname();
	 }
	 @AfterClass
	 public void tearDown() {
		 driver.quit();
	 }
	 
}
