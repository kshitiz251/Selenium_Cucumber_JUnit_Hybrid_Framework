package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class SearchPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchOption;
	
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		elementUtils = new ElementUtils(driver);
	}
	
	public void enterSearchProduct(String product) {
		elementUtils.typeTextIntoElement(searchOption, product, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public SearchResultPage clickSearchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultPage(driver);
	}

}
