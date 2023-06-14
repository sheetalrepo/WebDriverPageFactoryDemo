package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * https://en.wikipedia.org/wiki/Main_Page
 * 
 * @FindBys vs @FindAll
 * https://stackoverflow.com/questions/25914156/difference-between-findall-and-findbys-annotations-in-webdriver-page-factory
 * 
 * @FindBys   AND Condition
 * @FindAll   OR Condition
 */
public class WikiMainPage extends BasePage {

	WebDriver driver;
	
	@FindBy(id = "Welcome_to_Wikipedia")
	private WebElement welcomeLink;
	
	@FindBys({
			@FindBy(xpath = ".//div[@id='simpleSearch']/input[1]"),
			@FindBy(linkText = "Search")
	})
	private WebElement searchBox;    //AND
	
	@FindAll({ 
		@FindBy(xpath = "//*[@id='searchform']/div/button"),
		@FindBy(linkText = "Search") 
	})
	public static WebElement searchButton;   //OR
	

	/**
	 * Page constructor to initialize driver
	 * verify any page element to make sure page has been loaded properly
	 */
	public WikiMainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isElementPresent(welcomeLink);
	}
	
	/**
	 * Getters
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public WebElement getWelcomeLink() {
		return welcomeLink;
	}
}
