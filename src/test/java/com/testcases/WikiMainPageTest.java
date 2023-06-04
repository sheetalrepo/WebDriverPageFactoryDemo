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
import com.pages.WikiMainPage;

public class WikiMainPageTest {

	WebDriver driver;
	Map<String, String> map;

	BasePage basePage;
	WikiIndexPage wikiIndexPage;
	WikiMainPage wikiHomePage;
	Logger log = Logger.getLogger(WikiMainPageTest.class);

	@BeforeClass
	public void init() throws IOException {
		basePage = BasePage.getInstance();

		//driver = basePage.getDriver();
		driver = basePage.getDriverNew();
		
		map = basePage.getProperties();
		System.out.println("Main: "+Thread.currentThread().getName());
		System.out.println("Main: "+driver.hashCode());
	}

	@AfterClass
	public void tearDown() {
		//basePage.close();
		basePage.quit();
	}
	

	@Test
	public void two(){
		System.out.println("Two");
		basePage.get("https://www.yahoo.com/?guccounter=1");
	}

	//@Test
	public void verifyLink() throws InterruptedException, IOException {
		log.info("|| Wiki Home page > method 1, thread : " + Thread.currentThread().getName());

		basePage.get(map.get("server"));
		driver.manage().window().maximize();
		
		//initialize Index page with driver
		wikiIndexPage = new WikiIndexPage(driver);
		wikiIndexPage.clickEnglish();

		//initialize Main page with driver
		wikiHomePage = new WikiMainPage(driver);
		String className = wikiHomePage.getAttributeValue(WikiMainPage.welcomeLink, "class");
		Assert.assertTrue(className.contains("mw-headline"), "wrong className");
	}





}
