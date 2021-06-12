import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Pages.ContactUsPage;
import Pages.MainPage;
import Utilities.UseCaseBase;

public class ContactPageTest extends UseCaseBase{
    private static ContactUsPage contactUsPage;
    private static MainPage mainPage;
    private static Logger logger = LogManager.getLogger(ContactPageTest.class);

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

    @Test
    public void emailTest() {
        logger.info("Email checking: ");
        String eMail = contactUsPage.emailField("seva@test.com");
        assertNotNull(eMail);
    }
}
