package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


/**
 * Common class for all web driver functions
 * 
 * @author sheetalsingh
 */
public class BasePage {
	WebDriverWait wait;
	WebDriver driver;
	
	BasePage(WebDriver driver){
		System.out.println("Base Page Initialized......");
		this.driver = driver;
	}
	
	/**
	 * Common explicit wait methods; Generic can be used be most of the cases
	 * todo: wait time need to be picked from properties file
	 */
	public void waitForVisibilityOfElement(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
		driver.get(url);
	}


	
}
