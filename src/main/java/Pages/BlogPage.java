package Pages;

public class BlogPage extends BasePage{
    private static final String blog_heading = "//h1[text() = 'Blog']";
    public boolean isHeadingVisible() {
        return elementExists(blog_heading);
    }
}
