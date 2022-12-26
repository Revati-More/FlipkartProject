package com.qa.flipkart.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.flipkart.baseclass.BaseClass;

public class TestNGListeners extends BaseClass implements ITestListener
{
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test started : " + result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test is successful : " + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Failed :" + result.getName() + " Please check the screenshot");
	    
        try {
        	Screenshots.failedTestScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test started : " + result.getName());
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}
	
	@Override
	public void onStart(ITestContext context) 
	{
		
	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Test completed : ");
	}
}
	