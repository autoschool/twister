package ru.qatools.school.twister.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageWebTest {
	
	private static final String USER_NAME = "admin";

	private WebDriver driver = new PhantomJSDriver();
	
	private static final String REGISTER_BUTTON_TEXT = "Register";
	private static final String REGISTER_URL = "http://localhost:8080/";
	private static final String USER_NAME_PLACEHOLDER = "Login";
	private static final String USER_PASS_PLACEHOLDER = "Password";
	
	@Before
	public void openHomePageAndRegisterDialog() {
	    driver.get(REGISTER_URL);
		WebElement registerButton = driver.findElement(By.id("register-button"));
		registerButton.click();
	}
	
	@Test
	public void addUserButtonExistsTest() {
		WebElement submitButton = driver.findElement(By.id("register-submit"));
		String buttonText = submitButton.getText();
	    assertThat(buttonText, notNullValue());
	    assertThat(buttonText, equalTo(REGISTER_BUTTON_TEXT));
	}
	
	@Test (timeout = 30000)
	@Ignore
	public void addUserButtonPressToProfileTest() {
		driver.findElement(By.id("register-login")).sendKeys(USER_NAME);
		driver.findElement(By.id("register-pass")).sendKeys(USER_NAME);
		WebElement submitButton = driver.findElement(By.id("register-submit"));
		submitButton.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("userProfile")));
		
	    String name = driver.findElement(By.id("userProfile")).getText();
	    assertThat(name, equalTo(USER_NAME));
	}
	
	@Test
	public void textFieldUserExistsTest() {
		String tfUserText = driver.findElement(By.id("register-login")).getText();
		String tfUserTextPlaceholder = driver.findElement(By.id("register-login")).getAttribute("placeholder");
		
	    assertThat(tfUserText, notNullValue());
	    assertThat(tfUserText, equalTo(""));
	    assertThat(tfUserTextPlaceholder, equalTo(USER_NAME_PLACEHOLDER));
	}
	
	@Test
	public void textFieldPasswordExistsTest() {
		String tfPassText = driver.findElement(By.id("register-pass")).getText();
		String tfPassTextPlaceholder = driver.findElement(By.id("register-pass")).getAttribute("placeholder");
		
	    assertThat(tfPassText, notNullValue());
	    assertThat(tfPassText, equalTo(""));
	    assertThat(tfPassTextPlaceholder, equalTo(USER_PASS_PLACEHOLDER));
	}
	
	
	@After
	public void close(){
		driver.close();
	    driver.quit();
	}
}