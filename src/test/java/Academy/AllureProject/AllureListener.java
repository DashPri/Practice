package Academy.AllureProject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {
	

	private static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();	
	}
	
	@Attachment
	public byte[] saveFailureScreenshot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTestLog(String message) {
		return message;	
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("I am on onTestFailurMethod..." + getTestMethodName(result));
		Object testClass = result.getInstance();
		WebDriver driver = BaseClass.getDriver();
		
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot Captured from Test Case..." + getTestMethodName(result));
			saveFailureScreenshot(driver);
			saveTestLog(getTestMethodName(result) + "Failed and Screenshot taken");
		}
	}

}
