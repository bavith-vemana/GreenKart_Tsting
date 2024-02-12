package Bavith.Tsting;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ErrorValidations extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void LoginErrorValidation(String UserName,String Pass) throws InterruptedException
	{
		landingPage.loginApplication(UserName, Pass);
		//landingPage.loginApplication("vemanabavith@gmail.com", "bbbssd");
		AssertJUnit.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException
	{
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("vemanabavith111@gmail.com","Volcano@112");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		//Thread.sleep(500000);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		String[][] data = new String[2][2];
		data[0][0] = "vema@gmail.com";
		data[0][1] = "baana";
		
		data[1][0] = "bavi@gmail.com";
		data[1][1] = "baana";
		return data;
		 
		
	}
}
