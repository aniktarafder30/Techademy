import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture(scope="function")
def driver():
    """Fixture to initialize and quit WebDriver"""
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()


def test_verify_title(driver):
    driver.get("http://the-internet.herokuapp.com/")
    assert driver.title == "The Internet", "Page title does not match"


def validate_checkbox(checkbox, expected_state, checkbox_number):
    assert checkbox.is_selected() == expected_state, f"Checkbox {checkbox_number} validation failed"


def test_checkboxes(driver):
    driver.get("http://the-internet.herokuapp.com/")
    driver.find_element(By.LINK_TEXT, "Checkboxes").click()

    heading = driver.find_element(By.TAG_NAME, "h3").text
    assert heading == "Checkboxes", "Incorrect heading text"

    checkboxes = driver.find_elements(By.CSS_SELECTOR, "input[type='checkbox']")
    
    
    validate_checkbox(checkboxes[0], False, 1)
    validate_checkbox(checkboxes[1], True, 2)


def test_file_upload(driver):
    driver.get("http://the-internet.herokuapp.com/")
    
  
    driver.find_element(By.LINK_TEXT, "Checkboxes").click()
    
    
    driver.back()  

    
    driver.find_element(By.LINK_TEXT, "File Upload").click()

    
    heading = driver.find_element(By.TAG_NAME, "h3").text
    assert heading == "File Uploader", "Incorrect heading text"

    
    file_input = driver.find_element(By.ID, "file-upload")
    file_input.send_keys("C:\QuestionNumber2.txt")  

    driver.find_element(By.ID, "file-submit").click()
    
    
    uploaded_text = driver.find_element(By.ID, "uploaded-files").text
    assert "QuestionNumber2.txt" in uploaded_text, f"File upload failed. Expected: 'QuestionNumber2.txt', Got: '{uploaded_text}'"
