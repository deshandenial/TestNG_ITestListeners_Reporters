package com.TestNG_ITestListenerReporters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener extends TestClass implements ITestListener

{
	public static String filePath_fail = System.getProperty("user.dir")+"\\src\\test\\java\\com\\TestNG_ITestListeners_FailedScreenshots\\";
	public static String reportsPath_fail="";
	
	public static String filePath_success = System.getProperty("user.dir")+"\\src\\test\\java\\com\\TestNG_ITestListeners_SuccessScreenshots\\";
	public static String reportsPath_success="";
	
	public static String filePath_skip = System.getProperty("user.dir")+"\\src\\test\\java\\com\\TestNG_ITestListeners_SkippedScreenshots\\";
	public static String reportsPath_skip="";
	
	
	public static String methodName;
	
	
	
	public void onFinish(ITestContext arg0)
	{
		System.out.println("End Of Execution(TEST)->"+arg0.getName());
		
		
	}

	public void onStart(ITestContext arg0)
	{
		System.out.println("start Of Execution(TEST)->"+arg0.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}
	
	
	
public void onTestFailure(ITestResult result) 
	{
	

	System.out.println("Test Fail->"+result.getName());
		
		
		
	}
	
// failed test case take screen shots

public static String TakeFailedScreenShot(String methodName)
{
   	
   	
   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name 
           try 
           {
           	reportsPath_fail=filePath_fail+methodName+"-"+timestamp()+".png";
           	
				FileUtils.copyFile(scrFile, new File(reportsPath_fail));
				
				System.out.println("***Placed screen shot in "+filePath_fail+" ***");
			} 
           catch (IOException e) 
           {
				e.printStackTrace();
			}
			return reportsPath_fail;
   }

//Success test case take screen shots

public static String TakeSuccessScreenShot(String methodName)
{
   	
   	
   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name 
           try 
           {
           	reportsPath_success=filePath_success+methodName+"-"+timestamp()+".png";
           	
				FileUtils.copyFile(scrFile, new File(reportsPath_success));
				
				System.out.println("***Placed screen shot in "+filePath_success+" ***");
			} 
           catch (IOException e) 
           {
				e.printStackTrace();
			}
			return reportsPath_success;
   }

//Skipped test case take screen shots

public static String TakeSkippedScreenShot(String methodName)
{
 	
 	
 	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //The below method will save the screen shot in d drive with test method name 
         try 
         {
         	reportsPath_skip=filePath_skip+methodName+"-"+timestamp()+".png";
         	
				FileUtils.copyFile(scrFile, new File(reportsPath_skip));
				
				System.out.println("***Placed screen shot in "+filePath_skip+" ***");
			} 
         catch (IOException e) 
         {
				e.printStackTrace();
			}
			return reportsPath_skip;
 }



private static String timestamp() 
{
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}
	
	
	
	
	
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test Skip->"+result.getName());
		
		
	}

	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test Started->"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Pass->"+result.getName());
		
		
	}
  

}
