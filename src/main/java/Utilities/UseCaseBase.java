package Utilities;

import java.util.List;
import java.util.logging.Level;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import Pages.BasePage;

public class UseCaseBase {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = SharedDriver.getWebDriver(SharedDriver.Browser.CHROME);
        page.setWebDriver(webDriver);
    }

    @AfterAll
    public static void tearDownMain() {
        SharedDriver.closeDriver();
        webDriver = null;
    }

    @Test
    public void logsImplement() {
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List <LogEntry> logs = entries.getAll();
        for (LogEntry e : logs) {
            System.out.println(e.getMessage());
            System.out.println(e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
        }
    }
}
