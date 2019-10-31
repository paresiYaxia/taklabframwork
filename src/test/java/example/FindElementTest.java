package example;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {

//		setting sstem property -- locate actual driver is located;
		System.setProperty("webdriver.chrome.driver",
				"/Users/Elif/Documents/drivers-BrowsersPath/ChromeDriver/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to Website
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");

		System.out.println("Current web page title is " + driver.getTitle());

	}

	@AfterMethod
	public void tearDown() throws Exception {

		driver.quit();

	}

	@Test
	public void testGoogleSearch() {
		// Find the text input element by its name
		WebElement inputBxFirstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		inputBxFirstname.clear();
		inputBxFirstname.sendKeys("Peter");

		
		WebElement inputBxLastName = driver.findElement(By.id("lastName"));
		inputBxLastName.clear();
		inputBxLastName.sendKeys("Parker"); 
		
		
		
		
		

		
		
		
		
		
		
		
		// Wait for 2 second
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {   
		}

		// submit the element
		inputBxFirstname.submit();

		// it takes goodle some time, so just timeout 5 sec;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}

		// assert result

		String currentTitle = driver.getTitle();
		assertEquals(currentTitle, "Kroran San Diego - Google Search");

	}

}
