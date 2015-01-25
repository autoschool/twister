package ru.qatools.school.twister.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qatools.school.twister.web.elements.LoginForm;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * Created by dima on 25.01.15.
 */
public class LoginPage extends AbstractPage {

    @FindBy( className = "signin-form")
    private LoginForm loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public void open() {
        getMainMenu().openLoginForm();
        }

    public IndexPage login( String login, String password ) {
        getLoginForm().signIn( login, password );
        return new IndexPage( driver );
    }

    public CreatePostPage loginToCreatePostPage( String login, String password ) {
        getLoginForm().signIn( login, password );
        return new CreatePostPage( driver );
    }

    public PostPage loginToPostPage( String login, String password ) {
        getLoginForm().signIn( login, password );
        return new PostPage( driver );
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }
}
