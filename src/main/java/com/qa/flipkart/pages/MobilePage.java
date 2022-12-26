package com.qa.flipkart.pages;

import java.util.ArrayList;
import java.util.Set;

//Login to Flipkart and add any item to cart. Next follow the checkout process and add the card details
//Card details can be fake

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class MobilePage extends BaseClass
{	
	@FindBy(xpath = "//*[@class='_2IX_2- VJZDxU']")
	WebElement mobileNoTxtBox;
	public void mobileno(String mobileNo)
	{
		mobileNoTxtBox.sendKeys(mobileNo);
	}
	
	@FindBy(xpath="//*[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement pwd;
	public void pswrd(String password)
	{
		pwd.sendKeys(password);
	}

	@FindBy(xpath="//*[@class='_1D1L_j']")
	WebElement loginBtn;
	public HomePage loginBtnTab(String mobileNo, String password)
	{
		mobileno(mobileNo);
		pswrd(password);
		loginBtn.click();
		
		System.out.println("Login successfully!!!");
		return new HomePage();
	}
	
	@FindBy(xpath = "(//*[@class='_1mkliO'])[2]")
	private WebElement mobiles;

	public void mobiles() throws InterruptedException {
		Thread.sleep(1000);
		mobiles.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//*[@class='_3YgSsQ'])[4]")
	private WebElement oppoPhone;
	public void oppoPhone() throws InterruptedException
	{
		Thread.sleep(1000);
		oppoPhone.click();
		Thread.sleep(1000);
	}

	@FindBy(xpath = "(//*[@class='_4rR01T'])[2]")
	private WebElement selectPhone;
	public void selectPhone() throws InterruptedException 
	{
		Thread.sleep(1000);
		selectPhone.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//*[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;
	public void addToCartBtn() throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
		ArrayList obj = new ArrayList(windows);
		driver.switchTo().window((String) obj.get(1));
		
		Thread.sleep(10000);
        addToCart.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//*[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement placeOrder;
	public void placeOrderBtn() throws InterruptedException
	{
		Thread.sleep(1000);
		placeOrder.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//*[@class='_2xm1JU']")
	private WebElement homePage;
	public void redirectToHomePage() throws InterruptedException
	{
		Thread.sleep(000);
		homePage.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//*[@class='_28p97w'])[1]")
	private WebElement goTo;
	public void goToOption() throws InterruptedException
	{
		Actions act = new Actions(driver);
        act.moveToElement(goTo).perform();
        Thread.sleep(5000);
	}
	
	@FindBy(xpath = "(//*[@class='_3vhnxf'])[9]")
	private WebElement logout;
	public void logout() throws InterruptedException
	{
		logout.click();
		Thread.sleep(5000);
	}
	
	public MobilePage()
	{
		PageFactory.initElements(driver, this);
	}
}