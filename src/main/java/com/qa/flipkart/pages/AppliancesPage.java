package com.qa.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class AppliancesPage extends BaseClass
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
	
	@FindBy(xpath = "(//*[@class='_1mkliO'])[6]")
	private WebElement appliances;

	public void appliances() throws InterruptedException {
		Thread.sleep(1000);
		appliances.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//*[@class='_2I9KP_'])[2]")
	private WebElement tvAndapp;

	@FindBy(xpath = "//*[@title='Coffee Makers']")
	private WebElement coffeeMakers;

	public void coffeeMaker() throws InterruptedException
	{
		tvAndapp.click();
		Thread.sleep(1000);
		
		Actions action = new Actions(driver);
		action.moveToElement(coffeeMakers).click().build().perform();
		Thread.sleep(1000);
	}

	public void checkMinMaxPrice() throws InterruptedException 
	{
		WebElement fromRange = driver.findElement(By.xpath("//*[@class='_1YAKP4']"));
		fromRange.click();
		
		Actions act = new Actions(driver);
        act.moveToElement(fromRange).click().keyDown(Keys.DOWN).build().perform();
       
        WebElement value=driver.findElement(By.xpath("//*[text()='₹500']"));
        Thread.sleep(5000);
        String priceValue=value.getAttribute("value");
        int a = Integer.parseInt(priceValue);
        System.out.println(a);
		
		WebElement toRange = driver.findElement(By.xpath("//*[@class='_3uDYxP']"));
		toRange.click();
		
		Actions ac = new Actions(driver);
        ac.moveToElement(toRange).click().keyDown(Keys.DOWN).build().perform();
        
        WebElement value1=driver.findElement(By.xpath("//*[text()='₹1000']"));
        Thread.sleep(5000);
        String priceValue1=value1.getAttribute("value"); 
        int b= Integer.parseInt(priceValue1);
		System.out.println(b);
		
		WebElement firstElement = driver.findElement(By.xpath("(//*[@class='_30jeq3'])[1]"));
		Thread.sleep(5000);
		String firstelementPrice = firstElement.getText();
		firstelementPrice = firstelementPrice.replaceAll("[^a-zA-Z0-9]","");
		int c = Integer.parseInt(firstelementPrice);
		System.out.println("Price of the Product is : " + c);
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
	
	public AppliancesPage()
	{
		PageFactory.initElements(driver, this);
	}
}