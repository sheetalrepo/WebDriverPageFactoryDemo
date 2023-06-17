package demo.testcases;

import demo.pages.WikiMainPage;
import demo.pages.WikiIndexPage;
import demo.utils.logs.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;

import static demo.utils.extentreports.ExtentTestManager.startTest;

public class WikiMainPageTest extends BaseTest {

	WikiIndexPage wikiIndexPage;
	WikiMainPage wikiMainPage;

	@Test(priority = 0, description = "Main Page Test Method")
	public void verifyLink(Method method) throws InterruptedException {
		//ExtentReports Method
		startTest(method.getName(), "Method Description will come here - Main Page");

		System.out.println("Main Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
		Log.info(">>> Main Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());

		getDriver().get("https://www.wikipedia.org/");
		//getDriver().manage().window().maximize();

		//Initialize Index page with driver
		wikiIndexPage = new WikiIndexPage(getDriver());
		Thread.sleep(2000);
		wikiIndexPage.clickEnglish();

		//Initialize Main page with driver
		wikiMainPage = new WikiMainPage(getDriver());
		String className = wikiMainPage.getAttributeValue(wikiMainPage.getWelcomeLink(), "class");
		Assert.assertTrue(className.contains("mw-headline"), "wrong className");
	}

}
