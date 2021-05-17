package com.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.TestBase;

import Util.CommonUtils;

public class HomePage  extends TestBase{
	//element for pop up 
@FindBy(xpath= "//*[@id=\"cookie-consent-form\"]/div/div/div/button[1]")
WebElement  preferences;
@FindBy(id = "header-location")
WebElement entercityTextbox;
@FindBy(xpath ="//button[@class=\"css-1s5vaqk-Button-UpdateButton-StyledButton ebz205c11\"]")
WebElement searchButton;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
 
public void preferencesClick() {
	preferences.click();
}
public void EntercityTextBox(String cityName) {
	CommonUtils.EnterText(entercityTextbox, cityName);
	//entercityTextbox.sendKeys(cityName);
	
}
//Verify Home page title
public String verifyHomePageTitle(){
	return driver.getTitle();
} 
public ListingPage ClicksearchButton() {
	CommonUtils.ClickButton(searchButton, "Search");
	return new ListingPage(driver);
}


}
