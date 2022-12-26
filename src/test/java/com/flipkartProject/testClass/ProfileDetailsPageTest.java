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
import com.qa.flipkart.pages.ProfileDetailsPage;
import com.qa.flipkart.utilities.TestNGListeners;


@Listeners(TestNGListeners.class)
public class ProfileDetailsPageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	
	ProfileDetailsPage profileDetailsPageObject;
	
	public ProfileDetailsPageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	profileDetailsPageObject = new ProfileDetailsPage();
    }

    @Test(priority = 1)
    public void profileDetailsValidation() throws InterruptedException
	{
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		profileDetailsPageObject = new ProfileDetailsPage();
		profileDetailsPageObject.redirectToHomePage();
		profileDetailsPageObject.goToOption();
		profileDetailsPageObject.myProfile();
		Assert.assertEquals(profileDetailsPageObject.uNameTxt(), "firstName");
		Assert.assertEquals(profileDetailsPageObject.lNameTxt(), "lastName");
		Assert.assertEquals(profileDetailsPageObject.femaleTab(), "_2Fn-Ln _2fnqkz _2hH1hC _2LcXZ- _3iI7Qn _3L7Pww");
		Assert.assertEquals(profileDetailsPageObject.emailTab(), "email");
		Assert.assertEquals(profileDetailsPageObject.mobileNoTab(), "mobileNumber");
		profileDetailsPageObject.addressTab();
		Assert.assertEquals(profileDetailsPageObject.addressDetailsTab(), "_26SF1Q");
	}
    
    @AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}