import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import Pages.EnglishLanguagePage;
import Pages.MainPage;
import Pages.TestingBookPage;
import Utilities.UseCaseBase;

public class AddToCartTest extends UseCaseBase{
    private static MainPage mainPage;
    private static EnglishLanguagePage englishLanguagePage;
    private static TestingBookPage testingBookPage;
    private static final Logger LOGGER = LogManager.getLogger(AddToCartTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        englishLanguagePage = new EnglishLanguagePage();
        testingBookPage = new TestingBookPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

}
