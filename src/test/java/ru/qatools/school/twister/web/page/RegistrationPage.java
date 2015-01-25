package ru.qatools.school.twister.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qatools.school.twister.web.elements.LoginForm;
import ru.qatools.school.twister.web.elements.RegisterForm;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * Created by dima on 25.01.15.
 */
public class RegistrationPage extends AbstractPage {

    @FindBy( className = "register-form")
    private RegisterForm registerForm;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public void open() {
        getMainMenu().openRegisterForm();
    }

    public ProfilePage register( String name, String login, String password ) {
        getRegisterForm().register( name, login, password );
        return new ProfilePage( driver );
    }

    public RegisterForm getRegisterForm() {
        return registerForm;
    }
}
