package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CheckBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void executeTreeFlow() throws InterruptedException {
        // Expand Root Home folder
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'rc-tree-switcher')]"))).click();

        // Get immediate children under home (Desktop, Documents, Downloads)
        List<WebElement> homeBoxes = driver.findElements(By.xpath("//*[@class='rc-tree-switcher rc-tree-switcher_close']"));

        // 1. Expand Desktop folder
        homeBoxes.get(0).click();

        // Wait for elements to step out of hidden CSS state and click them
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='Select Notes']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='Select Commands']"))).click();

        // 2. Expand Documents folder
        homeBoxes.get(1).click();

        // Target document sub-folders
        List<WebElement> docBoxes = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//span[contains(@class,'rc-tree-switcher rc-tree-switcher_close')]"), 1));

        // Expand Workspace folder
        docBoxes.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='Select Angular']"))).click();

        // Expand Office folder
        docBoxes.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='Select Public']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='Select Private']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='Select General']"))).click();

        // 3. Handle Downloads expansion cleanly
        WebElement downloadToggle = driver.findElement(
                By.xpath("//span[@aria-label='Select Downloads']/preceding-sibling::span[1]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadToggle);
        Thread.sleep(500);
        downloadToggle.click();

        // Click final Word Doc target
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-label='Select Word File.doc']"))).click();
    }
}