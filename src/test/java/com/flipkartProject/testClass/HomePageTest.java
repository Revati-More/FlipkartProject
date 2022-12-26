package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class HomePageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	
	public HomePageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	homePageObject = new HomePage();
    }
	
	@Test(priority = 1)
	public void testDate() throws InterruptedException
	{
		homePageObject= new HomePage();
		loginPageObject = new LoginPage();
		
		Assert.assertEquals(homePageObject.validateDashboard(), true);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}