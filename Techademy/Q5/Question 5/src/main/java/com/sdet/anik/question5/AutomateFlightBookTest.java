package com.sdet.anik.question5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomateFlightBookTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Set the WebDriver system property
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\Question 5\\src\\main\\resources\\chromedriver.exe");

		// Initialize the WebDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
	}

	@Test
	public void flightSearchAutomation() throws InterruptedException {
		Thread.sleep(5000); // Close any popup if present
		try {
			driver.findElement(By.cssSelector("span[data-cy='closeModal']")).click();
		} catch (Exception ignored) {
		}

		// Click on Flights tab
		driver.findElement(By.xpath("//li[@data-cy='menu_Flights']")).click();
		Thread.sleep(2000);

		// Select OneWay trip
		driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
		Thread.sleep(2000);

		// Enter FROM location
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'New Delhi')]")).click();

		// Enter TO location
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(),'Mumbai')]")).click();

		System.out.println("Flight search setup completed successfully.");
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
