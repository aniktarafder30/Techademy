import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

@pytest.fixture(scope="function")
def browser():
    # Initialize the browser and maximize the window
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    driver.maximize_window()
    yield driver  # This will provide the driver to the test
    driver.quit()  # Close the browser after the test is done

def test_w3schools_logo(browser):
    # Navigate to the W3Schools homepage
    browser.get("https://www.w3schools.com/")
    
    # Define the locator for the W3Schools logo
    logo_locator = (By.CSS_SELECTOR, "a#w3-logo i.fa-logo")
    
    # Find the logo element using the defined locator
    logo = browser.find_element(*logo_locator)
    
    # Assert that the logo is displayed on the page
    assert logo.is_displayed(), "W3Schools logo is not visible on the page."
    
    # Print a message if the logo is displayed
    print("W3Schools logo is displayed on the page.")
