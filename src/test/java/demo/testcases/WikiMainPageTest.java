package demo.testcases;

import demo.pages.WikiMainPage;
import demo.pages.WikiIndexPage;
import demo.utils.logs.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class WikiMainPageTest extends BaseTest {

	WikiIndexPage wikiIndexPage;
	WikiMainPage wikiMainPage;
	
	@Test
	public void verifyLink() throws IOException, InterruptedException {
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
