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
public class LoginPageTest extends BaseClass
{	
		LoginPage loginPageObject;
	    HomePage homePageObject;
	    
	    public LoginPageTest() throws IOException
	    {
			super();
		}
	    
	    @BeforeMethod
	    public void beginMethod()
	    {
	    	setUp();
	    	loginPageObject = new LoginPage();
	    }
	    
	    @Test(priority = 1)
	    public void loginValidation()
		{
	    	loginPageObject = new LoginPage();
	    	
	    	Assert.assertEquals(loginPageObject.validateSignInWindow(), "_3wFoIb row");
	 
	    	Assert.assertEquals(loginPageObject.createNewFlipkartAccount(), "New to Flipkart? Create an account");
	    	
	    	Assert.assertEquals(loginPageObject.validatetermsAndConditions(), "_1Ijv5h");
	    	
	    	Assert.assertEquals(loginPageObject.forgotLink(), "_2QKxJ- _2_DUc_");
	    	
	    	Assert.assertEquals(loginPageObject.validaterequestOTP(), "_2KpZ6l _2HKlqd _3NgS1a");
	        	
	    	homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		}
	    
	    @AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}