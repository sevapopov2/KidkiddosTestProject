package Pages;

public class SignUpPage extends BasePage{
    private static final String sign_up_heading = "//h1[text() = 'Create Account']";
    private static final String first_name_field = "//input[@id='FirstName']";
    private static final String last_name_field = "//input[@id='LastName']";
    private static String email_field = "//input[@id='Email']";
    private static final String password_field = "//input[@type='password']";
    private static final String create_button = "//input[@type='submit']";

    public boolean isHeadingVisible() {
        return elementExists(sign_up_heading);
    }

    public String firstNameField(String firstName) {
        sendTextToElementByXpath(first_name_field, firstName);
        return findElementByXpath(first_name_field).getAttribute("value");
    }

    public String lastNameField(String lastName) {
        sendTextToElementByXpath(last_name_field, lastName);
        return findElementByXpath(last_name_field).getAttribute("value");
    }

    public String emailField(String eMail) {
        sendTextToElementByXpath(email_field, eMail);
        return findElementByXpath(email_field).getAttribute("value");
    }

    public String passwordField(String password) {
        sendTextToElementByXpath(password_field, password);
        return findElementByXpath(password_field).getAttribute("value");
    }

    public void createButton() {
        clickElementByXpath(create_button);
    }

}
