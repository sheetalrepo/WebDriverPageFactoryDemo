package com.testcases;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.BasePage;
import com.pages.WikiIndexPage;
import com.pages.WikiHomePage;

public class WikiIndexPageTest {

	WebDriver driver;
	Map<String, String> map;

	BasePage basePage;
	WikiIndexPage wikiIndexPage;
	WikiHomePage wikiHomePage;
	Logger log = Logger.getLogger(WikiIndexPageTest.class);
	
	
	@BeforeClass
	public void init() throws IOException{
		PropertyConfigurator.configure("log4j.properties");
		log.info("|| WikiIndexPageTest Before Class, thread: " + Thread.currentThread().getName());
		
		basePage = BasePage.getInstance();
		driver = basePage.getDriver();
		map = basePage.getProperties();
		log.debug("Driver hashcode: "+driver.hashCode());
	}

	
	@AfterClass
	public void tearDown() throws InterruptedException, IOException{
		basePage.quit();
	}

	
	@Test
	public void verifyEnglishLink() throws InterruptedException, IOException {
		log.info("|| Wiki Index page > method 1, thread : " + Thread.currentThread().getName());
		
		basePage.get(map.get("server"));
		
		//initialize Index page with driver
		wikiIndexPage = new WikiIndexPage(driver);
		wikiIndexPage.clickEnglish();

		//initialize Home page with driver
		wikiHomePage = new WikiHomePage(driver);
		String currentUrlHomePage = wikiHomePage.getCurrentUrl();

		Assert.assertTrue(currentUrlHomePage.endsWith("wiki/Main_Page"), "Homepage title is wrong");
	}
	
	
	@Test
	public void verifySearchBox() throws InterruptedException, IOException {
		log.info("|| Wiki Index page, thread > method 2, thread : " + Thread.currentThread().getName());
		
		basePage.get(map.get("server"));

		wikiIndexPage = new WikiIndexPage(driver);
		wikiIndexPage.setTextInSearchBox("peace");
		wikiIndexPage.clickSearchBoxButton();
		
		wikiHomePage = new WikiHomePage(driver);
		String currentUrlHomePage = wikiHomePage.getCurrentUrl();
		
		Assert.assertTrue(currentUrlHomePage.endsWith("wiki/Peace"), "title mismatch");
	}
	
	
	
	
}
