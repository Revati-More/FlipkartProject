package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.pages.RemoveItemFromCartPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class RemoveItemFromCartPageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	RemoveItemFromCartPage removeItemFromCartPageObject;
	
	public RemoveItemFromCartPageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	removeItemFromCartPageObject = new RemoveItemFromCartPage();
    }
	
	@Test(priority = 1)
	public void removeItemValidation() throws InterruptedException
	{	
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		removeItemFromCartPageObject = new RemoveItemFromCartPage();
		removeItemFromCartPageObject.cartTab();
		removeItemFromCartPageObject.removeItemBtn();
		removeItemFromCartPageObject.redirectToHomePage();
		removeItemFromCartPageObject.goToOption();
		removeItemFromCartPageObject.logout();
	}

	@AfterMethod
	public void tearDown()
	{
		 driver.quit();
	}
	
}