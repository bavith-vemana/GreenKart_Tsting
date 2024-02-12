package Bavith.Tsting;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class lstners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	
	 @Override
	    public void onTestStart(ITestResult result) {
		 
		 
		 test = extent.createTest(result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	test.log(Status.PASS, "Passed");
	    	extent.flush();
	        
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	String path = null;
	    	
	    	try {
				path=GetScreenShot(result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	test.addScreenCaptureFromPath(path);
	    	
	    	test.fail("Its Failed");
	    	test.log(Status.FAIL, "Failed");
	    	extent.flush();
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	String path = null;
	    	
	    	try {
				path=GetScreenShot(result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	test.addScreenCaptureFromPath(path);
	    	
	    	test.fail("Its Failed");
	    	extent.flush();
	    	extent.flush();
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Not implemented in this example
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        
	    }

}
