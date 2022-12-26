package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class ProfileDetailsPage extends BaseClass
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
	
	@FindBy(xpath = "(//*[@class='_3vhnxf'])[1]")
	private WebElement myProfile;
	public void myProfile() throws InterruptedException
	{
		myProfile.click();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//*[@name='firstName']")
	private WebElement uName;
	public String uNameTxt() throws InterruptedException
	{
		Thread.sleep(3000);
		return uName.getAttribute("name");
	}
	
	@FindBy(xpath = "//*[@name='lastName']")
	private WebElement lName;
	public String lNameTxt() throws InterruptedException
	{
		Thread.sleep(3000);
		return lName.getAttribute("name");
	}
	
	@FindBy(xpath = "//*[@class='_2Fn-Ln _2fnqkz _2hH1hC _2LcXZ- _3iI7Qn _3L7Pww']")
	private WebElement female;
	public String femaleTab() throws InterruptedException
	{
		Thread.sleep(3000);
		return female.getAttribute("class");
	}
	
	@FindBy(xpath = "//*[@name='email']")
	private WebElement email;
	public String emailTab() throws InterruptedException
	{
		Thread.sleep(3000);
		return email.getAttribute("name");
	}
	
	@FindBy(xpath = "//*[@name='mobileNumber']")
	private WebElement mobile;
	public String mobileNoTab() throws InterruptedException
	{
		Thread.sleep(3000);
		return mobile.getAttribute("name");
	}
	
	@FindBy(xpath = "//*[text()='Manage Addresses']")
	private WebElement address;
	public void addressTab() throws InterruptedException
	{
		Thread.sleep(3000);
		Actions act = new Actions(driver);
        act.moveToElement(address).click().build().perform();
        Thread.sleep(5000);
	}
	
	@FindBy(xpath = "//*[@class='_26SF1Q']//p")
	private WebElement addressDetails;
	public String addressDetailsTab() throws InterruptedException
	{
		return addressDetails.getAttribute("class");
	}
	
	public ProfileDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
}