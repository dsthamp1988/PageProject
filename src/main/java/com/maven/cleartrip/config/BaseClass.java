package com.maven.cleartrip.config;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.maven.cleartrip.framework.BaseTest;

public class BaseClass extends BaseTest {

	protected WebDriver driver = null;   
	
	public BaseClass()
	{ 
		// code to choose the Browser
		if (prop.getProperty("Browser").contentEquals("chrome"))
			{
			// Code to Initialize Chrome Browser
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("-disable-cache");
			options.addArguments("--disable-notifications");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			System.setProperty("webdriver.chrome.driver","E:\\KeywordFramework\\KeywordWorkspace\\PageProject\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			}
		else if (prop.getProperty("Browser").contentEquals("firefox"))
		{
			//Code to launch Firefox
			System.out.println("FireFox");
		}	
		else if (prop.getProperty("Browser").contentEquals("IE"))
		{
			//Code to launch IE
			System.out.println("IE");
		}	
	}
	
	//Method that opens url
	public void openClearTrip() {
		
		driver.get(prop.getProperty("URL"));
	}
	//Method that closes browser
	public void closeClearTrip() {

		driver.quit();
	}
	
	//method to replace use of findElement
	public WebElement getElement(String locator)
	{
		return driver.findElement(By.xpath(locator));
	}
}
