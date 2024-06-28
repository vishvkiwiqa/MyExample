package com.kiwiqa.extentreportspark;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;



public class TestListener extends ExtentReportExample implements ITestListener {
    
	
    @Override
    public void onTestStart(ITestResult result) {
       
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
    
    	ScreenshotUtil.takeScreenshot(driver,"Pass");
    	
		test.addScreenCaptureFromPath("./screenshots/Pass.png");
        
    }

    @Override
    public void onTestFailure(ITestResult result) 
    {
      
    	ScreenshotUtil.takeScreenshot(driver,"Fail");
    
    	test.log(Status.FAIL, result.getThrowable());
   
		test.addScreenCaptureFromPath("./screenshots/Fail.png");
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
       
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext context)
    {
        // Not implemented
    }

  

   
}
