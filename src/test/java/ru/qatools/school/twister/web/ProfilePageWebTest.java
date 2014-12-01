package ru.qatools.school.twister.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class ProfilePageWebTest {
	
private WebDriver driver = new PhantomJSDriver();
	
	private static final String REGISTER_URL = "http://localhost:8080/profile";
	
	@Before
	public void openHomePage() {
	    driver.get(REGISTER_URL);
	}
	
	@Test
	public void accessRegisterPageTest() {
		String title = driver.getTitle();
	    assertThat(title, notNullValue());
	    assertThat(title, IsNot.not((equalTo("Error 404 Not Found"))));
	}

	@After
	public void close(){
		driver.close();
	    driver.quit();
	}
}
