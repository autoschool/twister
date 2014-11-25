package ru.qatools.school.twister;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class RegisterPageTest {
	
	private WebDriver driver = new PhantomJSDriver();
	
	private static final String REGISTER_BUTTON_TEXT = "Sign on";
	private static final String REGISTER_URL = "http://localhost:8080/auth/register";
	private static final String USER_NAME_PLACEHOLDER = "Login";
	private static final String USER_PASS_PLACEHOLDER = "Password";
	
	@Before
	public void openHomePage() {
	    driver.get(REGISTER_URL);
	}
	
	@Test
	@Ignore
	public void addUserButtonTest() {
		String buttonText = driver.findElement(By.id("register")).getText();
	    assertThat(buttonText, notNullValue());
	    assertThat(buttonText, equalTo(REGISTER_BUTTON_TEXT));
	}
	
	@Test
	@Ignore
	public void textFieldUserTest() {
		String tfUserText = driver.findElement(By.id("login")).getText();
		String tfUserTextPlaceholder = driver.findElement(By.id("login")).getAttribute("placeholder");
		
	    assertThat(tfUserText, notNullValue());
	    assertThat(tfUserText, equalTo(""));
	    assertThat(tfUserTextPlaceholder, equalTo(USER_NAME_PLACEHOLDER));
	}
	
	@Test
	@Ignore
	public void textFieldPasswordTest() {
		String tfPassText = driver.findElement(By.id("pass")).getText();
		String tfPassTextPlaceholder = driver.findElement(By.id("pass")).getAttribute("placeholder");
		
	    assertThat(tfPassText, notNullValue());
	    assertThat(tfPassText, equalTo(""));
	    assertThat(tfPassTextPlaceholder, equalTo(USER_PASS_PLACEHOLDER));
	}
	
	@After
	public void close(){
	    driver.quit();
	}
}