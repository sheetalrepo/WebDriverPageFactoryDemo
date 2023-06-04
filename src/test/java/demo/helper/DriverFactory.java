package demo.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
       if(browserName.toLowerCase().contains("chrome")){
            //String path = System.getProperty("user.dir");
            //System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver3");
            return new ChromeDriver();
        }else{
           System.out.println("Only work for chrome");
        }
        return driver;
    }
}
