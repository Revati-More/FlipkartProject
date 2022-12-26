package com.qa.flipkart.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass
{
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass()
	{
		try {
			prop = new Properties();
			
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
					"/src/main/java/com/qa/flipkart/configuration/config.properties");
			 prop.load(file);
			}
		catch(IOException e)
			{
				System.out.println("File does not exist");
			}
	}
	
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));	
	}
}