package ru.qatools.school.twister.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by dima on 25.01.15.
 */
public class LoginForm extends HtmlElement {

    @FindBy(id = "signin-login")
    private TextInput loginField;

    @FindBy(id = "signin-pass")
    private TextInput passwordField;

    @FindBy (id = "signin-submit")
    private Button signInSubmitButton;

    public TextInput getLoginInput(){ return this.loginField; }

    public TextInput getPasswordInput(){ return this.passwordField; }

    public Button getSignInSubmitButton(){ return this.signInSubmitButton; }

    public void signIn( String login, String password ){
        getLoginInput().sendKeys(login);
        getPasswordInput().sendKeys(password);
        getSignInSubmitButton().click();
    }

}
