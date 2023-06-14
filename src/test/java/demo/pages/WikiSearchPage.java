package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * https://en.wikipedia.org/wiki/Peace
 */
public class WikiSearchPage extends BasePage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='Article']")
	private WebElement articleLink;

	@FindBy(xpath = ".//div[@id='simpleSearch']/input[1]")
	private WebElement searchBox;

	@FindBy(xpath = "//*[@id='searchform']/div/button")
	private WebElement searchButton;
	
	public WikiSearchPage(WebDriver driver)  {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isElementPresent(articleLink);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void setTextInSearchBox(String text) {
		sendKeys(searchBox, text);
	}
	
	public boolean isSearchButtonPresent() {
		return isElementPresent(searchButton);
	}
}
