package com.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.zoopla.TestBase;
import com.zoopla.Util.*;
public class PropertyDetailsPage extends TestBase {
	@FindBy(xpath ="//a[@class ='e11937k19 css-1pbymdb-StyledLink-Link-AgentProperties e33dvwd0']")
	WebElement viewagentPropertylink;
	//@FindBy(xpath ="//*[@id=\"main-content\"]/div[1]/div[10]/div/div[1]/div[1]/h3/text()")
	//@FindBy(css ="main.css-eufhjz-Page-Wrapper-Layout.e9rwlqv15:nth-child(5) div.css-p1r19z-Primary.e9rwlqv13:nth-child(1) div.css-1uo8zdu-Secondary.e9rwlqv12:nth-child(12) div.css-7a6r2h-SecondaryContent.e9rwlqv11 div.css-5mp4ru-AgentDetailsContainer.e11937k12 div.css-1lbqz6a-AgentHeader.e11937k17 > h3.css-e13akx-Heading3-AgentHeading.e11937k16")
	@FindBy(xpath ="//h3[@class ='css-e13akx-Heading3-AgentHeading e11937k16']")
	WebElement agentName;
	
	//@FindBy(xpath ="//div[@class ='css-1nc2nta-BodyContainer evrk8bx7']//h1//span[2]")
	@FindBy(css = "main.css-eufhjz-Page-Wrapper-Layout.e9rwlqv15:nth-child(5) div.css-p1r19z-Primary.e9rwlqv13:nth-child(1) div.css-1dgvrpj-SummaryContainer.evrk8bx17:nth-child(2) div.css-1nc2nta-BodyContainer.evrk8bx7 h1.css-pwcj9r-TitleWrapper.evrk8bx6 > span.css-juh6tp-DisplayAddressLabel.evrk8bx4")
	WebElement selctedPropertyAddress;
	
	
	
//Initialzing the page objects
	public PropertyDetailsPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	public String validateSelectedpropertypageURL() {
		return driver.getCurrentUrl();
		
	}
	public String AgentName() {
		String name = agentName.getText();
		System.out.println("Agent name :"+ name);
		return name;
	}
	public String validatePropertyAddress() {
		System.out.println("slected property address = " +selctedPropertyAddress.getText());
		
		return selctedPropertyAddress.getText();
	}
	public AgentPage clickOnAgentname() {
		CommonUtils.ClickButton(viewagentPropertylink, "Viewproperty");
		return  new AgentPage(driver);
	}

}
