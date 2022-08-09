package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import basePackage.Base;


public class Listener extends Base implements ITestListener
{
	
public void onTestSkipped(ITestResult result) 
{
	String skip = result.getName();
	System.out.println(skip);
	try {
		takeScreenShot(skip);
	} 
	catch (IOException e) 
	{
		
		e.printStackTrace();
	}
}
public void onTestFailure(ITestResult result)
{
		String TCName1 = result.getName();
		try {
			takeScreenShot(TCName1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
public void onTestSuccess(ITestResult result) 
{
		System.out.println("test successfully"+result.getName());
	}
}
