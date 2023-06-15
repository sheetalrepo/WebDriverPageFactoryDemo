package demo.utils.listeners;

import com.aventstack.extentreports.Status;
import demo.helper.PropertyFileReader;
import demo.testcases.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import static demo.utils.extentreports.ExtentTestManager.getTest;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    //private static int maxTry = 5; //Run the failed test 5 times
    PropertyFileReader obj = new PropertyFileReader();
    @Override
    public boolean retry(ITestResult iTestResult) {
        //Reading retry count from config.properties file
        int maxTry = Integer.parseInt(obj.getPropertyMap().get("failed_case_retry_count"));
        
        if (!iTestResult.isSuccess()) {                     //Check if test not succeed
            if (count < maxTry) {                           //Check if maxTry count is reached
                count++;                                    //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE); //Mark test as failed and take base64Screenshot
                extendReportsFailOperations(iTestResult);   //ExtentReports fail operations
                return true;                                //Tells TestNG to re-run the test
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);     //If test passes, TestNG marks it as passed
        }
        return false;
    }

    public void extendReportsFailOperations(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, "Test Failed",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }
}