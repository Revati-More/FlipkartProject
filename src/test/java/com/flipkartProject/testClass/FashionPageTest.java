package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.FashionPage;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class FashionPageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	FashionPage fashionPageObject;
	
	public FashionPageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	fashionPageObject = new FashionPage();
    }
	
	@Test(priority = 1)
	public void fashionValidation() throws InterruptedException
	{	
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		fashionPageObject = new FashionPage();
		fashionPageObject.fashionTab();
		fashionPageObject.shirt();
		fashionPageObject.redirectToHomePage();
		fashionPageObject.goToOption();
		fashionPageObject.logout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
