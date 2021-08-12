import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Pages.ContactUsPage;
import Pages.MainPage;
import Utilities.UseCaseBase;

public class ContactPageTest extends UseCaseBase{
    private static ContactUsPage contactUsPage;
    private static MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(ContactPageTest.class);

    @BeforeAll
    public static void classSetup() {
        contactUsPage = new ContactUsPage();
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
        mainPage.openContactUsPage();
    }

    @Test
    public void nameFieldTest() {
        logger.info("Name field checking: ");
        String name = contactUsPage.nameField("");
        assertNotNull(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Vsevolod", "", "Всеволод", "V",})
    public void nameFieldParamsTest(String names) {
        logger.info("Name field parameterized test.");
        String name = contactUsPage.nameField(names);
        assertNotNull(name);
    }

    @Test
    public void emailTest() {
        logger.info("Email checking: ");
        String eMail = contactUsPage.emailField("seva@test.com");
        assertNotNull(eMail);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1kv@mail.ru", "seva@da.net", "thelongestemailintheworldibelieve@gmail.com"})
    public void emailParamsTest(String eMails) {
        logger.info("Using the parameterized testing for the eMail field: ");
        String eMail = contactUsPage.emailField(eMails);
        assertNotNull(eMail);
    }

    @Test
    public void logsTest() {
        mainPage.logsOutput();
    }
}
