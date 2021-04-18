package com.pages;

import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.DriverRepo;
import com.helper.PropertyFileReader;
import org.apache.commons.io.FileUtils;

/**
 * Common class for all web driver functions
 * 
 * @author sheetalsingh
 */
public class BasePage {

	static WebDriver driver = null;
	PropertyFileReader propertiesReader = null;
	Map<String, String> propertyMap;
	String driverToRun = null;
	Logger log = Logger.getLogger(BasePage.class);
	WebDriverWait wait;

	private static BasePage instance = null;

	/**
	 * log4j need to be initialized once
	 */
	public static BasePage getInstance() throws MalformedURLException {
		PropertyConfigurator.configure("log4j.properties");
		
		if(instance == null) {
			instance = new BasePage();
		}
		
		return instance;
	}

	/**
	 * This method will read properties from xyz.properties file and return a
	 * HashMap object with key, values pair
	 */
	public Map<String, String> getProperties() {
		if (propertiesReader == null) {
			propertiesReader = new PropertyFileReader();
		}
		propertyMap = propertiesReader.getPropertyMap();
		log.info("fetched all properties");
		return propertyMap;
	}

	public WebDriver getDriver() {
		String driverToRun = getProperties().get("driver");

		if (driverToRun.equals("firefox")) {
			driver = DriverRepo.FIREFOX.getDriver();
			return driver;
		} else if (driverToRun.equals("chrome")) {
			driver = DriverRepo.CHROME.getDriver();
			return driver;
		} else {
			driver = DriverRepo.FIREFOX.getDriver();
			return driver;
		}
	}

	/**
	 * Common explicit wait methods; Generic can be used be most of the cases
	 * todo: wait time need to be picked from properties file
	 */
	public void waitForVisibilityOfElement(WebElement element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(WebElement element) {
		waitForVisibilityOfElement(element);
		element.click();
	}

	public void sendKeys(WebElement element, String keyword) {
		waitForVisibilityOfElement(element);
		element.clear();
		element.sendKeys(keyword);
	}

	public boolean isPageLoaded(WebElement element) {
		waitForVisibilityOfElement(element);
		return element.isDisplayed();
	}

	public boolean isElementPresent(WebElement element) {
		waitForVisibilityOfElement(element);
		return element.isDisplayed();
	}

	public String getText(WebElement element) {
		waitForVisibilityOfElement(element);
		return element.getText();
	}

	public String getAttributeValue(WebElement element, String attribute) {
		waitForVisibilityOfElement(element);
		return element.getAttribute(attribute);
	}

	public void get(String url) {
		log.info("open url: " + url);
		driver.get(url);
	}

	public void quit() {
		log.info("quit application");
		driver.quit();
	}

	public void close() {
		log.info("close application");
		driver.close();
	}

	/**
	 * Need to pass driver, as null pointer coming in case we don't pass driver from
	 * TestListeners class
	 */
	public static String getScreenshot(String testclass, String testname) throws IOException {

		//log.info("taking screenshot for failed test case: " + testclass + "_" + testname);
		String filePath = "./src/test/resources/screenshots/";
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		String path = filePath + testclass + "_" + testname + "_" + timestamp;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(path + ".png"));
			//log.info("screenshot captured at: " + path + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path + ".png";
	}

}
