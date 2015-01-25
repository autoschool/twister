package ru.qatools.school.twister.web.steps;

import org.openqa.selenium.WebDriver;
import ru.qatools.school.twister.web.page.ProfilePage;
import ru.qatools.school.twister.web.page.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by dima on 25.01.15.
 */
public class RegisterSteps extends LoginSteps {

    private RegistrationPage registrationPage;
    private ProfilePage profilePage;

    public RegisterSteps(WebDriver driver) {
        super( driver );
        registrationPage = new RegistrationPage( driver );
    }

    @Step("Open registration dialog")
    public void openRegistrationDialog() {
        registrationPage.open();
    }

    @Step("Register test user")
    public void register( String name, String login, String password ){
        profilePage = registrationPage.register( name, login, password) ;
    }


    @Step("Check if new user moved into profile page")
    public void userShouldBe( String name, String login ){
        String actualUserName = profilePage.getUserName().getText();
        String actualLogin = profilePage.getMainMenu().getUserMenuLink().getText();

        assertThat( actualUserName, equalTo( name ) );
        assertThat( actualLogin, equalTo( login ) );
    }
}
