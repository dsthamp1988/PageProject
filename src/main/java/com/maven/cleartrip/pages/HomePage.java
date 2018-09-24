package com.maven.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.maven.cleartrip.config.BaseClass;

public class HomePage extends BaseClass {

	public HomePage()
	{
		super();
	}

	String tripType="//*[@id='RoundTrip']";
	String fromLocation="//*[@id='FromTag']";
	String toLocation="//*[@id='ToTag']";
	String dateofTravel="//table[@class='calendar']//td";
	String adultCount="//*[@id='Adults']";
	String searchFlights="//*[@id='SearchBtn']";
	
//method to enter Trip details
	public void enterTripDetails() {

		getElement(tripType).click();
		getElement(fromLocation).sendKeys(prop.getProperty("From"));
		getElement(toLocation).sendKeys("To");	
		tripDates(prop.getProperty("DepartureDate"),prop.getProperty("ReturnDate"));
		new Select(getElement(adultCount)).selectByValue(prop.getProperty("Count"));
		getElement(searchFlights).click();
	}
//method to select TripDates
	public void tripDates(String departDate,String returnDate)
	{
		driver.findElement(By.id("DepartDate")).click();
		SelectDate(departDate);
		driver.findElement(By.id("ReturnDate")).click();
		SelectDate(returnDate);
	}
	public void SelectDate(String dateSelected )
	{
		List<WebElement> columns=driver.findElements(By.xpath(dateofTravel));
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
