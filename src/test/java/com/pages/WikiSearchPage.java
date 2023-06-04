package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * https://en.wikipedia.org/wiki/Peace
 */
public class WikiSearchPage extends BasePage {

	/**
	 * Page elements
	 */
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Article']")
	public static WebElement articleLink;


	@FindBy(xpath = ".//div[@id='simpleSearch']/input[1]")
	public static WebElement searchBox;

	@FindBy(xpath = "//*[@id='searchform']/div/button")
	public static WebElement searchButton;

	
	/**
	 * Page constructor to initialize driver
	 * verify any page element to make sure page has been loaded properly
	 */
	public WikiSearchPage(WebDriver driver) throws MalformedURLException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isElementPresent(articleLink);
	}

	/**
	 * Actions methods
	 */
	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickCompleteListLink() {
		//code
	}

	/**
	 * Getters
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Setters
	 */
	public void setTextInSearchBox(String text) {
		sendKeys(searchBox, text);
	}

	/**
	 * Verification methods
	 */
	public boolean isSearchButtonPresent() {
		return isElementPresent(searchButton);
	}
}
