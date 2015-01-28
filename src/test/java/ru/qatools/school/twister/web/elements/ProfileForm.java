package ru.qatools.school.twister.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by dima on 25.01.15.
 */
public class ProfileForm extends HtmlElement {

    @FindBy(id = "username")
    private TextBlock userName;

    public TextBlock getUserName() {
        return userName;
    }
}
