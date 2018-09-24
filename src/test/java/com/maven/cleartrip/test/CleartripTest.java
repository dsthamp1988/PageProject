package com.maven.cleartrip.test;

import org.testng.annotations.Test;

import com.maven.cleartrip.framework.BaseTest;
import com.maven.cleartrip.pages.HomePage;
import com.maven.cleartrip.pages.HotelsPage;

public class CleartripTest extends BaseTest{

	//Test for Multiway Trip selection
	@Test
	public void MultiwayReservation()
	{
		HomePage homePage=new HomePage();
		homePage.openClearTrip();
		homePage.enterTripDetails();
		homePage.closeClearTrip();	
	}
	//Test for Hotel Selection
	@Test
	public void HotelReservation()
	{
		HotelsPage hotelPage=new HotelsPage();
		hotelPage.openClearTrip();
		hotelPage.gotoHotelsPage();
		hotelPage.enterStayDetails();
		hotelPage.closeClearTrip();
	}

}
