package com.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * https://en.wikipedia.org/wiki/Main_Page
 * 
 * @FindBys vs @FindAll
 * https://stackoverflow.com/questions/25914156/difference-between-findall-and-findbys-annotations-in-webdriver-page-factory
 */
public class WikiMainPage extends BasePage {

	/**
	 * Page elements
	 */
	WebDriver driver;
	
	@FindBy(id = "Welcome_to_Wikipedia")
	public static WebElement welcomeLink;
	
	
	@FindBy(xpath = ".//div[@id='simpleSearch']/input[1]")
	public static WebElement searchBox;
	
	//OR Condition
	@FindAll({ 
		@FindBy(xpath = "//*[@id='searchform']/div/button"),
		@FindBy(linkText = "Search") 
	})
	public static WebElement searchButton;
	

	/**
	 * Page constructor to initialize driver
	 * verify any page element to make sure page has been loaded properly
	 */
	public WikiMainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isElementPresent(welcomeLink);
	}

	/**
	 * Actions methods
	 */
	public void clickSearchButton() {
		click(searchButton);
	}

	public void clickCompleteListLink() {
		//click(webElement);
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
