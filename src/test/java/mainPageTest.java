import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Pages.BlogPage;
import Pages.ContactUsPage;
import Pages.EnglishLanguagePage;
import Pages.FAQsPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ResourcesPage;
import Pages.RussianLanguagePage;
import Pages.SignUpPage;
import Pages.SpanishLanguagePage;
import Pages.TestingBookPage;
import Utilities.UseCaseBase;

public class mainPageTest extends UseCaseBase{
    private static MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(mainPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadTest() {
        logger.info("Main page load test");
        boolean success = mainPage.isSkipLinkAvailable();
        assertTrue(success);
    }

    @Test
    public void englishLanguageLoadTest() {
        EnglishLanguagePage englishLanguagePage = mainPage.englishLanguageClick();
        boolean success = englishLanguagePage.isHeadingVisible();
        assertTrue(success);
    }

    @Test
    public void russianLanguageLoadTest() {
        logger.info("Russian language link click test");
        RussianLanguagePage russianLanguagePage = mainPage.russianLanguageClick();
        boolean success = russianLanguagePage.isHeadingVisible();
        assertTrue(success);
    }

    @Test
    public void spanishLanguageLoadTest() {
        logger.info("Spanish language page visibility test");
        SpanishLanguagePage spanishLanguagePage = mainPage.spanishLanguageClick();
        boolean success = spanishLanguagePage.isHeadingVisible();
        assertTrue(success);
    }

    @Test
    public void resourcesPageTest() {
        logger.info("Openning resources page: ");
        ResourcesPage resourcesPage = mainPage.openResourcesPage();
        boolean success = resourcesPage.isHeadingVisible();
        assertTrue(success);
    }

    @Test
    public void faqPageTest() {
        logger.info("Testing the FAQs' page.");
        FAQsPage faQsPage = mainPage.openFaQsPage();
        boolean success = faQsPage.isHeadingVisible();
        assertTrue(success);
    }

    @Test
    public void blogPageTest() {
        logger.info("Trying to open blogs page: ");
        BlogPage blogPage = mainPage.openBlogPage();
        boolean success = blogPage.isHeadingVisible();
        assertTrue(success);
    }

    @Test
    public void openContactPageTest() {
        logger.info("Checking the contact us page test");
        ContactUsPage contactUsPage = mainPage.openContactUsPage();
        boolean isLoaded = contactUsPage.isHeadingVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openLoginPageTest() {
        logger.info("LogIn page open test: ");
        LoginPage loginPage = mainPage.openLoginPage();
        boolean isLoaded = loginPage.isHeadingVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void openSignUpPageTest() {
        LoginPage loginPage = mainPage.openLoginPage();
        SignUpPage signUpPage = loginPage.openSignUpPage();
        boolean isLoaded = signUpPage.isHeadingVisible();
        assertTrue(isLoaded);
    }

    @Test
    public void bookOpenTest() {
        EnglishLanguagePage englishLanguagePage = mainPage.englishLanguageClick();
        TestingBookPage testingBookPage = englishLanguagePage.openTestingBook();
        boolean success = testingBookPage.isHeadingVisible();
        assertTrue(success);
    }
}
