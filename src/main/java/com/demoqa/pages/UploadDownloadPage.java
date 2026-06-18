package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadDownloadPage extends BasePage {

    @FindBy(id = "downloadButton") private WebElement downloadBtn;
    @FindBy(id = "uploadFile") private WebElement uploadInputHidden;
    @FindBy(id = "uploadedFilePath") private WebElement confirmationLabel;

    public UploadDownloadPage(WebDriver driver) { super(driver); }

    public void triggerDownload() { downloadBtn.click(); }
    public void performUpload(String path) { uploadInputHidden.sendKeys(path); }
    public String getUploadConfirmationText() { return confirmationLabel.getText(); }
}