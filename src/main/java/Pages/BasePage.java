package Pages;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static Logger logger = LogManager.getLogger(BasePage.class);
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
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
            findElementByXpath(xpath);
            return true;
        }
        catch (Exception err) {
            return false;
        }
    }

    protected String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void takeScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected WebElement findElementByRelativeLocators(String xpath, WebElement locatorName) {
        WebElement element;
        element = wait.until(ExpectedConditions.presenceOfElementLocated(with(By.xpath(xpath)).near(locatorName)));
        return element;
    }

    protected void clickElementByRelativeLocator(String xpath, WebElement locatorName) {
        findElementByRelativeLocators(xpath, locatorName).click();
    }

    protected void sendTextToElementByLocator(String xpath, WebElement locatorName, String text) {
        findElementByRelativeLocators(xpath, locatorName).sendKeys(text);
    }

    protected void logsImplement() {
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List <LogEntry> logs = entries.getAll();
        for (LogEntry e : logs) {
            e.getMessage();
            e.getLevel();
        }
    }

}
