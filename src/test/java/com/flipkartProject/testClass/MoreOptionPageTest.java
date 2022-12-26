package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.MoreOptionPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class MoreOptionPageTest extends BaseClass 
{
	MoreOptionPage moreOptionPageObject;

	public MoreOptionPageTest() throws IOException
	    {
			super();
		}

	@BeforeMethod
	public void beginMethod() {
		setUp();
		moreOptionPageObject = new MoreOptionPage();
	}

	@Test(priority = 1)
		public void fashionValidation() throws InterruptedException
		{	
			moreOptionPageObject = new MoreOptionPage();
			moreOptionPageObject.closeTab();
			moreOptionPageObject.moreOption();
			moreOptionPageObject.customerCare();
			moreOptionPageObject.helpIssues();
			Assert.assertEquals(moreOptionPageObject.msgDisp(), "_3KzYy1 _13AyN6");
			moreOptionPageObject.listOfMsgs();
		}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
