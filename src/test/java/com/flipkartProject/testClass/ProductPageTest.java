package com.flipkartProject.testClass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.baseclass.BaseClass;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.pages.ProductPage;
import com.qa.flipkart.utilities.TestNGListeners;

@Listeners(TestNGListeners.class)
public class ProductPageTest extends BaseClass
{
	LoginPage loginPageObject;
	HomePage homePageObject;
	
	ProductPage productPageObject;
	
	public ProductPageTest() throws IOException
    {
		super();
	}
    
    @BeforeMethod
    public void beginMethod()
    {
    	setUp();
    	productPageObject = new ProductPage();
    }
	
	@Test(priority = 1)
	public void productValidation() throws InterruptedException
	{
		loginPageObject = new LoginPage();
		homePageObject = new HomePage();
		homePageObject = loginPageObject.loginBtnTab(prop.getProperty("mobileNo"), prop.getProperty("password"));
		
		productPageObject = new ProductPage();
		productPageObject.btnClick();
		productPageObject.product();
		productPageObject.addToWishlistLogo();
		productPageObject.checkWishlistOption();
		productPageObject.wishlist();
		productPageObject.wishListItemDisp();
		productPageObject.redirectToHomePage();
		productPageObject.goToOption();
		productPageObject.logout();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}