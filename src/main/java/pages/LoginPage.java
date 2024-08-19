package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//input[@placeholder='E-Mail Address']")
	private WebElement emailFeild;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordFeild;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement warningMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailFeild, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPasswordFeild(String passwordText) {
		elementUtils.typeTextIntoElement(passwordFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public boolean getWarningMessage() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Warning: No match for E-Mail Address and/or Password.");
	}
}
