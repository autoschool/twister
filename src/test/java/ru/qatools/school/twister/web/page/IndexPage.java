package ru.qatools.school.twister.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qatools.school.twister.web.elements.PostItem;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 25.01.15.
 */
public class IndexPage extends AbstractPage {

    List<PostItem> postItems;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(driver), this);

        tryInitPosts();
    }

    public PostPage openPostPage( int postIndex ) {
        if ( postItems == null ) {
            return null;
        }

        PostItem post = postItems.get( postIndex );
        post.getReadMoreLink().click();
        return new PostPage( driver );
    }

    public PostPage openPostPage( String title ){
        if ( postItems == null ) {
            return null;
        }

        for ( PostItem item : postItems ) {
            if (item.getTitleLink().getText().equalsIgnoreCase( title ) ) {
                item.getTitleLink().click();
                return new PostPage( driver );
            }
        }
        return null;
    }

    private void tryInitPosts() {
        WebDriverWait wait = new WebDriverWait( driver, 10 );
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("post"))));

        List<WebElement> posts = driver.findElements(By.className("post"));
        if ( posts != null ) {
            postItems = new ArrayList<>();
            for ( WebElement item : posts ) {
                postItems.add( (PostItem) item );
            }
        }
    }
}
