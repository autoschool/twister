package ru.qatools.school.twister.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by dima on 25.01.15.
 */
public class MainMenu extends HtmlElement {

    @FindBy(id = "logo")
    private Link indexLink;

    @FindBy(id = "register-button")
    private Link registerLink;

    @FindBy(id = "signin-button")
    private Link loginLink;

    @FindBy(id = "post-create")
    private Link createPostLink;

    @FindBy(id = "user-menu")
    private Link userMenuLink;

    @FindBy(id = "user-profile")
    private Link userProfileLink;

    @FindBy(id = "user-signout")
    private Link userSignoutLink;

    public Link getIndexLink() {
        return indexLink;
    }

    public Link getRegisterLink() {
        return registerLink;
    }

    public Link getLoginLink() {
        return loginLink;
    }

    public Link getCreatePostLink() {
        return createPostLink;}


    public Link getUserMenuLink() {
        return userMenuLink;
    }

    public Link getUserProfileLink() {
        return userProfileLink;
    }

    public Link getUserSignoutLink() {
        return userSignoutLink;
    }

    public void openIndexPage() {
        getIndexLink().click();
    }
    public void openRegisterForm() {
        getRegisterLink().click();
    }
    public void openLoginForm() {
        getLoginLink().click();
    }
    public void openCreatePostPage() {
        getCreatePostLink().click();
    }
    public void openUserMenuPage() {
        getUserMenuLink().click();
    }
    public void openUserProfilePage() {
        getUserProfileLink().click();
    }
    public void performSignout() {
        getUserSignoutLink().click();
    }

}
