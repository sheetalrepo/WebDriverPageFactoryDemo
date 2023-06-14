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
	private WebElement english;
	
	@CacheLookup
	@FindBy (linkText="Italiano")
	private WebElement italiano;
	
	@FindBy (id="searchInput")
	private WebElement searchBox;
	
	@FindBy(xpath=".//form[@id='search-form']/fieldset/button")
	private WebElement searchBoxButton;
	
	public MSNPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("MSN Page Initialized......");
		//isElementPresent(english);
	}

	
}
