package Bavith.Tsting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ConfirmationPage extends AbstractComponent{

	
	static WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
		CheckoutPage cp = new CheckoutPage(driver);	
		return confirmationMessage.getText();
	}
	
	
}
