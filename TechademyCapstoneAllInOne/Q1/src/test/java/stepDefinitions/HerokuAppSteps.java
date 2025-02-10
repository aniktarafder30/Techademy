package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HerokuAppSteps extends BaseTest {
    private WebDriver driver;
    @Before
    public void starting(){
        driver = setUp();
    }
    @After
    public void terminate(){
        tearDown();

    }


    @Given("I launch the HerokuApp website")
    public void launchWebsite() {
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Then("I verify the page title is {string}")
    public void verifyPageTitle(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @When("I click on AB Testing link")
    public void clickOnABTesting() {
        driver.findElement(By.linkText("A/B Testing")).click();
    }



    @Then("I verify the text on the page is {string}")
    public void verifyABTestText(String expectedText) {
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @And("I navigate back to Home page")
    public void navigateBackToHomePage() {
        driver.navigate().back();
    }

    @When("I click on Dropdown link")
    public void clickOnDropdownLink() {
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @And("I select {string} from the dropdown")
    public void selectFromDropdown(String option) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    @Then("I verify {string} is selected")
    public void verifyDropdownSelection(String expectedSelection) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        String actualSelection = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection, expectedSelection);
    }

    @When("I click on Frames link")
    public void clickOnFramesLink() {
        driver.findElement(By.linkText("Frames")).click();
    }

    @Then("I verify the {string} link is present")
    public void verifyFramesLinkPresent(String linkText) {
        boolean isPresent = driver.findElement(By.linkText(linkText)).isDisplayed();
        Assert.assertTrue(isPresent, linkText + " is not present on the Frames page.");
    }
}
