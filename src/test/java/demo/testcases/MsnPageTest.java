package demo.testcases;

import demo.utils.logs.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static demo.utils.extentreports.ExtentTestManager.startTest;

public class MsnPageTest extends BaseTest{

    @Test(priority = 0, description = "MSN Test Method")
    public void msnTest(Method method) throws InterruptedException {
        //ExtentReports Method
        startTest(method.getName(), "Method Description will come here - MSN");

        System.out.println("MSN Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
        Log.info(">>> MSN Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());

        getDriver().get("https://www.msn.com/es-es?bundles=staging");
        Thread.sleep(3000);

        Assert.assertTrue(false);
    }

}
