package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameFeild;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameFeild;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailFeild;

	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement telephoneFeild;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordFeild;

	@FindBy(xpath = "//input[@name='confirm']")
	private WebElement confirmPasswordFeild;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyOption;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//label[@class='radio-inline']")
	private WebElement yesNewsLetterOption;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;

	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailAddressWarning;

	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement passwordWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	public void enterFirstName(String firstName) {
		elementUtils.typeTextIntoElement(firstNameFeild, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterLastName(String lastName) {
		elementUtils.typeTextIntoElement(lastNameFeild, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterEmailAddresss(String emailText) {
		elementUtils.typeTextIntoElement(emailFeild, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME );
	}

	public void enterTelephone(String telephoneText) {
		elementUtils.typeTextIntoElement(telephoneFeild, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterConfirmPassword(String passwordText) {
		elementUtils.typeTextIntoElement(confirmPasswordFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectYesNewsLetterOption() {
		elementUtils.clickOnElement(yesNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public boolean getFirstNameWarning() {
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("First Name must be between 1 and 32 characters!");
	}

	public boolean getLastNameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Last Name must be between 1 and 32 characters!");
	}

	public boolean getEmailAddressWarnig() {
		return elementUtils.getTextFromElement(emailAddressWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("E-Mail Address does not appear to be valid!");

	}

	public boolean telephoneWarning() {
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Telephone must be between 3 and 32 characters!");
	}

	public boolean passwordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Password must be between 4 and 20 characters!");
	}
}
