package demo.testcases;

import demo.pages.GooglePage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class GooglePageTest extends BaseTest{

    @Test
    public void googleTest() throws InterruptedException {
        System.out.println("Google Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());

        getDriver().get("https://www.google.es/");
        Thread.sleep(3000);
    }

}
