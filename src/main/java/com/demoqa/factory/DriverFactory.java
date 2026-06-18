package com.demoqa.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    // ThreadLocal ensures thread-safe execution during parallel testing
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Prevents memory leaks in ThreadLocal map
        }
    }
}