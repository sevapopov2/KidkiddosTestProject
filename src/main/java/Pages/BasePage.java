package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static Logger logger = LogManager.getLogger(BasePage.class);
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
    }

    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected void clickElementByXpath(String xpath) {
        logger.info("Clicking element by xpath: " + xpath);
        findElementByXpath(xpath).click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }

    protected boolean elementExists(String xpath) {
        try {
            logger.info("Checking if xpath element exists: " + xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        }
        catch (Exception err) {
            return false;
        }
    }

    protected String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
