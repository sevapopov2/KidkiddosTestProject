package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SharedDriver {
    private static WebDriver webDriver;

    public enum Browser {
        CHROME,
        FIREFOX
    }

    protected static WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            break;
            case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
            break;
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return webDriver;
    }

    protected static void closeDriver() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
