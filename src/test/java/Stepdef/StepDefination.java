package Stepdef;

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
	
	LandingPage landingPage = null;
	ProductCatalogue productCatalogue =null;
	ConfirmationPage confirmationPage =null;
	
	@Given("opening wesite")
	public void opening_wesite() throws IOException
	{
		landingPage = launchApplication();
	}
	
	@Given("^login with (.+) and (.+)$")
	public void login_with_username_and_password(String userid,String password)
	{
	   productCatalogue=landingPage.loginApplication(userid,password);
	}
	
	@When("^Add (.+) to kart$")
	public void Add_to_kart(String product) throws InterruptedException
	{
		productCatalogue.addProductToCart(product);
	}
	
	@And("^goto checkout page and submit (.+)$")
	public void goto_checkout_page_and_submit(String productName)
	{
		CartPage cartPage = productCatalogue.goToCartPage();;
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} is displayed")
	public void is_displayed(String displayed)
	{
		Assert.assertEquals(displayed, confirmationPage.getConfirmationMessage());
		driver.close();
	}
	

}
