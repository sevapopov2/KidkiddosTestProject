package Pages;

public class TestingBookPage extends BasePage{
    private static final String BOOKS_HEADING = "//h1[contains(text(), 'Dream')]";
    private static final String ADD_TO_CART_BUTTON = "//button[text() = 'ADD TO CART']";

    public boolean isHeadingVisible() {
        return elementExists(BOOKS_HEADING);
    }

    public void addToCart() {
        clickElementByXpath(ADD_TO_CART_BUTTON);
    }

}
