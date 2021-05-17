package com.zoopla.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.zoopla.TestBase;

import Util.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ListingPage extends TestBase {
	
//most recent dropdown
	@FindBy(id ="sort-order-dropdown")
	WebElement mostRecentDropdown;
	@FindBy(xpath ="//div[@class='css-wfndrn-StyledContent e2uk8e18']")
	List<WebElement> listings;
	// Initializing the page objects
	public ListingPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	public void MostRecentDropdown() {
		Select sort = new Select(mostRecentDropdown);
		sort.selectByVisibleText("Highest price");
	}
	public void getAllListings() {
		System.out.println("size : "+listings.size());
		for(int i=0;i<listings.size();i++) {
			System.out.println("All the listings : "+listings.get(i).getText());
			}
	}
	
	// to click on 5th property from listings
	public PropertyDetailsPage clickOnFifthListing() {
		WebElement fifthListing =listings.get(4);
		CommonUtils.ClickButton(fifthListing,"FifthListing");
		return new PropertyDetailsPage(driver);
	}
	public String textOfFifthProperty() {
		System.out.println("Fifthproperty details :" +listings.get(4).getText());
		return listings.get(4).getText();
	}
	//to validate Listing page title
	public String validateListingPageTitle() {
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
}
