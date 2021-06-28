import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.SignUpPage;
import Utilities.UseCaseBase;

public class SignUpPageTest extends UseCaseBase{
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static SignUpPage signUpPage;
    private static final Logger LOGGER = LogManager.getLogger(SignUpPageTest.class);

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
        mainPage.openLoginPage();
        loginPage.openSignUpPage();
    }

    @Test
    public void signUpTest() {
        LOGGER.info("Sign Up test.");
        String firstName = signUpPage.firstNameField("Vsevolod");
        assertEquals("Vsevolod", firstName);
        String lastName = signUpPage.lastNameField("Popov");
        assertEquals("Popov", lastName);
        String eMail = signUpPage.emailField("sevapopov13@gmail.com");
        assertEquals("sevapopov13@gmail.com", eMail);
        String password = signUpPage.passwordField("testP123456");
        assertEquals("testP123456", password);
        signUpPage.createButton();
    }

}
