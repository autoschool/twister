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

public class CreatePostTest {
	
	private WebDriver driver = new PhantomJSDriver();
		
	private static final String NEW_POST_BUTTON_TEXT = "Publish";
	private static final String NEW_POST_URL = "http://localhost:8080/post/new";
	private static final String POST_TITLE_PLACEHOLDER = "Post Title";
	
	@Before
	public void openHomePage() {
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
	
	@Test
	@Ignore
	public void textFieldBodyExistsTest() {
		String tfBodyText = driver.findElement(By.id("body")).getText();
	    assertThat(tfBodyText, notNullValue());
	    assertThat(tfBodyText, equalTo(""));
	}
	
	@After
	public void close(){
	    driver.quit();
	}
}
