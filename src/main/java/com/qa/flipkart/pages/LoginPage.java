package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class LoginPage extends BaseClass
{	
	@FindBy(xpath = "//*[@class='_3wFoIb row']")
	WebElement signInWindow;
	public String validateSignInWindow()
	{
		return signInWindow.getAttribute("class");
	}

	@FindBy(xpath = "//*[text()='New to Flipkart? Create an account']")
	WebElement newFlipkartAccount;
	public String createNewFlipkartAccount()
	{
		return newFlipkartAccount.getAttribute("text");
	}

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
	
	@FindBy(xpath = "//*[@class='_2QKxJ- _2_DUc_']")
	WebElement forgotTab;
	public String forgotLink()
	{
		return forgotTab.getAttribute("class");
	}

	@FindBy(xpath = "//*[@class='_2KpZ6l _2HKlqd _3NgS1a']")
	WebElement requestOTP;
	public String validaterequestOTP()
	{
		return requestOTP.getAttribute("class");
	}
	
	@FindBy(xpath = "//*[@class='_1Ijv5h']")
	WebElement termsAndConditions;
	public String validatetermsAndConditions()
	{
		return termsAndConditions.getAttribute("class");
	}
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
}