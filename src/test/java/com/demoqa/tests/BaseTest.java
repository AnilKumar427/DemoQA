package com.demoqa.tests;

import com.demoqa.factory.BrowserFactory;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@org.testng.annotations.Optional String xmlBrowser) {
        // 1. Mute warnings
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.SEVERE);

        String targetBrowser;

        // 2. Priority Logic: If XML has a browser parameter, use it. Otherwise, read from Config.properties
        if (xmlBrowser != null && !xmlBrowser.isEmpty()) {
            targetBrowser = xmlBrowser;
            System.out.println("[INFO] Launching browser from TestNG XML: " + targetBrowser);
        } else {
            // Fallback to your ConfigReader utility class
            targetBrowser = ConfigReader.getProperty("browser");
            System.out.println("[INFO] Launching browser from Config.properties: " + targetBrowser);
        }

        // 3. Initialize the driver instance cleanly
        driver = BrowserFactory.createDriverInstance(targetBrowser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}