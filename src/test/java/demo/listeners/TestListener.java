package demo.listeners;

import demo.testcases.BaseTest;
import demo.utils.extentreports.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("### Test Listener > Test Failed > Screenshot captured @ resource/screenshots");
		String testClassRaw = result.getTestClass().toString().trim();
		String testClass = testClassRaw.substring(36, testClassRaw.length() - 1); 
		String testName = result.getName().toString().trim();
		
		try {
			BaseTest.getScreenshot(testClass, testName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * In case a class has total 2 cases and first one retry 5 times using Retry listeners then 
	 * result show that total case run: 7, fail: 1, skip: 5
	 * If we want to hide skipped cases and report should show only passed or failed case then 
	 * following hack can be used
	 * todo: not working, it worked in some project
	 */
	public void onFinish(ITestContext context) {
		
//		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
//		System.out.println("Failed Test Count:  "+ failedTests.size());
//		
//		for (ITestResult temp : failedTests) {
//			System.out.println("FOR LOOP");
//			ITestNGMethod method = temp.getMethod();
//			if (context.getFailedTests().getResults(method).size() > 1) {
//				System.out.println("IF LOOP");
//				failedTests.remove(temp);
//			} else {
//				System.out.println("ELSE LOOP");
//				if (context.getPassedTests().getResults(method).size() > 0) {
//					System.out.println("ELSE IF LOOP");
//					failedTests.remove(temp);
//				}
//			}
//		}
	}
	

}
