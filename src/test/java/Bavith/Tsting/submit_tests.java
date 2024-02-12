package Bavith.Tsting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class submit_tests extends BaseTest {
	String productName = "ZARA COAT 3";
	@Test(dataProvider = "getData_Hashmap",retryAnalyzer =Retry.class)
	public void sub_order(HashMap<String,String> data) throws InterruptedException, IOException {
		ProductCatalogue productCatalogue=landingPage.loginApplication(data.get("mail"),data.get("Password"));
		productCatalogue.addProductToCart(productName);
		//productCatalogue.goToCartPage();
		CartPage cartPage = productCatalogue.goToCartPage();;
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		//Assert.assertTrue(false);
		Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmationPage.getConfirmationMessage());
	}
	
	@Test(dependsOnMethods = {"sub_order"})
	public void OrderHistoryTest()
	{
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("vemanabavith111@gmail.com","Volcano@112");
		
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Boolean flag = orderPage.VerifyOrderDisplay(productName);
		Assert.assertTrue(flag);
		
		
	}
	
	@DataProvider
	public  Object[][] getData_Hashmap()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("mail","vemanabavith111@gmail.com");
		map.put("Password","Volcano@112");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("mail","bavitgvemana@gmail.com");
		map1.put("Password","Volcano@112");
		
		return new Object[][] {{map},{map1}};
		
		//return data;
	}
}
