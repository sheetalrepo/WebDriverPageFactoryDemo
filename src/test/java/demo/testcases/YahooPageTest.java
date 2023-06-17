package demo.testcases;

import demo.utils.logs.Log;
import org.testng.annotations.Test;
;import java.lang.reflect.Method;

import static demo.utils.extentreports.ExtentTestManager.startTest;

public class YahooPageTest extends BaseTest{

    @Test(priority = 0, description = "Yahoo Test Method")
    public void yahooTest(Method method) throws InterruptedException {
        //ExtentReports Method
        startTest(method.getName(), "Method Description will come here - Yahoo");

        System.out.println("Yahoo Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
        Log.info(">>> Yahoo Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());

        getDriver().get("https://www.yahoo.com/?guccounter=1");
        Thread.sleep(3000);
        
    }

}
