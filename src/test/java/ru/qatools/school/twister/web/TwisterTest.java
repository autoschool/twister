package ru.qatools.school.twister.web;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by q on 11/20/14.
 */
@Features("Главная страница Twister")
public class TwisterTest {

    private WebDriver driver;

    @Rule
    public TestRule rule = new TestWatcher() {

        @Step("Создаем PhantomJS")
        @Override
        protected void starting(Description description) {
            driver = new PhantomJSDriver();
        }

        @Step("Закрываем PhantomJS")
        @Override
        protected void finished(Description description) {
            driver.quit();
        }
    };

    @Stories("Доступность главной страницы")
    @Test
    public void openMainPage(){
        openPage("http://localhost:8080");
        takeScreenShot();
    }

    @Step("Открываем {0}")
    public void openPage(String url) {
        driver.get(url);
    }

    @Attachment("Главная страница Twister")
    @Step("Делаем скриншот")
    private byte[] takeScreenShot() {
        return ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.BYTES);
    }
}

