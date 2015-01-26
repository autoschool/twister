package ru.qatools.school.twister.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by dima on 25.01.15.
 */
public class RegisterForm extends HtmlElement {

    @FindBy(id = "register-login")
    private TextInput loginField;

    @FindBy(id = "register-pass")
    private TextInput passwordField;

    @FindBy(id = "register-name")
    private TextInput nameField;

    @FindBy (id = "register-submit")
    private Button registerSubmitButton;

    public TextInput getLoginField() {
        return loginField;
    }

    public TextInput getPasswordField() {
        return passwordField;
    }

    public TextInput getNameField() {
        return nameField;
    }

    public Button getRegisterSubmitButton() {
        return registerSubmitButton;
    }

    public void register( String name, String login, String password ){
        getNameField().sendKeys( name );
        getLoginField().sendKeys( login );
        getPasswordField().sendKeys( password );
        getRegisterSubmitButton().click();
    }

}
