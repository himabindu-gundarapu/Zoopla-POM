package com.zoopla.pageTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.zoopla.TestBase;
import com.zoopla.pages.AgentPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.ListingPage;
import com.zoopla.pages.PropertyDetailsPage;

public class HomepageTest extends TestBase
{
	HomePage HomepageObj;
	AgentPage AgentPageObj;
	ListingPage ListingsPageObj;
	PropertyDetailsPage propertyDetailPageObj;
	public HomepageTest() {
		super();
	}
	@BeforeClass
	public void Initialize() {
		TestBase.setUp();
		test = report.startTest("HomePageTestCase");
		HomepageObj = new HomePage(driver);
		
//		HomepageObj.preferencesClick();
//		System.out.println("pop up clicked");
//		
		
	}
	
	@Test(priority =1)
	public void ClickOnPopup() {
		HomepageObj.preferencesClick();
		System.out.println("pop up clicked");
	}
	@Test(priority =1)
	public void validateHomepageTitle() {
		
		String actualtitle = HomepageObj.verifyHomePageTitle();
		System.out.println("actual homepage title :  "+actualtitle);
		test.log(LogStatus.INFO,"HomePageTitle" +actualtitle );
		String ExpectedTitle ="Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
		Assert.assertEquals(actualtitle,ExpectedTitle,"Fail");
	}
	@Test(priority =2)
	public void EnterText() {
		HomepageObj.EntercityTextBox("London");
	}
	@Test(priority =3)
	public void clickOnsearchBtn() {
		HomepageObj.ClicksearchButton();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
