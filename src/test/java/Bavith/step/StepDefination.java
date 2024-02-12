package Bavith.step;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Bavith.Tsting.BaseTest;
import Bavith.Tsting.CartPage;
import Bavith.Tsting.CheckoutPage;
import Bavith.Tsting.ConfirmationPage;
import Bavith.Tsting.LandingPage;
import Bavith.Tsting.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseTest {
	
	static LandingPage landingPage = null;
	static ProductCatalogue productCatalogue =null;
	static ConfirmationPage confirmationPage =null;
	
	@Given("opening wesite")
	void opening_wesite() throws IOException
	{
		landingPage = launchApplication();
	}
	
	@Given("^login with (.+) and (.+)$")
	void login_with_username_and_password(String userid,String password)
	{
	   productCatalogue=landingPage.loginApplication(userid,password);
	}
	
	@When("^Add (.+) to kart$")
	void Add_to_kart(String product) throws InterruptedException
	{
		productCatalogue.addProductToCart(product);
	}
	
	@And("^goto checkout page and submit (.+)$")
	void goto_checkout_page_and_submit(String productName)
	{
		CartPage cartPage = productCatalogue.goToCartPage();;
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{String} is displayed")
	void is_displayed(String displayed)
	{
		Assert.assertEquals(displayed, confirmationPage.getConfirmationMessage());
	}
}
