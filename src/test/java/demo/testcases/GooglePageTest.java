package demo.testcases;

import org.testng.annotations.Test;

public class GooglePageTest extends BaseTest{
    @Test
    public void googleTest() throws InterruptedException {
        System.out.println("Google Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
        getDriver().get("https://www.google.es/");
        Thread.sleep(3000);
    }

}
