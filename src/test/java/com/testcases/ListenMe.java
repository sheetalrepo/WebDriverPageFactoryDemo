package com.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BasePage;

public class ListenMe {

	WebDriver driver;
	BasePage basePage;
	int i = 0;

	@BeforeClass
	public void setup() throws MalformedURLException {
		basePage = BasePage.getInstance();
		driver = basePage.getDriver();
	}

	@AfterClass
	public void tearDown() throws InterruptedException, IOException {
		System.out.println("Base instance value: "+basePage);
		basePage.quit();
	}

	@Test
	public void testRetryListener() throws InterruptedException {
		i++;
		if (i == 3 ){
			driver.get("https://twitter.com/login");
			Assert.assertTrue(true);
		}else{
			driver.get("https://www.bing.com/");
			Thread.sleep(2000);
			Assert.assertTrue(false);			
		}
	}
	
	
	//@Test
	public void testListenersOnFailure() {
		driver.get("http://www.orkut.com/index.html");
		Assert.assertTrue(false);
	}

}
