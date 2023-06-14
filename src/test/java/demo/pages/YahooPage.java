package demo.pages;

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
public class YahooPage extends BasePage {
	WebDriver driver;
	
	@FindBy(id = "Welcome_to_Wikipedia")
	private WebElement welcomeLink;
	
	
	@FindBy(xpath = ".//div[@id='simpleSearch']/input[1]")
	private WebElement searchBox;
	
	//OR Condition
	@FindAll({ 
		@FindBy(xpath = "//*[@id='searchform']/div/button"),
		@FindBy(linkText = "Search") 
	})
	public static WebElement searchButton;
	
	public YahooPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Yahoo Page Initialized......");
		//isElementPresent(welcomeLink);
	}

	
}
