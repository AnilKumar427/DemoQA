package com.demoqa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.demoqa.utils.ConfigReader;

public class BrowserFactory {

    public static WebDriver createDriverInstance(String browser) {
        WebDriver driver;

        // 1. Fetch the headless setting from config.properties dynamically
        // (Defaults to false if the key is missing or blank)
        // Example if your class is named differently:
        String headlessProp = ConfigReader.getProperty("headless");   boolean isHeadless = headlessProp != null && headlessProp.equalsIgnoreCase("true");

        switch (browser.toLowerCase().trim()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new"); // Modern headless argument
                    chromeOptions.addArguments("--window-size=1920,1080"); // Fixes element sizing issues in headless
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
            case "ff":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("-headless"); // Firefox uses a single hyphen flag
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("❌ Unsupported browser: " + browser);
        }

        return driver;
    }
}