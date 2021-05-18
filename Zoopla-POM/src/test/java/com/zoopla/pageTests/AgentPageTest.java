package com.zoopla.pageTests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.zoopla.TestBase;
import com.zoopla.pages.AgentPage;
import com.zoopla.pages.HomePage;
import com.zoopla.pages.ListingPage;
import com.zoopla.pages.PropertyDetailsPage;

public class AgentPageTest extends TestBase {
	
	AgentPage  AgentPageObj;
	PropertyDetailsPage  PropertyPageObj;
	HomePage HomePageObj;
	ListingPage ListingPageObj;
	
	@BeforeClass
	public void initialize() {
		TestBase.setUp(); 
		logger = report.startTest("AgentPageTestCase");
		HomePageObj = new  HomePage(driver);
		HomePageObj.EntercityTextBox("London");
		ListingPageObj = HomePageObj.ClicksearchButton();
		PropertyPageObj = ListingPageObj.clickOnFifthListing();
		AgentPageObj = PropertyPageObj.clickOnAgentname();
	}
	//validating the agent name from property details page and Agent page
	@Test(priority =1)
	public void validateAgentName() {
		String actual =  AgentPageObj.validateAgentName();
		String expected = PropertyPageObj.validateAgentName();
		logger.log(LogStatus.INFO,"actual agentName on Property" +actual);
		System.out.println("Agentname on property deatils page :" +expected);
		logger.log(LogStatus.INFO,"Expected agentName on Property" +expected);
		System.out.println("Agentname on Agent deatils page :" +actual);
		Assert.assertEquals(actual, expected);
		logger.log(LogStatus.PASS,"Agent testcase passed");
		}
	
	//Validating all listings which are displayed on agent page with agent name
	@Test(priority=2)
	public void validateAllListing() {
		ArrayList<String> AllListings = AgentPageObj.validateAllListings();
		String agentName = AgentPageObj.validateAgentName();
		for(String s: AllListings) {
			System.out.println("Listings :  "+s);
			 Assert.assertTrue(s.contains(agentName),"agentname not found");
			 logger.log(LogStatus.INFO,"AgenentName matched" +s );
			}
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
