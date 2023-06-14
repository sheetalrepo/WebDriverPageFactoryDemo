package demo.testcases;

import demo.pages.GooglePage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class GooglePageTest extends BaseTest{
    @Test
    public void googleTest() throws InterruptedException {
        Logger log = Logger.getLogger(GooglePageTest.class);
        BasicConfigurator.configure();
        log.info(">>>>>>>>>>>>>>>>>>>>>..");
        System.out.println("Google Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
        getDriver().get("https://www.google.es/");
        Thread.sleep(3000);
    }

}
