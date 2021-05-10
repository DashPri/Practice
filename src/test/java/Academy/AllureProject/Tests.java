package Academy.AllureProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({AllureListener.class})
public class Tests extends BaseClass {
public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Pritam\\chromedriver_win32\\chromedriver.exe");
		 * 
		 * driver = new ChromeDriver();
		 */
		
		BaseClass bs = new BaseClass();
		driver= bs.initialize_driver();
		String URL = "https://www.google.com/";
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test
	public void googleLogoTest() {
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		driver.quit();
	}

}
