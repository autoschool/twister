package ru.qatools.school.twister.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qatools.school.twister.web.elements.MainMenu;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * Created by dima on 25.01.15.
 */
public abstract class AbstractPage {

    protected WebDriver driver;
    protected String homeUrl = "http://localhost:8080/";

    @FindBy(className = "main-menu")
    private MainMenu mainMenu;

    public MainMenu getMainMenu() {
        return this.mainMenu;
    }

    public AbstractPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public IndexPage openIndexPage() {
        getMainMenu().openIndexPage();
        return new IndexPage(driver);
    }
}
