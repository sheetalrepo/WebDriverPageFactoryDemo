package demo.testcases;

import demo.pages.WikiIndexPage;
import demo.pages.WikiSearchPage;
import demo.utils.logs.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class WikiSearchPageTest extends BaseTest {
	WikiIndexPage wikiIndexPage;
	WikiSearchPage wikiSearchPage;
	
	//Index > Search Page
	@Test
	public void verifySearchPage() throws IOException, InterruptedException {
		System.out.println("Search Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
		Log.info("Search Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());

		getDriver().get("https://www.wikipedia.org/");
		getDriver().manage().window().maximize();

		//Initialize Index page with driver
		wikiIndexPage = new WikiIndexPage(getDriver());
		wikiIndexPage.setTextInSearchBox("peace");
		Thread.sleep(2000);
		wikiIndexPage.clickSearchBoxButton();

		//Initialize Search page with driver
		wikiSearchPage = new WikiSearchPage(getDriver());
		String currentUrlSearchPage = wikiSearchPage.getCurrentUrl();
		Assert.assertTrue(currentUrlSearchPage.endsWith("wiki/Peace"), "title mismatch");

		Thread.sleep(2000);
		wikiSearchPage.setTextInSearchBox("Google");
		wikiSearchPage.isSearchButtonPresent();
		wikiSearchPage.clickSearchButton();
		String currentUrlSearchPage2 = wikiSearchPage.getCurrentUrl();
		Assert.assertTrue(currentUrlSearchPage2.endsWith("wiki/Google"), "title mismatch");
	}

}
