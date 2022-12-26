package com.qa.flipkart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;
//Login to Flipkart.

//Select any fashion item.

//Verify all the basic properties of that item. for e.g. Fabric color, size, material, etc etc
public class FashionPage extends BaseClass
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

	@FindBy(xpath = "(//*[@class='eFQ30H'])[5]")
	private WebElement fashionOption;

	@FindBy(xpath = "(//*[@class='_2I9KP_'])[3]")
	private WebElement menOption;
	
	@FindBy(xpath = "//*[@title='Casual Shirts']")
	private WebElement casualShirts;

	public void fashionTab() throws InterruptedException {
		Thread.sleep(3000);
		fashionOption.click();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(menOption).build().perform();
		Thread.sleep(2000);
		act.moveToElement(casualShirts).click().build().perform();	
		//act.keyDown(Keys.ARROW_DOWN).moveToElement(casualShirts).click().build().perform();
		Thread.sleep(3000);
	}

	public void shirt() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> shirt = driver.findElements(By.xpath("//*[@class='_2UzuFa']"));

		for(int i=1; i<=shirt.size()-35; i++)
		{
			shirt.get(i).click();
			Thread.sleep(5000);
			
			Set<String> windows = driver.getWindowHandles();
			ArrayList obj = new ArrayList(windows);
			driver.switchTo().window((String) obj.get(1));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(5000);
			
			WebElement productDetailsTab = driver.findElement(By.xpath("//*[@class='_2yIA0Y']"));
			Thread.sleep(5000);
			productDetailsTab.click();
			
			List<WebElement> elements = driver.findElements(By.xpath("//*[@class='col col-3-12 _2H87wv']"));
			int a = elements.size();
			
			for(int j=1; j<=a; j++)
			{
				System.out.println("Available");
			}

			driver.quit();
			
			Set<String> windows1 = driver.getWindowHandles();
			ArrayList obj1 = new ArrayList(windows1);
			driver.switchTo().window((String) obj1.get(0));
		}
	}

	
	@FindBy(xpath = "//*[@class='_2xm1JU']")
	private WebElement homePage;

	public void redirectToHomePage() throws InterruptedException {
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

	public FashionPage() {
		PageFactory.initElements(driver, this);
	}
}