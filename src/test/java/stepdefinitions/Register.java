package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utilites.CommonUtils;


public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Register Account page")
	public void User_navigates_to_Register_Account_page() {
		driver = DriverFactory.driverWebDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.clickonRegister();
		
	}
	
	@When("User enters the details into below feilds")
	public void User_enters_the_details_into_below_feilds(DataTable dataTable) {
		commonUtils = new CommonUtils();
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailAddresss(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}
	
	@And("User selects privacy policy")
	public void User_selects_privacy_policy() {
		registerPage.selectPrivacyPolicy();
	}
	
	@And("User clicks on Continue button")
	public void User_clicks_on_Continue_button() {
		registerPage.clickOnContinueButton();
		
	}
	
	@Then("User account should get created successfully")
	public void User_account_should_get_created_successfully() {
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.getPageHeading());
	}
	
	@And("User selects yes for Newsletter")
	public void User_selects_yes_for_Newsletter() {
		registerPage.selectYesNewsLetterOption();
	}
	
	@And("^User enter duplicate email (.+) in email feild$")
	public void User_enter_duplicate_email_in_email_feild(String email) {
		registerPage.enterEmailAddresss(email);
	
	}
	
	@Then("User should get a proper warning about duplicate email")
	public void User_should_get_a_proper_warning_about_duplicate_email() {
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerPage.getWarningMessageText());
	}
	
	@When("User dont enter any details into feilds")
	public void User_dont_enter_any_details_into_feilds() {
		
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmailAddresss("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
		
	}
	
	@Then("User should get a proper warning messages for every mandatory feild")
	public void User_should_get_a_proper_warning_messages_for_every_mandatory_feild() {
		
		Assert.assertTrue(registerPage.getFirstNameWarning() && registerPage.getLastNameWarning() && registerPage.getEmailAddressWarnig() && registerPage.telephoneWarning() && registerPage.passwordWarning());
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
	}
	
	
}
