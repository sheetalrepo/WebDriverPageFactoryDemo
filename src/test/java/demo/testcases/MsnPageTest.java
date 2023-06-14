package demo.testcases;

import org.testng.annotations.Test;

public class MsnPageTest extends BaseTest{

    @Test
    public void msnTest() throws InterruptedException {
        System.out.println("MSN Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());

        getDriver().get("https://www.msn.com/es-es?bundles=staging");
        Thread.sleep(3000);
        
    }

}
