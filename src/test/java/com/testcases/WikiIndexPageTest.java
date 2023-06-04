package com.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import com.helper.ThreadLocalDriver;
import com.pages.WikiSearchPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.BasePage;
import com.pages.WikiIndexPage;
import com.pages.WikiMainPage;

public class WikiIndexPageTest {

	WebDriver driver;
	Map<String, String> map;

	BasePage basePage;
	WikiIndexPage wikiIndexPage;
	WikiMainPage wikiMainPage;
	WikiSearchPage wikiSearchPage;
	Logger log = Logger.getLogger(WikiIndexPageTest.class);
	
	
	@BeforeClass
	public void init() throws IOException{
		PropertyConfigurator.configure("log4j.properties");
		log.info("|| WikiIndexPageTest Before Class, thread: " + Thread.currentThread().getName());
		
		basePage = BasePage.getInstance();
		
		//driver = basePage.getDriver();
		driver = basePage.getDriverNew();

		map = basePage.getProperties();
		System.out.println("Index: "+Thread.currentThread().getName());
		System.out.println("Index: "+driver.hashCode());
	}

	
	@AfterClass
	public void tearDown() {
		//basePage.close();
		basePage.quit();
		
	}

	@Test
	public void one(){
		System.out.println("One");
		basePage.get("https://www.google.es/");
	}

	//Index > Main Page
	//@Test
	public void verifyEnglishLinkAndMore() throws MalformedURLException, InterruptedException {
		log.info("|| Wiki Index page > method 1, thread : " + Thread.currentThread().getName());
		
		basePage.get(map.get("server"));
		driver.manage().window().maximize();
		
		//initialize Index page with driver
		wikiIndexPage = new WikiIndexPage(driver);
		wikiIndexPage.clickEnglish();
		Thread.sleep(2000);
		
		//initialize Main page with driver
		wikiMainPage = new WikiMainPage(driver);
		String currentUrlHomePage = wikiMainPage.getCurrentUrl();

		Assert.assertTrue(currentUrlHomePage.endsWith("wiki/Main_Page"), "Homepage title is wrong");
	}
	

}
