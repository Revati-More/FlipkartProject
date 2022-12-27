package com.qa.flipkart.baseclass;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
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
	
	private static Logger log = Logger.getLogger(BaseClass.class);
	
	public BaseClass()
	{
		Layout layout = new PatternLayout("%C - %M - %m - %n");
		Appender app = new ConsoleAppender(layout);
		log.addAppender(app);
		
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
		
		log.info("Launching browser");
		driver.get(prop.getProperty("url"));
		log.warn("Flipkart URL has been launched");
		
		String title = driver.getTitle();
		log.error("Title is " + title);
	}
}