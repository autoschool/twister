package ru.qatools.school.twister.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by dima on 25.01.15.
 */
public class PostItem extends HtmlElement {

    @FindBy( linkText = "Read more")
    private Link readMoreLink;

    @FindBy( className = "post-title")
    private Link titleLink;

    public Link getReadMoreLink() {
        return this.readMoreLink;
    }

    public Link getTitleLink() {
        return titleLink;
    }
}
