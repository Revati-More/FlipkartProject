package com.qa.flipkart.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class ProductPage extends BaseClass
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
	
	@FindBy(xpath = "//*[@name='q']")
	private WebElement searchButton;
	public void btnClick() throws InterruptedException 
	{
		Thread.sleep(5000);
		Actions act = new Actions(driver);
        act.moveToElement(searchButton).click().sendKeys("laptop").click().build().perform();
        driver.findElement(By.xpath("//*[@class='L0Z3Pu']")).click();
        Thread.sleep(5000);
	}

	@FindBy(xpath = "(//*[@class='_1fQZEK'])[1]")
	private WebElement selectedProduct;
	public void product() throws InterruptedException
	{
		Thread.sleep(5000);
		selectedProduct.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "(//*[@class='eX72wL'])[1]")
	private WebElement addToWishlist;
	public void addToWishlistLogo() throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
		ArrayList obj = new ArrayList(windows);
		driver.switchTo().window((String) obj.get(1));

		addToWishlist.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "(//*[@class='_28p97w'])[1]")
	private WebElement checkWishlist;
	public void checkWishlistOption() throws InterruptedException
	{
		Actions act = new Actions(driver);
        act.moveToElement(checkWishlist).perform();
        Thread.sleep(5000);
	}
	
	@FindBy(xpath = "(//*[@class='_3vhnxf'])[5]")
	private WebElement wishListOption;
	public void wishlist() throws InterruptedException
	{
		wishListOption.click();
		Thread.sleep(5000);
	}
	
	@FindBy(xpath = "//*[@alt='Lenovo IdeaPad 3 Core i3 11th Gen - (8 GB/256 GB SSD/Windows 11 Home) 14ITL05 Thin and Light Laptop']")
	private WebElement wishListItem;
	public void wishListItemDisp() throws InterruptedException
	{
		Thread.sleep(10000);
		System.out.println(wishListItem.isDisplayed());
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
	
	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}
}
