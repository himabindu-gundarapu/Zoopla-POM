package com.zoopla.pageTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.TestBase;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.ListingPage;

public class ListingsPageTest extends TestBase {
	ListingPage ListingsPageObj;
	HomePage HomePageObj;
	
	
	@BeforeClass
	public void Initialize() 
	{
		TestBase.setUp();
		HomePageObj = new HomePage(driver);
		HomePageObj.EntercityTextBox("London");
		ListingsPageObj = HomePageObj.ClicksearchButton();
	}
	
	@Test(priority =1)
	public void validateTitle() {
		String actualtitle =ListingsPageObj.validateListingPageTitle();
		String expectedTitle = "Property for Sale in London - Buy Properties in London - Zoopla";
		Assert.assertEquals(actualtitle,expectedTitle,"listingpage title not matched");
	}
	@Test(priority=2)
	public void MostRecentDrpDwn() {
		ListingsPageObj.MostRecentDropdown();
	}
//	@Test(priority =3)
//	public void  getListings() {
//		ListingsPageObj.getAllListings();
//	}
	
	@Test(priority =5)
	public void clickOnProperty() {
		ListingsPageObj.clickOnFifthListing();
	}
	@AfterClass
	public void teatDown() {
		driver.quit();
	}
}
