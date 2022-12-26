package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy(xpath = "//*[@class='_2Xfa2_']")
	WebElement dashBoard;
	public boolean validateDashboard() 
	{
		return dashBoard.isDisplayed();
	}
 
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
}
