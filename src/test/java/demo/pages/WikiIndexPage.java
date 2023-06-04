package demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;

/**
 * Index Page: https://www.wikipedia.org/
 *
 * #Same meaning
 * @FindBy(id = "searchInput")
 * @FindBy(how = How.ID, using="searchInput")
 * 
 * #Page Factory Method to initialize all elements
 * PageFactory.initElements(driver, this);
 * 
 */
public class WikiIndexPage extends BasePage {

	WebDriver driver;
	
	@FindBy(xpath="//strong[contains(text(),'English')]")
	public static WebElement english;
	
	@FindBy(how = How.ID, using="searchInput")
	public static WebElement searchBox;
	
	@FindBy(xpath=".//form[@id='search-form']/fieldset/button")
	public static WebElement searchBoxButton;

	/**
	 * Page constructor to initialize driver
	 * verify any page element to make sure page has been loaded properly
	 */
	public WikiIndexPage(WebDriver driver) throws MalformedURLException {
		super(driver);
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

	public void clickSearchBoxButton(){
		click(searchBoxButton);
	}
	
	public void searchWith(String keyword){
		sendKeys(searchBox, keyword);
		click(searchBoxButton);
	}
	
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
