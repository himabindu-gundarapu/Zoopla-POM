
// Trial programm for zoopla


package com.zoopla;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {
	WebDriver driver;
@BeforeTest
	public void setUp() throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		

	}
@Test
public void homapageTest() throws InterruptedException {
	driver.findElement(By.xpath("//div[@class ='ui-cookie-consent-choose__buttons']//button[1]")).click();
	WebElement  entercityTextbox = driver.findElement(By.id("header-location"));
	entercityTextbox.click();
	entercityTextbox.sendKeys("London");
	WebElement searchbtn = driver.findElement(By.xpath("//button[@class=\"css-1s5vaqk-Button-UpdateButton-StyledButton ebz205c11\"]"));
	searchbtn.click();
	
	
	List<WebElement> listOfProperties = driver.findElements(By.xpath("//div[@class='css-wfndrn-StyledContent e2uk8e18']"));
	System.out.println("Size Of List:"+listOfProperties.size());
	System.out.println("List of properties :" +listOfProperties.get(0).getText() );
	List<WebElement> AgentImgsList = driver.findElements(By.xpath("//a[@class='e2uk8e4 css-15tydk8-StyledLink-Link-FullCardLink e33dvwd0']//p"));
	System.out.println("AgentImg List :" +AgentImgsList.get(0).getText());
	listOfProperties.get(0).click();
	
	System.out.println("Agentname" + driver.findElement(By.cssSelector("main.css-eufhjz-Page-Wrapper-Layout.e9rwlqv15:nth-child(5) div.css-p1r19z-Primary.e9rwlqv13:nth-child(1) div.css-1uo8zdu-Secondary.e9rwlqv12:nth-child(12) div.css-7a6r2h-SecondaryContent.e9rwlqv11 div.css-5mp4ru-AgentDetailsContainer.e11937k12 div.css-1lbqz6a-AgentHeader.e11937k17 > h3.css-e13akx-Heading3-AgentHeading.e11937k16")).getText());
	String Address = driver.findElement(By.xpath("//div[@class ='css-1nc2nta-BodyContainer evrk8bx7']//h1//span[2]")).getText();
	System.out.println("Address : "+Address);
	
	//	driver.findElement(By.linkText("View agent properties")).click();
//	System.out.println(driver.findElement(By.cssSelector("body.layout-standard.brand-zoopla:nth-child(2) div.main-content-area.clearfix.wrap:nth-child(9) div.clearfix:nth-child(2) div.layout-standard:nth-child(1) div.clearfix:nth-child(1) div:nth-child(1) h1:nth-child(1) > a:nth-child(1)")).getText());
//	List<WebElement> list = driver.findElements(By.xpath("//div[@class ='listing-results-footer clearfix']//div[@class ='listing-results-left']//p//span"));
//	System.out.println("List of properties size :"+ list.size());
//	for(int i =0; i<list.size();i++) {
//		System.out.println("property :"+list.get(i).getText());
//	}
//	Thread.sleep(2000);
	driver.close();
	
	
}

}
