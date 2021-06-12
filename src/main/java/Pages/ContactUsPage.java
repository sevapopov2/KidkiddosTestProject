package Pages;

public class ContactUsPage extends BasePage{
    private static final String contact_us_heading = "//h1[text() = 'Contact us']";
    private static final String first_name_field = "//input[@data-name='first_name']";
    private static final String email_field = "//input[@data-name='email']";
    private static final String sendMessageButton = "//button[text() = 'Send your message']";

    public boolean isHeadingVisible() {
        return elementExists(contact_us_heading);
    }

    public String nameField(String name) {
        sendTextToElementByXpath(first_name_field, name);
        return findElementByXpath(first_name_field).getText();
    }

    public String emailField(String eMail) {
        sendTextToElementByXpath(email_field, eMail);
        return findElementByXpath(email_field).getText();
    }

}
