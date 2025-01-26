package com.sdet.anik.question4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateFlightBooking {
	private WebDriver driver;

	public AutomateFlightBooking() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\eclipse-workspace\\Question 4\\src\\main\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	public void openUrl(String url) {
		driver.get(url);
	}

	public void clickElement(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	public void enterText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}

	public void automateFlightBooking() {
		try {
			openUrl("https://www.makemytrip.com/");
			Thread.sleep(5000);
			try {
				clickElement(By.cssSelector("span[data-cy='closeModal']"));
			} catch (Exception ignored) {
			}
			By flightsTab = By.xpath("//li[@data-cy='menu_Flights']");
			clickElement(flightsTab);
			Thread.sleep(2000);
			By oneWayOption = By.xpath("//li[@data-cy='oneWayTrip']");
			clickElement(oneWayOption);
			Thread.sleep(2000);
			By fromLocation = By.xpath("//label[@for='fromCity']");
			clickElement(fromLocation);
			By fromInput = By.xpath("//input[@placeholder='From']");
			enterText(fromInput, "Delhi");
			Thread.sleep(2000);
			clickElement(By.xpath("//p[contains(text(),'New Delhi')]"));
			By toLocation = By.xpath("//label[@for='toCity']");
			clickElement(toLocation);
			By toInput = By.xpath("//input[@placeholder='To']");
			enterText(toInput, "Mumbai");
			Thread.sleep(2000);
			clickElement(By.xpath("//p[contains(text(),'Mumbai')]"));
			System.out.println("Flight search setup is completed.");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		AutomateFlightBooking automation = new AutomateFlightBooking();
		automation.automateFlightBooking();
	}
}
