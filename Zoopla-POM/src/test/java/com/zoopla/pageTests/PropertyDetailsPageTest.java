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
		test = report.startTest("PropertyDetailsPageTest");
		HomePageObj = new HomePage(driver);
		HomePageObj.preferencesClick();
		HomePageObj.EntercityTextBox("London");
		Listingpageobj = HomePageObj.ClicksearchButton();
		SelectedPropertyAddress = Listingpageobj.AddressOfTheFifthProperty();
		System.out.println("Selected property address :"+SelectedPropertyAddress);
		PropertyPageObj = Listingpageobj.clickOnFifthListing();
	}
	
	
//	 @Test(priority =1)
//	 public void ValidatepageTitle() {
//		 String actualUrl= PropertyPageObj.validateSelectedpropertypageURL();
//		 String expectedUrl = "https://www.zoopla.co.uk/for-sale/details/58625425/?search_identifier=c14ac08bf282507f6273830c65fcde12";
//		 logger.log(LogStatus.INFO,"PropertyDetailsPageUrl" +actualUrl);
//		 Assert.assertEquals(actualUrl,expectedUrl,"URL not matched");
//		 logger.log(LogStatus.INFO,"URL matched");
//		 }
	 @Test(priority=1)
	 public void validateAgentAddress() {
		String actualaddress = PropertyPageObj.validatePropertyAddress();
		System.out.println("selectedProprty address"+ actualaddress);
		String expectedAddress = SelectedPropertyAddress;
		test.log(LogStatus.INFO,"AgentAddress on selected property" +actualaddress);
		 Assert.assertEquals(actualaddress,expectedAddress);
		 test.log(LogStatus.INFO,"AgentAddress on selected property verified");
	 }
//	 @Test(priority =2)
	 public void GetAgentName() {
		PropertyPageObj.AgentName();
	 }
	 
	 @Test(priority=3)
	 public void ClickOnViewProperty() {
		 PropertyPageObj.clickOnAgentname();
	 }
	 @AfterClass
	 public void tearDown() {
		 driver.quit();
	 }
	 
}
