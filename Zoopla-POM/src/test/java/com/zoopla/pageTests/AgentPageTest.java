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
	String agentName;
	
	@BeforeClass
	public void initialize() {
		TestBase.setUp(); 
		test = report.startTest("AgentPageTestCase");
		HomePageObj = new  HomePage(driver);
		HomePageObj.preferencesClick();
		HomePageObj.EntercityTextBox("London");
		ListingPageObj = HomePageObj.ClicksearchButton();
		PropertyPageObj = ListingPageObj.clickOnFifthListing();
		agentName = PropertyPageObj.AgentName();
		AgentPageObj = PropertyPageObj.clickOnAgentname();
	}
	//validating the agent name from property details page and Agent page
	@Test(priority =1)
	public void validateAgentName() {
		String actual =  AgentPageObj.validateAgentName();
		System.out.println("Actual agent name : "+ actual);
		String expected = agentName;
		System.out.println("Agent name on Property details page :"+expected);
		test.log(LogStatus.INFO,"actual agentName on Property" +actual);
		System.out.println("Agentname on property deatils page :" +expected);
		test.log(LogStatus.INFO,"Expected agentName on Property" +expected);
		System.out.println("Agentname on Agent deatils page :" +actual);
		// asserting that expected value contains actual agent name or not
		Assert.assertTrue(expected.contains(actual));
		test.log(LogStatus.PASS,"Agent testcase passed");
		}
	
	//Validating all listings which are displayed on agent page with agent name
	@Test(priority=2)
	public void validateAllListing() {
		ArrayList<String> AllListings = AgentPageObj.validateAllListings();
		System.out.println("AllListings : "+AllListings);
		
		String agentNameOnAgentPage= AgentPageObj.validateAgentName(); ;
		for(String s: AllListings) {
			System.out.println("Listings :  "+s);
			 Assert.assertTrue(s.contains(agentNameOnAgentPage),"agentname not found");
			 test.log(LogStatus.INFO,"AgenentName matched" +s );
			}
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
