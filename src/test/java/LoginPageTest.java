import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Pages.LoginPage;
import Pages.MainPage;
import Utilities.UseCaseBase;

public class LoginPageTest extends UseCaseBase{
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

    @BeforeAll
    public static void classSetup() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
        mainPage.openLoginPage();
    }

    @Test
    public void emailField() {
        logger.info("eMail field test : ");
        String eMail = loginPage.emailField("sevapopov13@gmail.com");
        assertEquals("sevapopov13@gmail.com", eMail);
    }

    @Test
    public void passwordField() {
        String password = loginPage.passwordField("testP123456");
        assertEquals("testP123456", password);
    }

    @Test
    public void loginTest() {
        loginPage.emailField("sevapopov13@gmail.com");
        loginPage.passwordField("testP123456");
        loginPage.signInButton();
    }
}
