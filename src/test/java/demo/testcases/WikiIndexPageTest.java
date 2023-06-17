package demo.testcases;


import demo.pages.WikiIndexPage;
import demo.pages.WikiMainPage;
import demo.utils.logs.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static demo.utils.extentreports.ExtentTestManager.startTest;

public class WikiIndexPageTest extends BaseTest {

	WikiIndexPage wikiIndexPage;
	WikiMainPage wikiMainPage;
	
	//Index > Main Page
	@Test(priority = 0, description = "Index Page Test Method")
	public void verifyEnglishLinkAndMore123(Method method) throws InterruptedException {
		//ExtentReports Method
		startTest(method.getName(), "Method Description will come here - index Page");
		
		System.out.println("Index Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
		Log.info(">>> Index Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
		getDriver().get("https://www.wikipedia.org/");
		//getDriver().manage().window().maximize();
		Thread.sleep(2000);
		//getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//initialize Index page with driver
		wikiIndexPage = new WikiIndexPage(getDriver());
		wikiIndexPage.clickEnglish();
		Thread.sleep(2000);
	
		//initialize Main page with driver
		wikiMainPage = new WikiMainPage(getDriver());
		String currentUrlHomePage = wikiMainPage.getCurrentUrl();
		Thread.sleep(2000);
		Assert.assertTrue(currentUrlHomePage.endsWith("wiki/Main_Page"), "Homepage title is wrong");
	}
	

}
