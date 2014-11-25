package ru.qatools.school.twister;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TwisterBlogTest {

    private WebDriver driver = new PhantomJSDriver();

    private static final String BASE_URL = "http://localhost:8080";
    private static final String BLOG_TITLE = "Twister";

    @Before
    public void openHomePage() {
        driver.get(BASE_URL);
    }

    @Test
    @Ignore
    public void blogTitleTest() {
    	String title = driver.getTitle();
        assertThat(title, notNullValue());
        assertThat(title, equalTo(BLOG_TITLE));
    }
    
    @After
    public void close(){
        driver.quit();
    }
}