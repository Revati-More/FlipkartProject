package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.pages.TravelPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class TravelPageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	
	TravelPage travelPageObject;

	public TravelPageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	travelPageObject = new TravelPage();
    }
	
	@Test(priority = 1)
	public void travelValidation() throws InterruptedException
	{
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		travelPageObject = new TravelPage();
		travelPageObject.validateTravel();
		travelPageObject.roundTrip();
		travelPageObject.selectFromCity();
		travelPageObject.selectToCity();
		travelPageObject.calendarVerfication();
		travelPageObject.travellerVerfication();
		travelPageObject.btnClick();
		travelPageObject.checkCheapPrice();
		travelPageObject.redirectToHomePage();	
		travelPageObject.goToOption();
		travelPageObject.logout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}