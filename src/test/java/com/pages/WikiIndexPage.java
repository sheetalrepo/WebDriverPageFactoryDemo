package com.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Index Page: https://www.wikipedia.org/
 */
public class WikiIndexPage extends BasePage{

	
	/**
	 * Page elements
	 */
	
	WebDriver driver;
	
	@FindBy(xpath="//strong[contains(text(),'English')]")
	public static WebElement english;
	
	@CacheLookup
	@FindBy (linkText="Italiano")
	public static WebElement italiano;
	
	@FindBy (id="searchInput")
	public static WebElement searchBox;
	
	@FindBy(xpath=".//form[@id='search-form']/fieldset/button")
	public static WebElement searchBoxButton;
	
	public WikiIndexPage(WebDriver driver) throws MalformedURLException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isElementPresent(english);
	}
	

	/**
	 * Actions methods
	 */
	
	public void clickEnglish(){
		click(english);
	}
	
	
	public void clickItalino(){
		click(italiano);
	}
	
	public void clickSearchBoxButton(){
		click(searchBoxButton);
	}
	
	
	/**
	 * Getters
	 */

	
	
	/**
	 * Setters
	 */
	public void setTextInSearchBox(String keyword){
		sendKeys(searchBox, keyword);
	}
	
	/**
	 * Verification methods
	 */
	public boolean isSomeDummyElementPresent() {
		return true;
	}
	
	
}
