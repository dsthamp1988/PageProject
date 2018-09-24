package com.maven.cleartrip.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.maven.cleartrip.config.BaseClass;

public class HotelsPage extends BaseClass {

	public HotelsPage()
	{
		super();
	}

	String stayLocation="//*[@id='Tags']";
	String stayDate="//table[@class='calendar']//td";
	String travellersCount="//*[@id='travellersOnhome']";
	String searchHotels="//*[@id='SearchHotelsButton']";
	String hotel_Page="//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[2]/a[1]";
	
	
	public void gotoHotelsPage()
	{	
		getElement(hotel_Page).click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
//method to enter Stay details
	public void enterStayDetails()
	{
		selectLocation();
		selectStayDates(prop.getProperty("CheckinDate"),prop.getProperty("CheckoutDate"));	
		new Select(getElement(travellersCount)).selectByIndex(Integer.parseInt(prop.getProperty("people_Count")));
		getElement(searchHotels).click();
	}

	//method to Select Location from Auto Selection List
	public void selectLocation()
	{
		getElement(stayLocation).clear();
		getElement(stayLocation).sendKeys(prop.getProperty("Stay_Location"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id='ui-id-1']//li"));

		for (int i = 0; i < allOptions.size(); i++) {
			String option = allOptions.get(i).getText();
			if(option.contentEquals("Trivandrum, Kerala, India"))
			{
				allOptions.get(i).click();
			}
		}
	}

	//method to select Stay Dates
	public void selectStayDates(String in_Date,String out_Date)
	{
		driver.findElement(By.id("CheckInDate")).click();
		SelectDate(in_Date);
		driver.findElement(By.id("CheckOutDate")).click();
		SelectDate(out_Date);
	}
	public void SelectDate(String dateSelected)
	{
		List<WebElement> columns=driver.findElements(By.xpath(stayDate));
		for (WebElement ele: columns)
		{
			String date=ele.getText();	
			if(date.equalsIgnoreCase(dateSelected))
			{
				ele.click();
				break;
			}
		}
	}
}
