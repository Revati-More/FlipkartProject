package com.qa.flipkart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class ProductOutOfStockPage extends BaseClass
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
        act.moveToElement(searchButton).click().sendKeys(prop.getProperty("product")).click().build().perform();
        driver.findElement(By.xpath("//*[@class='L0Z3Pu']")).click();
        Thread.sleep(5000);
	}

	
	public void outOfStockProducts() throws InterruptedException 
	{
		List<WebElement> outOfStock = driver.findElements(By.xpath("//*[@alt='OnePlus 10R 5G (Forest Green, 128 GB)']"));
		outOfStock.size();
		for(int i=0;i<=outOfStock.size()-1;i++)
		{
			if(outOfStock.get(i).getAttribute("alt").contains("OnePlus 10R 5G (Forest Green, 128 GB"))
			{
				outOfStock.get(i).click();
				System.out.println("Product is unavailable");
				break;
			}
			else
			{
				outOfStock.get(i).click();
				System.out.println("Product is available");
			}
		}
		Thread.sleep(20000);
	}

	@FindBy(xpath = "//*[@class='_2KpZ6l _2uS5ZX _2Dfasx']")
	private WebElement notifyMe;
	public boolean notifyMeBtn() throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
		ArrayList obj = new ArrayList(windows);
		driver.switchTo().window((String) obj.get(1));
	
		Thread.sleep(10000);
		return notifyMe.isDisplayed();
	}
	
	@FindBy(xpath = "//*[text()='Sold Out']")
	private WebElement soldOut;
	public String soldOutTxt() throws InterruptedException
	{
		Thread.sleep(5000);
		return soldOut.getText();
	}
	
	@FindBy(xpath = "//*[text()='Share']")
	private WebElement shareOption;
	public void shareOption() throws InterruptedException
	{
		shareOption.click();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "(//*[@class='_21wwb0'])[1]")
	private WebElement facebookOption;
	public void facebookBtn() throws InterruptedException
	{	
		Thread.sleep(3000);
		Actions act = new Actions(driver);
        act.moveToElement(facebookOption).click().build().perform();
        Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//*[@id='email']")
	private WebElement emailId;
	public void emailIdTab() throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
		ArrayList obj = new ArrayList(windows);
		driver.switchTo().window((String) obj.get(2));
		
		Thread.sleep(3000);
		emailId.sendKeys(prop.getProperty("emailId"));
		Thread.sleep(5000);
	}
	
	@FindBy(xpath = "//*[@id='pass']")
	private WebElement password;
	public void passwordTab() throws InterruptedException
	{
		Thread.sleep(3000);
		password.sendKeys(prop.getProperty("pwd"));
		Thread.sleep(5000);
	}
	
	@FindBy(xpath = "//*[@name='login']")
	private WebElement login;
    public void loginTab() throws InterruptedException
	{
    	Thread.sleep(5000);
		login.click();
		Thread.sleep(5000);
	}
    
    @FindBy(xpath = "//*[@name='xhpc_message_text']")
    private WebElement aboutProduct;
    public void aboutProductTxt() throws InterruptedException
    {
    	Thread.sleep(5000);
    	aboutProduct.sendKeys(prop.getProperty("prodDetails"));
    	Thread.sleep(5000);
    }
	
    @FindBy(xpath = "//*[@name='__CONFIRM__']")
    private WebElement postBtn;
    public void postTab() throws InterruptedException
    {
    	Thread.sleep(5000);
    	postBtn.click();
    	Thread.sleep(5000);
    }
    
    @FindBy(xpath = "//*[@class='_2xm1JU']")
	private WebElement homePage;
	public void redirectToHomePage() throws InterruptedException
	{
		Set<String> windows = driver.getWindowHandles();
		ArrayList obj = new ArrayList(windows);
		driver.switchTo().window((String) obj.get(0));
		
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
	
	public ProductOutOfStockPage()
	{
		PageFactory.initElements(driver, this);
	}
}
