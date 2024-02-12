package Bavith.Tsting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

	public static  WebDriver driver;
	public static LandingPage landingPage;
	public static ExtentReports extent;
	public static WebDriver initializeDriver() throws IOException

	{
		driver = null;
		Properties prop = new Properties();
		FileInputStream fls = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Tsting\\src\\test\\java\\Data\\browser.properties");
		prop.load(fls);
		String name = prop.getProperty("browser");
		System.out.println(name);
		if(name.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	@BeforeSuite
	public static void ExtntRptrs()
	{
		String path = System.getProperty("user.dir")+"\\reports\\reports.html";
		ExtentSparkReporter rp = new ExtentSparkReporter(path);
		rp.config().setReportName("Green-Kart");
		rp.config().setDocumentTitle("Reports");
		extent = new ExtentReports();
		extent.attachReporter(rp);
	}
	
	public static String GetScreenShot(String Name) throws IOException {
		String path = System.getProperty("user.dir")+"\\Screenshot\\"+ Name + ".png";
		File Src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Src,new File(path));	
		return path;
	}
	
	@BeforeMethod
	public static LandingPage launchApplication() throws IOException
	{
		 driver = initializeDriver();
		  landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}


}
