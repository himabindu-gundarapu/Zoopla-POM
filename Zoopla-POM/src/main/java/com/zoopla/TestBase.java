package com.zoopla;


	

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Util.CommonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase extends CommonUtils {
	public static WebDriver driver;
	

	
		public static void setUp() {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			driver.get("https://www.zoopla.co.uk/");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@class ='ui-cookie-consent-choose__buttons']//button[1]")).click();
			CommonUtils.CreateReport();
			}


	}


