package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.pages.MobilePage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class MobilePageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	MobilePage mobilePageObject;

    public MobilePageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	mobilePageObject = new MobilePage();
    }
	
	@Test(priority = 1)
	public void mobileValidation() throws InterruptedException
	{	
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		mobilePageObject = new MobilePage();
		mobilePageObject.mobiles();
		mobilePageObject.oppoPhone();
		mobilePageObject.selectPhone();
		mobilePageObject.addToCartBtn();
		mobilePageObject.redirectToHomePage();
		mobilePageObject.goToOption();
		mobilePageObject.logout();
	}

	@AfterMethod
	public void tearDown()
	{
		 driver.quit();
	}
}
