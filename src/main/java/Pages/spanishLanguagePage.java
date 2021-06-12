package Pages;

public class spanishLanguagePage extends BasePage{
    public static final String spanishLanguageHeading = "//h1[text() = 'Spanish - Español']";
    public boolean isHeadingVisible() {
        return elementExists(spanishLanguageHeading);
    }
}
