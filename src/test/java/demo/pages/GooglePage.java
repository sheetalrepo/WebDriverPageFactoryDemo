package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class GooglePage extends BasePage{
	
	WebDriver driver;
	
	@FindBy(xpath="//strong[contains(text(),'English')]")
	public static WebElement english;
	
	public GooglePage(WebDriver driver) throws MalformedURLException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Google Page Initialized......");
		//isElementPresent(english);
	}

	
}
