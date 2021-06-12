import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Pages.ContactUsPage;
import Pages.MainPage;
import Pages.RussianLanguagePage;
import Pages.spanishLanguagePage;
import Utilities.UseCaseBase;

public class mainPageTest extends UseCaseBase{
    private static MainPage mainPage;
    private static Logger logger = LogManager.getLogger(mainPageTest.class);

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
    public void russianLanguageLoadTest() {
        logger.info("Russian language link click test");
        RussianLanguagePage russianLanguagePage = mainPage.russianLanguageClick();
        boolean isHeadingVisible = russianLanguagePage.isHeadingVisible();
        assertTrue(isHeadingVisible);
    }

    @Test
    public void spanishLanguageTest() {
        logger.info("Spanish language page visibility test");
        spanishLanguagePage spanishLanguagePage = mainPage.spanishLanguageClick();
        boolean isHeadingVisible = spanishLanguagePage.isHeadingVisible();
        assertTrue(isHeadingVisible);
    }

    @Test
    public void openContactPageTest() {
        logger.info("Checking the contatct us page test");
        ContactUsPage contactUsPage = mainPage.openContactUsPage();
        boolean isLoaded = contactUsPage.isHeadingVisible();
        assertTrue(isLoaded);
    }
}
