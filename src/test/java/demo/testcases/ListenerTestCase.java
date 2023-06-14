package demo.testcases;

import demo.listeners.Retry;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListenerTestCase extends BaseTest {

    WebDriver driver;
    int i = 0;

    @BeforeClass
    public void setup() {
        driver = getDriver();
    }
    
    @Test(retryAnalyzer = Retry.class )
    public void testRetryListener() throws InterruptedException {
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


    @Test(retryAnalyzer = Retry.class )
    public void testOrkut() {
        driver.get("http://www.orkut.com/index.html");
        Assert.assertTrue(false); //Always fails
    }

}
