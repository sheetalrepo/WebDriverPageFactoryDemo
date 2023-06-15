package demo.testcases;

import demo.helper.PropertyFileReader;
import demo.helper.DriverFactory;
import demo.utils.logs.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class BaseTest {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    PropertyFileReader propertiesReader = null;
    Map<String, String> propertyMap;

    //Logger log = Logger.getLogger(BaseTest.class);
    
    public Map<String, String> getProperties() {
        if (propertiesReader == null) {
            propertiesReader = new PropertyFileReader();
        }
        propertyMap = propertiesReader.getPropertyMap();
        //log.info("### Fetched All Properties");
        return propertyMap;
    }
    @BeforeTest
    public void Setup(){
        Log.info("@BeforeTest > Tests is starting");
        String browser = getProperties().get("driver");
        WebDriver driver = DriverFactory.createInstance(browser);
        threadLocalDriver.set(driver);  // Set ThreadLoacal with Driver
        System.out.println("BaseTest > @BeforeTest > Thread ID: "+Thread.currentThread().getId());
        //PropertyConfigurator.configure("log4j.properties");
    }

    //Get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    @AfterTest
    public void tearDown(){
        Log.info("@AfterTest > Tests is ending");
        getDriver().quit();
        System.out.println("BaseTest > @AfterTest > Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
    }

    /**
     * Need to pass driver, as null pointer coming in case we don't pass driver from
     * TestListeners class
     */
    public static String getScreenshot(String testclass, String testname) throws IOException {

        //log.info("taking screenshot for failed test case: " + testclass + "_" + testname);
        String filePath = "./src/test/resources/screenshots/";
        String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        String path = filePath + testclass + "_" + testname + "_" + timestamp;

        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(path + ".png"));
            //log.info("screenshot captured at: " + path + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path + ".png";
    }

}
