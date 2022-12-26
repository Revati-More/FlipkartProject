package com.qa.flipkart.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.baseclass.BaseClass;

public class Screenshots extends BaseClass
{
	  public static void failedTestScreenshot(String screenshotName) throws IOException 
	  {  
	    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(source, new File(".//screenshot/screen.png"));
	    }
	  
	  public Screenshots()
	  {
	    PageFactory.initElements(driver, this);
	  }
}
