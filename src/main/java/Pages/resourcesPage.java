package Pages;

public class resourcesPage extends BasePage{
    private static final String videos_heading = "//h1[contains(text(), 'Fun ')]";

    public boolean isHeadingVisible() {
        return elementExists(videos_heading);
    }
}
