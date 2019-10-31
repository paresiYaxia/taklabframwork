package example;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FirstExampleSearchTestNG {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {

//		setting sstem property -- locate actual driver is located;
		System.setProperty("webdriver.chrome.driver",
				"/Users/Elif/Documents/drivers-BrowsersPath/ChromeDriver/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to Website
		driver.get("https://www.google.com/");

		System.out.println("Current web page title is " + driver.getTitle());

	}

	@Test
	public void testGoogleSearch() {
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Kroran San Diego");

		// Wait for 2 second
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		// submit the element
		element.submit();

		// it takes goodle some time, so just timeout 5 sec;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}

		// assert result

		String currentTitle = driver.getTitle();
		assertEquals(currentTitle, "Kroran San Diego - Google Search");

	}

	@AfterMethod
	public void tearDown() throws Exception {

		driver.quit();

	}

}
