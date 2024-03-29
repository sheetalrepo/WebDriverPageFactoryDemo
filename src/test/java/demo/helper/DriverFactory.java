package demo.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
       if(browserName.toLowerCase().contains("chrome")){
            //Not required in updated Selenium version since version 4.5
            //String path = System.getProperty("user.dir");
            //System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver3");
            return new ChromeDriver();
        } else if (browserName.toLowerCase().contains("firefox")){
           return new FirefoxDriver();
       } else{
           System.out.println("Only work for chrome");
        }
        return driver;
    }
}
