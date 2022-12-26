package com.qa.flipkart.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.flipkart.baseclass.BaseClass;

public class TravelPage extends BaseClass
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
	
	@FindBy(xpath = "(//*[@class='eFQ30H'])[8]")
	WebElement selectTravel;
	public void validateTravel() throws InterruptedException 
	{
		Thread.sleep(2000);
		selectTravel.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "(//*[@class='_2jIO64 _3Y-Z5B'])[2]")
	WebElement roundTripBtn;
	public void roundTrip() throws InterruptedException 
	{
		Thread.sleep(2000);
		roundTripBtn.click();
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//*[@name='0-departcity']")
	WebElement selectFromCity;
	
	public void selectFromCity() throws InterruptedException 
	{
		selectFromCity.click();
		List<WebElement> cities = driver.findElements(By.xpath("//*[@class='_3uA4ax']"));
		cities.size();
		for(int i=0;i<=cities.size()-1;i++)
		{
			if(cities.get(i).getText().contains("Mumbai"))
			{
				cities.get(i).click();
				break;
			}
		}
        Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//*[@name='0-arrivalcity']")
	WebElement selectToCity;
	public void selectToCity() throws InterruptedException 
	{
		selectToCity.click();
		List<WebElement> cities = driver.findElements(By.xpath("//*[@class='_3uA4ax']"));
		cities.size();
		for(int i=0;i<=cities.size()-1;i++)
		{
			if(cities.get(i).getText().contains("Hyderabad"))
			{
				cities.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//*[@class='zzPDhz _1Jqgld'])[1]")
	private WebElement fromDate;
	@FindBy(xpath = "//table/tbody/tr/td/div/button")
	private List<WebElement> days;
	public void calendarVerfication() throws InterruptedException 
	{	
		fromDate.click();
		Thread.sleep(2000);

		DateFormat dateFormat = new SimpleDateFormat("dd");	
		Date newDate = new Date();
		String date1= dateFormat.format(newDate);
		String str=date1.substring(1); 
		
		for(int j=0; j<days.size(); j++)
		{
			if(days.get(j).isEnabled() && days.get(j).getText().equals(str))
			{
				days.get(j+2).click();
				Thread.sleep(1000);
				days.get(j+4).click();	
				Thread.sleep(1000);
		    }
		}
	}
	
	@FindBy(xpath = "//*[@class='_1w3ZZo zO-_Xz _2mFmU7']")
	private WebElement travellerClass;

	public void travellerVerfication()
	{
		try
		{
		Thread.sleep(2000);
		travellerClass.click();
		
		WebElement doneBtn = driver.findElement(By.xpath("//*[text()='Done']"));
		doneBtn.click();
		Thread.sleep(2000);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@FindBy(xpath = "//*[@class='_2KpZ6l _1QYQF8 _3dESVI']")
	private WebElement searchButton;
	public void btnClick() throws InterruptedException 
	{
		Actions act = new Actions(driver);
        act.moveToElement(searchButton).doubleClick().build().perform();
		Thread.sleep(15000);
	}
	
	public void checkCheapPrice() throws InterruptedException 
	{
		List<WebElement> price = driver.findElements(By.xpath("//*[contains(@class,'_2t8Dgm')]"));
		int[] intArray = new int[price.size()]; 
		
		for (int i=0; i<price.size(); i++)
		{
			for(int j = i + 1; j < price.size(); j++)
			{  
		       if(intArray[i] == intArray[j])  
		        System.out.print(intArray[j]) ;  
		    }  
			String str = price.get(i).getText();
			String str1 = str.replaceAll("[^a-zA-Z0-9]","");
			intArray[i]=Integer.parseInt(str1);
		}
		Arrays.sort(intArray);
		System.out.println("Cheapest flight is "+ intArray[0]);
		Thread.sleep(5000);
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
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(5000);
	}
	
	public TravelPage()
	{
		PageFactory.initElements(driver, this);
	}
}