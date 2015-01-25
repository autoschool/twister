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

public class RegistrationWebTest {

	private static final String USER_NAME = "admin";

	private WebDriver driver = new PhantomJSDriver();

	private static final String REGISTER_BUTTON_TEXT = "register";
	private static final String REGISTER_URL = "http://localhost:8080/";
	private static final String USER_NAME_PLACEHOLDER = "Please, enter your real name";
	private static final String USER_LOGIN_PLACEHOLDER = "Login";
	private static final String USER_PASS_PLACEHOLDER = "Password";

	@Before
	public void openHomePageAndRegistrationDialog() {
	    driver.get(REGISTER_URL);
		driver.manage().window().maximize();
		WebElement menu = driver.findElement(By.id("menu"));
		WebElement registryButton = findRegistryButton( menu );

		registryButton.click();
	}

	@Test
	public void registerButtonExistsTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement submitButton = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.id("register-submit"))));
		String buttonText = submitButton.getText();
	    assertThat(buttonText, notNullValue());
	    assertThat(buttonText.toLowerCase(), equalTo(REGISTER_BUTTON_TEXT));
	}

	@Test (timeout = 30000)
	@Ignore
	public void registrationProcessTest() {
		driver.findElement(By.id("register-name")).sendKeys(USER_NAME);
		driver.findElement(By.id("register-login")).sendKeys(USER_NAME);
		driver.findElement(By.id("register-pass")).sendKeys(USER_NAME);
		WebElement submitButton = driver.findElement(By.id("register-submit"));
		submitButton.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		
	    String name = driver.findElement(By.id("user-menu")).getText();
	    assertThat(name, equalTo(USER_NAME));
	}

	@Test
	public void textFieldNameExistsTest() {
		String tfUserText = driver.findElement(By.id("register-name")).getText();
		String tfUserTextPlaceholder = driver.findElement(By.id("register-name")).getAttribute("placeholder");

		assertThat(tfUserText, notNullValue());
		assertThat(tfUserText, equalTo(""));
		assertThat(tfUserTextPlaceholder, equalTo(USER_NAME_PLACEHOLDER));
	}

	@Test
	public void textFieldLoginExistsTest() {
		String tfUserText = driver.findElement(By.id("register-login")).getText();
		String tfUserTextPlaceholder = driver.findElement(By.id("register-login")).getAttribute("placeholder");

	    assertThat(tfUserText, notNullValue());
	    assertThat(tfUserText, equalTo(""));
	    assertThat(tfUserTextPlaceholder, equalTo(USER_LOGIN_PLACEHOLDER));
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


	private WebElement findRegistryButton( WebElement menu ) {
		WebElement registryButton;
		int windowWidth = driver.manage().window().getSize().getWidth();
		if ( menu.isDisplayed() ){
			System.out.println(	"Window small | width: " + windowWidth );
			menu.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);

			registryButton = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.id("register-button"))));
		} else {
			System.out.println(	"Window large | width: " + windowWidth );
			registryButton = driver.findElement(By.id("register-button"));
		}
		return registryButton;
	}
}