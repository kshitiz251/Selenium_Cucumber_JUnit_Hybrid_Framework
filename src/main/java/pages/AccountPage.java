package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class AccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editYourAccountInformationOption;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		elementUtils = new ElementUtils(driver);
	}
	
	//account 
	public boolean displayStatusOfEditYourAccountInformationOption() {
		return elementUtils.displayStatusOfElement(editYourAccountInformationOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
