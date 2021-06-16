package Pages;

public class LoginPage extends BasePage{
    private static final String login_heading = "//h1[text() = 'Login']";
    private static final String email_field = "//input[@type='email']";
    private static final String password_field = "//input[@type='password']";
    private static final String sign_up_link = "//a[text() = 'Create account']";
    private static String sign_in_button = "//input[@type='submit']";

    public boolean isHeadingVisible() {
        return elementExists(login_heading);
    }

    public String emailField(String eMail) {
        sendTextToElementByXpath(email_field, eMail);
        return findElementByXpath(email_field).getAttribute("value");
    }

    public String passwordField(String password) {
        sendTextToElementByXpath(password_field, password);
        return findElementByXpath(password_field).getAttribute("value");
    }

    public void signInButton() {
        clickElementByXpath(sign_in_button);
    }

    public SignUpPage openSignUpPage() {
        clickElementByXpath(sign_up_link);
        return new SignUpPage();
    }

}
