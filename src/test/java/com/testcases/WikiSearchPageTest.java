package com.testcases;

import com.pages.BasePage;
import com.pages.WikiIndexPage;
import com.pages.WikiMainPage;
import com.pages.WikiSearchPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class WikiSearchPageTest {

	WebDriver driver;
	Map<String, String> map;

	BasePage basePage;
	WikiIndexPage wikiIndexPage;
	WikiMainPage wikiMainPage;
	WikiSearchPage wikiSearchPage;
	Logger log = Logger.getLogger(WikiSearchPageTest.class);
	
	
	@BeforeClass
	public void init() throws IOException{
		basePage = BasePage.getInstance();
		
		//driver = basePage.getDriver();
		driver = basePage.getDriverNew();
		
		map = basePage.getProperties();
		System.out.println("Search: "+Thread.currentThread().getName());
		System.out.println("Search: "+driver.hashCode());
	}


	@AfterClass
	public void tearDown() {
		//basePage.close();
		basePage.quit();
	}


	@Test
	public void three(){
		System.out.println("Three");
		basePage.get("https://www.msn.com/es-es?bundles=staging");
	}
	
	//Index > Search Page
	//@Test
	public void verifySearchPage() throws IOException, InterruptedException {
		log.info("|| Wiki Index page, thread > method 2, thread : " + Thread.currentThread().getName());
		basePage.get(map.get("server"));
		driver.manage().window().maximize();
		
		//initialize Index page with driver
		wikiIndexPage = new WikiIndexPage(driver);
		wikiIndexPage.setTextInSearchBox("peace");
		wikiIndexPage.clickSearchBoxButton();
		
		//initialize Search page with driver
		wikiSearchPage = new WikiSearchPage(driver);
		String currentUrlSearchPage = wikiSearchPage.getCurrentUrl();
		Assert.assertTrue(currentUrlSearchPage.endsWith("wiki/Peace"), "title mismatch");
		
		Thread.sleep(2000);
		wikiSearchPage.setTextInSearchBox("Google");
		//Thread.sleep(2000);
		wikiSearchPage.isSearchButtonPresent();
		wikiSearchPage.clickSearchButton();
		String currentUrlSearchPage2 = wikiSearchPage.getCurrentUrl();
		Assert.assertTrue(currentUrlSearchPage2.endsWith("wiki/Google"), "title mismatch");
	}


	

}
