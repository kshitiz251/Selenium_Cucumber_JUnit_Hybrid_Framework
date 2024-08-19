package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class AccountSuccessPage {

WebDriver driver;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement pageHeading;
	private ElementUtils elementUtils;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	public boolean getPageHeading() {
		return elementUtils.getTextFromElement(pageHeading, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Your Account Has Been Created!");
	}
	
}
