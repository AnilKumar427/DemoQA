package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    @FindBy(id = "userName") private WebElement userNameInput;
    @FindBy(id = "userEmail") private WebElement userEmailInput;
    @FindBy(id = "currentAddress") private WebElement currentAddressInput;
    @FindBy(id = "permanentAddress") private WebElement permanentAddressInput;
    @FindBy(id = "submit") private WebElement submitBtn;
    @FindBy(id = "output") private WebElement outputArea;

    public TextBoxPage(WebDriver driver) { super(driver); }

    public void fillForm(String name, String email, String currentAddr, String permAddr) {
        userNameInput.sendKeys(name);
        userEmailInput.sendKeys(email);
        currentAddressInput.sendKeys(currentAddr);
        permanentAddressInput.sendKeys(permAddr);
        scrollCenterAndClick(submitBtn);
    }

    public boolean isOutputDisplayed() { return outputArea.isDisplayed(); }
}