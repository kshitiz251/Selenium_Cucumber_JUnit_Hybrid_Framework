package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class SearchResultPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//h2[text()='Products meeting the search criteria']")
	private WebElement searchProductFound;

	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement searchProductNotFound;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	public boolean searchedProductMatchFound() {
		return elementUtils.getTextFromElement(searchProductFound, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Products meeting the search criteria");
	}

	public boolean searchProductMatchNotFound() {
		return elementUtils.getTextFromElement(searchProductNotFound, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("There is no product that matches the search criteria.");
	}

}
