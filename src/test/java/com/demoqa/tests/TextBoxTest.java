package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    @Test
    public void testTextBoxSubmission() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/text-box");
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillForm("Albert Einstein", "albert001@gmail.com",
                "112 Mercer Street, Princeton, NJ", "112 Mercer Street, Princeton");
        Assert.assertTrue(textBoxPage.isOutputDisplayed());
    }
}