package com.zoopla.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.TestBase;

public class AgentPage extends TestBase 
{

	@FindBy(xpath= "//div[@class ='listing-results-footer clearfix']//div[@class ='listing-results-left']//p//span")
	List<WebElement> AgentPropertiesList;
	@FindBy(xpath ="//div[@id ='content']//div[@class ='clearfix']//h1//a")
	//@FindBy(css ="body.layout-standard.brand-zoopla:nth-child(2) div.main-content-area.clearfix.wrap:nth-child(9) div.clearfix:nth-child(2) div.layout-standard:nth-child(1) div.clearfix:nth-child(1) div:nth-child(1) h1:nth-child(1) > a:nth-child(1))")
	WebElement AgentName;
	//Initialize the page objects
	public AgentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// to validate selected Agentname on agent page 
	public String validateAgentName() {
		System.out.println("AgentName :"+AgentName);
		return AgentName.getText();
	}
	// To validate all listings has same agent name or not
	public ArrayList<String> validateAllListings(){
		//print the size of AgentpropertiesList
		System.out.println("Size of properties list is  : "+AgentPropertiesList.size());
		
		ArrayList<String> listOfproperties  = new ArrayList<>();
		for(int i=0;i<AgentPropertiesList.size();i++) 
		{
			listOfproperties .add(AgentPropertiesList.get(i).getText());
			System.out.println("listofproperties on agent Page Are : " +listOfproperties.get(i));
			
		}
		return listOfproperties;
	}
	
}
