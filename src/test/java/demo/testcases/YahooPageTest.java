package demo.testcases;

import demo.pages.YahooPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class YahooPageTest extends BaseTest{

    @Test
    public void yahooTest() throws InterruptedException {
        System.out.println("Yahoo Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());

        getDriver().get("https://www.yahoo.com/?guccounter=1");
        Thread.sleep(3000);
        
    }

}
