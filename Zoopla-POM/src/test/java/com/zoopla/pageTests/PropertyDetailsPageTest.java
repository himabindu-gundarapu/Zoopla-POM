package com.zoopla.pageTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zoopla.TestBase;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.ListingPage;
import com.zoopla.pages.PropertyDetailsPage;

public class PropertyDetailsPageTest extends TestBase
{
	PropertyDetailsPage  PropertyPageObj;
	ListingPage Listingpageobj;
	HomePage HomePageObj;
	String SelectedPropertyAddress = Listingpageobj.AddressOfTheFifthProperty(); 
	@BeforeClass
	public void Initialize() 
	{
		TestBase.setUp();
		HomePageObj = new HomePage(driver); 
		HomePageObj.EntercityTextBox("London");
		Listingpageobj = HomePageObj.ClicksearchButton();
		PropertyPageObj = Listingpageobj.clickOnFifthListing();
	}
	
	
	 @Test(priority =1)
	 public void ValidatepageTitle() {
		 String actualUrl= PropertyPageObj.validateSelectedpropertypageURL();
		 String expectedUrl = "https://www.zoopla.co.uk/for-sale/details/58625425/?search_identifier=c14ac08bf282507f6273830c65fcde12";
		 Assert.assertEquals(actualUrl,expectedUrl,"URL not matched");
		 }
	 @Test(priority=2)
	 public void validateAgentAddress() {
		String actualaddress = PropertyPageObj.validatePropertyAddress();
		String expectedAddress = SelectedPropertyAddress;
		Assert.assertEquals(actualaddress,expectedAddress);
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
