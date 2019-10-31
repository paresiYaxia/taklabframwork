package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExampleSearch {

	public static void main(String[] args) {

//		setting sstem property -- locate actual driver is located;
		System.setProperty("webdriver.chrome.driver", "/Users/Elif/Documents/drivers-BrowsersPath/ChromeDriver/chromedriver");

//		/taklabframwork/src/test/resources/drivers/chromedriver
		
		// lunch Chrome;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to Website
		driver.get("https://www.google.com/");

		System.out.println("Current web page title is " + driver.getTitle());

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
		System.out.println("The current webtitle title is " + currentTitle);

		if (currentTitle.contentEquals("kroran san diego - Google Search")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		System.out.println("------------\nAll tests have run. closing driver now");
		driver.quit();

	}

}
