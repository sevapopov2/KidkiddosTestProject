package Pages;

public class FAQsPage extends BasePage{
    private static final String info_heading = "//h1[contains(text(), 'FAQ/']";

    public boolean isHeadingVisible() {
        return elementExists(info_heading);
    }
}
