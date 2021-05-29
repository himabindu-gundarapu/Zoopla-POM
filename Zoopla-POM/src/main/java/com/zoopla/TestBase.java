package com.zoopla;


	

	import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.zoopla.Util.CommonUtils;
import com.zoopla.Util.ConfigPropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase extends CommonUtils {
	public static WebDriver driver;
	public static Properties props;
		public static void setUp() 
		{
			
			try {
				props = ConfigPropertyReader.readProperties();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String  browser = props.getProperty("browser");
			System.out.print("browsername " +browser);
			if(browser.equalsIgnoreCase("chrome")) 
			 {
				 System.out.print("browser " +browser);
				 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
			 }
			else{
				 WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
			 }
			
			driver.get(props.getProperty("url"));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//div[@class ='ui-cookie-consent-choose__buttons']//button[1]")).click();
			//CommonUtils.CreateReport();
			}
	
	@BeforeSuite
	public  void createReport() {
		CommonUtils.CreateReport();
		test = report.startTest("PropertyDetailsPageTest");
	}
	@AfterSuite
	public void closeReport() {
		CommonUtils.CloseReport();
	}
	}
	
	


