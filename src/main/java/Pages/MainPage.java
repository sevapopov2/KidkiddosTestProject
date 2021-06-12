package Pages;

import Consts.Consts;

public class MainPage extends BasePage{
    private static final String skip_Link = "//a[text() = 'Skip to content']";
    private static final String books_by_language = "//a[@aria-controls='SiteNavLabel-books-by-language']";
    private static final String eBooks_by_language = "//a[@aria-controls='SiteNavLabel-ebooks-by-language']";
    private static final String russian_language = "//*[@aria-controls='SiteNavLabel-books-by-language']//following-sibling::*//a[text() = 'Russian - Русский']";
    private static final String spanish_language = "//*[@aria-controls='SiteNavLabel-ebooks-by-language']//following-sibling::*//a[text() = 'Spanish - Español']";
    private static final String contact_us_page = "//a[text() = 'Contact us']";

    public void navigateToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isSkipLinkAvailable() {
        boolean isVisible = elementExists(skip_Link);
        return isVisible;
    }

    public RussianLanguagePage russianLanguageClick() {
        clickElementByXpath(books_by_language);
        clickElementByXpath(russian_language);
        return new RussianLanguagePage();
    }

    public spanishLanguagePage spanishLanguageClick() {
        clickElementByXpath(eBooks_by_language);
        clickElementByXpath(spanish_language);
        return new spanishLanguagePage();
    }

    public ContactUsPage openContactUsPage() {
        clickElementByXpath(contact_us_page);
        return new ContactUsPage();
    }
}
