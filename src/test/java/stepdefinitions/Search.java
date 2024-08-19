package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import pages.SearchResultPage;

public class Search {
	WebDriver driver;
	private SearchPage searchPage;	
	private SearchResultPage searchResultPage;
	
	@Given("User opens the Application")
	public void User_opens_the_Application() {
		driver = DriverFactory.driverWebDriver();
		searchPage = new SearchPage(driver);
	}

	@When("^User enters valid product (.+) into Search box feild$")
	public void User_enters_valid_product_into_Search_box_feild(String product) {
		
		searchPage.enterSearchProduct(product);
	}
	
	@And("User clicks on Search button")
	public void User_clicks_on_Search_button() {
		searchResultPage = searchPage.clickSearchButton();
		
	}
	
	@Then("User should get valid product displayed in search result")
	public void User_should_get_valid_product_displayed_in_search_result() {
		
		Assert.assertTrue(searchResultPage.searchedProductMatchFound());
	}
	
	@When("^User enters invalid product (.+) into Search box feild$")
	public void User_enters_invalid_product_into_Search_box_feild(String product) {
		
		searchPage.enterSearchProduct(product);
		
	}
	
	@Then("User should get a message about no product matching")
	public void User_should_get_a_message_about_no_product_matching() {
		
		Assert.assertTrue(searchResultPage.searchProductMatchNotFound());
	}
	
	@When("User dont enter any product name into Seach box feild")
	public void User_dont_enter_any_product_name_into_Seach_box_feild() {
		
		searchPage.enterSearchProduct("");
		
	}
	
}
