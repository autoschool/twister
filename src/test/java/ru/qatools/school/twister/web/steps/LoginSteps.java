package ru.qatools.school.twister.web.steps;

import org.openqa.selenium.WebDriver;
import ru.qatools.school.twister.web.page.IndexPage;
import ru.qatools.school.twister.web.page.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by dima on 25.01.15.
 */
public class LoginSteps {

    protected static WebDriver driver;
    protected static String homeUrl = "http://localhost:8080/";
    private IndexPage indexPage;
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage( driver );
    }
    @Step("System login")
    public void login( String login, String password ){
        loginPage.open();
        indexPage = loginPage.login( login, password );
    }

    @Step("Open home url")
    public void openHomeUrl(){
        driver.get(homeUrl);
    }

    public void quit() {
        driver.quit();
    }
}
