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
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import ru.qatools.school.twister.web.page.IndexPage;
import ru.qatools.school.twister.web.steps.RegisterSteps;

public class CreatePostWebTest {
	
	private WebDriver driver;
	private IndexPage indexPage;
	private RegisterSteps registerSteps;
	private static final String NEW_POST_BUTTON_TEXT = "Publish";
	private static final String NEW_POST_URL = "http://localhost:8080/post/new";
	private static final String POST_TITLE_PLACEHOLDER = "Post Title";

	private static String testLogin = "user";
	private static String testName = "name";
	private static String testPassword = "password";

	@Before
	public void createDriver() {
		driver = new PhantomJSDriver();
		indexPage = new IndexPage( driver );
		indexPage.getMainMenu().openRegisterForm();

		registerSteps = new RegisterSteps( driver );
		registerSteps.register( testName, testLogin, testPassword );
		driver.get(NEW_POST_URL);
	}

	@Test
	@Ignore
	public void addPostButtonTest() {
		String buttonText = driver.findElement(By.id("publish")).getText();
	    assertThat(buttonText, notNullValue());
	    assertThat(buttonText, equalTo(NEW_POST_BUTTON_TEXT));
	}
	
	@Test
	@Ignore
	public void textFieldTitleExistsTest() {
		String tfTitleText = driver.findElement(By.id("title")).getText();
		String tfTitleTextPlaceholder = driver.findElement(By.id("title")).getAttribute("placeholder");
		
	    assertThat(tfTitleText, notNullValue());
	    assertThat(tfTitleText, equalTo(""));
	    assertThat(tfTitleTextPlaceholder, equalTo(POST_TITLE_PLACEHOLDER));
	}
	
	@After
	public void close(){
		driver.close();
	    driver.quit();
	}
}
