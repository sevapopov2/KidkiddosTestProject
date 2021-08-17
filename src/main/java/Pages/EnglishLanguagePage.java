package Pages;

public class EnglishLanguagePage extends BasePage{
    private static final String ENGLISH_LANGUAGE_HEADING = "//h1[text() ='English Only']";
    private static final String TESTING_BOOK = "//a[contains(text(), 'Dream')]";

    public boolean isHeadingVisible() {
        return elementExists(ENGLISH_LANGUAGE_HEADING);
    }

    public TestingBookPage openTestingBook() {
        clickElementByXpath(TESTING_BOOK);
        return new TestingBookPage();
    }

}
