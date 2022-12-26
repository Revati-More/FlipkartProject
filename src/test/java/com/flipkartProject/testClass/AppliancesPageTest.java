package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.AppliancesPage;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class AppliancesPageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	
	AppliancesPage appliancesPageObject;
	
	public AppliancesPageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	appliancesPageObject = new AppliancesPage();
    }
    
	@Test(priority = 1)
	public void apppliancesValidation() throws InterruptedException
	{
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		appliancesPageObject = new AppliancesPage();
		appliancesPageObject.appliances();
		appliancesPageObject.coffeeMaker();
		appliancesPageObject.checkMinMaxPrice();
		appliancesPageObject.redirectToHomePage();
		appliancesPageObject.goToOption();
		appliancesPageObject.logout();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}