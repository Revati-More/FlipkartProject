package com.qa.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class RemoveItemFromCartPage extends BaseClass
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
	
	@FindBy(xpath = "//*[@class='_3SkBxJ']")
	private WebElement cart;
	public void cartTab() throws InterruptedException
	{
		Thread.sleep(2000);
		cart.click();
		Thread.sleep(3000);
	}

	public void removeItemBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		
		List<WebElement> removeItem = driver.findElements(By.xpath("//*[text()='Remove']"));
		for(int i=0;i<removeItem.size();i++)
		{
			removeItem.get(i).click();
			driver.findElement(By.xpath("//*[@class='_3dsJAO _24d-qY FhkMJZ']")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//*[@class='_2sKwjB']")).isDisplayed());
			Thread.sleep(2000);
		}
	}
	
	@FindBy(xpath = "//*[@class='_2xm1JU']")
	private WebElement homePage;
	public void redirectToHomePage() throws InterruptedException
	{
		Thread.sleep(5000);
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
	
	public RemoveItemFromCartPage()
	{
		PageFactory.initElements(driver, this);
	}
}