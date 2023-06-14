package demo.testcases;


import demo.pages.WikiIndexPage;
import demo.pages.WikiMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class WikiIndexPageTest extends BaseTest {

	WikiIndexPage wikiIndexPage;
	WikiMainPage wikiMainPage;
	
	//Index > Main Page
	@Test
	public void verifyEnglishLinkAndMore() throws MalformedURLException, InterruptedException {
		System.out.println("Index Test: "+Thread.currentThread().getId() + "  |  Driver hashCode: "+ getDriver().hashCode());
		
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
