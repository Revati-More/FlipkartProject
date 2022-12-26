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
import com.qa.flipkart.pages.ProductOutOfStockPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class ProductOutOfStockPageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	
	ProductOutOfStockPage productOutOfStockPageObject;
	
	public ProductOutOfStockPageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	productOutOfStockPageObject = new ProductOutOfStockPage();
    }

    @Test(priority = 1)
	public void outOfStockProductValidation() throws InterruptedException
	{
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		productOutOfStockPageObject = new ProductOutOfStockPage();
		productOutOfStockPageObject.btnClick();
		productOutOfStockPageObject.outOfStockProducts();
		productOutOfStockPageObject.notifyMeBtn();
		Assert.assertEquals(productOutOfStockPageObject.soldOutTxt(), "Sold Out");
		productOutOfStockPageObject.shareOption();
		productOutOfStockPageObject.facebookBtn();
		productOutOfStockPageObject.emailIdTab();
		productOutOfStockPageObject.passwordTab();
		productOutOfStockPageObject.loginTab();
		productOutOfStockPageObject.aboutProductTxt();
		productOutOfStockPageObject.postTab();
		productOutOfStockPageObject.redirectToHomePage();
		productOutOfStockPageObject.goToOption();
		productOutOfStockPageObject.logout();
	}	
    
    @AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}