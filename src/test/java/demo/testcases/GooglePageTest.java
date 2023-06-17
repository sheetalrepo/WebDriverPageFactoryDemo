package demo.testcases;

import demo.utils.logs.Log;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static demo.utils.extentreports.ExtentTestManager.startTest;

public class GooglePageTest extends BaseTest{
    @Test(priority = 0, description = "Google Test Method")
    public void googleTest(Method method) throws InterruptedException {
        //ExtentReports Method
        startTest(method.getName(), "Method Description will come here - Google");

        System.out.println("Google Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
        Log.info(">>> Google Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
        getDriver().get("https://www.google.es/");
        Thread.sleep(3000);
    }

}
