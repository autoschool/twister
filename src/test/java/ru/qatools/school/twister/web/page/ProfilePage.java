package ru.qatools.school.twister.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qatools.school.twister.web.elements.ProfileForm;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * Created by dima on 25.01.15.
 */
public class ProfilePage extends AbstractPage {

    @FindBy( className = "container")
    private ProfileForm profileForm;

    @FindBy(id = "username")
    private TextBlock userName;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public TextBlock getUserName() {
        return userName;
    }

    public ProfileForm getProfileForm() {
        return profileForm;
    }
}
