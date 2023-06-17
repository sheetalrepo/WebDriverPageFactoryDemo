package demo.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static demo.utils.extentreports.ExtentTestManager.startTest;

/**
 * New class using Extent Report
 * Retry working fine
 * 
 * This class using code from demo/utils/listeners
 * 
 * demo_list_extent.xml
 */
public class ListenerTestCaseNew extends BaseTest {

    WebDriver driver;
    int i = 0;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }

    @Test(priority = 0, description = "Twitter Test Method")
    public void testTwitter(Method method){
        //ExtentReports Method
        startTest(method.getName(), "Method Description will come here - Twitter");
        
        driver.get("https://twitter.com/login");
        System.out.println("URL: "+driver.getCurrentUrl());
        Assert.assertTrue(true);
    }

    @Test(priority = 0, description = "Test Orkut Method")
    public void testOrkut(Method method) {
        //ExtentReports Method
        startTest(method.getName(), "Method Description will come here - Orkut");

        driver.get("http://www.orkut.com/index.html");
        Assert.assertTrue(false); //Always fails
    }


    @Test(priority = 0, description = "Test Retry Method")
    public void testRetryListener(Method method) throws InterruptedException {
        //ExtentReports Method
        startTest(method.getName(), "Method Description will come here - RetryMe");

        i++;
        if (i == 3 ){
            driver.get("https://twitter.com/login");
            System.out.println("URL: "+driver.getCurrentUrl());
            Assert.assertTrue(true);
        }else{
            driver.get("https://www.bing.com/");
            System.out.println("URL: "+driver.getCurrentUrl());
            Thread.sleep(2000);
            Assert.assertTrue(false);
        }
    }
    
}
