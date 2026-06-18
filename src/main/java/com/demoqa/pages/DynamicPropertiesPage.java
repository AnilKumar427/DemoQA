package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicPropertiesPage extends BasePage {

    @FindBy(id = "enableAfter") private WebElement interactiveDelayedBtn;
    @FindBy(id = "colorChange") private WebElement textDangerColorBtn;
    @FindBy(id = "visibleAfter") private WebElement visibleDelayedBtn;

    public DynamicPropertiesPage(WebDriver driver) { super(driver); }

    public boolean waitForButtonClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(interactiveDelayedBtn)).isEnabled();
    }

    public boolean waitForColorMutation() {
        return wait.until(ExpectedConditions.attributeContains(textDangerColorBtn, "class", "text-danger"));
    }

    public boolean waitForElementVisibility() {
        return wait.until(ExpectedConditions.visibilityOf(visibleDelayedBtn)).isDisplayed();
    }
}