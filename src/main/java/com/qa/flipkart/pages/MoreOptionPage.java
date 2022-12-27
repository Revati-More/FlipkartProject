package com.qa.flipkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class MoreOptionPage extends BaseClass {
	
	@FindBy(xpath = "//*[@class='_2MlkI1']")
	private WebElement loginWindow;
	public boolean loginWindow() throws InterruptedException
	{
		Thread.sleep(3000);
		return loginWindow.isDisplayed();
	}
	
	@FindBy(xpath = "//*[@class='_2KpZ6l _2doB4z']")
	private WebElement closeTab;
	public void closeTab() throws InterruptedException
	{
		Thread.sleep(3000);
		closeTab.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//*[@class='_28p97w'])[2]")
	private WebElement moreOption;

	public void moreOption() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(moreOption).perform();
		Thread.sleep(5000);
	}

	@FindBy(xpath = "(//*[@class='_3vhnxf'])[2]")
	private WebElement customerCare;

	public void customerCare() throws InterruptedException {
		customerCare.click();
		Thread.sleep(5000);
	}

	@FindBy(xpath = "(//*[@class='ogkecu A2ZSS0'])[3]")
	private WebElement helpIssues;

	public void helpIssues() throws InterruptedException {
		helpIssues.click();
		Thread.sleep(5000);
	}

	@FindBy(xpath = "//*[@class='_3KzYy1 _13AyN6']")
	private WebElement msg;

	public String msgDisp() throws InterruptedException {
		return msg.getAttribute("class");
	}

	public void listOfMsgs() throws InterruptedException 
	{
		List<WebElement> listOfMsg = driver.findElements(By.xpath("//*[@class='_3bBK6b']"));
	
		for(int i=1;i<listOfMsg.size();i++)
		{
			if(listOfMsg.get(i).getAttribute("class").equals("_3bBK6b"))
			{
				System.out.println(listOfMsg.get(i).isDisplayed());
			}
			else
			{
				System.out.println(listOfMsg.get(i) + " Element not present");
			}
			
		}
		Thread.sleep(5000);
	}
	
	public MoreOptionPage() {
		PageFactory.initElements(driver, this);
	}
}
