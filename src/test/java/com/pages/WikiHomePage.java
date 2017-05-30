package com.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage extends BasePage {

	/**
	 * Page elements
	 */
	WebDriver driver;

	@FindBy(xpath = ".//div[@id='simpleSearch']/input[1]")
	public static WebElement searchBox;
	
	//OR Condition
	@FindAll({ 
		@FindBy(id = "searchButton"),
		@FindBy(css = "#searchButton") 
	})
	public static WebElement searchButton;

	@FindBy(xpath = ".//li[@id='interwiki-completelist']/a")
	public static WebElement completeListLeftLink; // left nav column > bottom side

	@FindBy(linkText = "Donate to Wikipedia")
	public static WebElement donateToWikiLink;

	public WikiHomePage(WebDriver driver) throws MalformedURLException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isElementPresent(searchBox);
	}

	/**
	 * Actions methods
	 */
	public void clickSearchButton() {
		click(searchButton);
	}

	public void clickCompleteListLink() {
		click(completeListLeftLink);
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
	public boolean isSomeDummyElementPresent() {
		return true;
	}
}
