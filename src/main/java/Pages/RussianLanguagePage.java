package Pages;

public class RussianLanguagePage extends BasePage{
    public static final String russian_language_heading = "//h1[text() = 'Russian - Русский']";

    public boolean isHeadingVisible() {
        return elementExists(russian_language_heading);
    }

}
