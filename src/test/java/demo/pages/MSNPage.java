package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class MSNPage extends BasePage{

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
	
	public MSNPage(WebDriver driver) throws MalformedURLException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("MSN Page Initialized......");
		//isElementPresent(english);
	}

	
}
