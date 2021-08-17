package Pages;

import Consts.Consts;

public class MainPage extends BasePage{
    private static final String skip_Link = "//a[text() = 'Skip to content']";
    private static final String books_by_language = "//a[@aria-controls='SiteNavLabel-books-by-language']";
    private static final String eBooks_by_language = "//a[@aria-controls='SiteNavLabel-ebooks-by-language']";
    private static final String ENGLISH_LANGUAGE = "//a[text() = 'English Only']";
    private static final String russian_language = "//a[text() = 'Russian - Русский']";
    private static final String spanish_language = "//a[text() = 'Spanish - Español']";
    private static final String resources_link = "//a[@aria-controls='SiteNavLabel-resources']";
    private static final String faqs_page = "//a[text() = 'FAQs']";
    private static final String blog_page = "//*[text() = 'Blog']";
    private static final String contact_us_page = "//a[text() = 'Contact us']";
    private static final String login_page = "//*[@class='icon icon-login']";
    private static final String LOGO = "//*[alt='KidKiddos Books']";

    public void navigateToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isSkipLinkAvailable() {
        boolean isVisible = elementExists(skip_Link);
        return isVisible;
    }

    public EnglishLanguagePage englishLanguageClick() {
        clickElementByXpath(books_by_language);
        clickElementByRelativeLocator(ENGLISH_LANGUAGE, findElementByXpath(books_by_language), 200);
        return new EnglishLanguagePage();
    }

    public RussianLanguagePage russianLanguageClick() {
        clickElementByXpath(books_by_language);
        clickElementByRelativeLocator(russian_language, findElementByXpath(books_by_language), 200);
        return new RussianLanguagePage();
    }

    public SpanishLanguagePage spanishLanguageClick() {
        clickElementByXpath(eBooks_by_language);
        clickElementByRelativeLocator(spanish_language, findElementByXpath(eBooks_by_language), 200);
        return new SpanishLanguagePage();
    }



    public ResourcesPage openResourcesPage() {
        clickElementByXpath(resources_link);
        clickElementByXpath(resources_link);
        return new ResourcesPage();
    }

    public FAQsPage openFaQsPage() {
        clickElementByXpath(faqs_page);
        return new FAQsPage();
    }

    public BlogPage openBlogPage() {
        clickElementByXpath(blog_page);
        return new BlogPage();
    }

    public ContactUsPage openContactUsPage() {
        clickElementByXpath(contact_us_page);
        return new ContactUsPage();
    }

    public LoginPage openLoginPage() {
        clickElementByXpath(login_page);
        return new LoginPage();
    }

    public void logoCapturing() {
        captureElement(LOGO, "logo");
    }

}
