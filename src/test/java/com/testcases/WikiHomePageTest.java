package com.testcases;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.BasePage;
import com.pages.WikiIndexPage;
import com.pages.WikiHomePage;

public class WikiHomePageTest {

	WebDriver driver;
	Map<String, String> map;

	BasePage basePage;
	WikiIndexPage wikiIndexPage;
	WikiHomePage wikiHomePage;
	Logger log = Logger.getLogger(WikiHomePageTest.class);

	@BeforeClass
	public void init() throws IOException {
		log.info("|| WikiHomePageTest Before Class, thread: " + Thread.currentThread().getName());

		basePage = BasePage.getInstance();
		driver = basePage.getDriver();
		map = basePage.getProperties();
		log.debug("News driver hashcode: " + driver.hashCode());
	}

	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		basePage.quit();
	}


	@Test
	public void verifyDonateLink() throws InterruptedException, IOException {
		log.info("|| Wiki Home page > method 1, thread : " + Thread.currentThread().getName());

		basePage.get(map.get("server"));

		wikiIndexPage = new WikiIndexPage(driver);
		wikiIndexPage.clickEnglish();

		wikiHomePage = new WikiHomePage(driver);
		String href = wikiHomePage.getAttributeValue(WikiHomePage.donateToWikiLink, "href");
		Assert.assertTrue(href.contains("donate.wikimedia.org"), "wrong donate link on wiki home page");

		// for demo only
		Thread.sleep(3000);
	}
	
	
}
