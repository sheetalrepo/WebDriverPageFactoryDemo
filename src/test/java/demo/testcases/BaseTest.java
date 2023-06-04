package demo.testcases;

import demo.helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeTest
    public void Setup(){
        WebDriver driver = DriverFactory.createInstance("chrome");
        threadLocalDriver.set(driver);  // Set Thread
        System.out.println("BaseTest > @BeforeTest > Thread ID: "+Thread.currentThread().getId());
    }

    //Get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    @AfterTest
    public void tearDown(){
        getDriver().quit();
        System.out.println("BaseTest > @AfterTest > Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
    }

}
