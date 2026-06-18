package com.demoqa.tests;

import com.demoqa.pages.RadioButtonPage;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {
    @Test
    public void testRadioSelections() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/radio-button");
        RadioButtonPage radioPage = new RadioButtonPage(driver);

        radioPage.clickYesRadio();
        Assert.assertTrue(radioPage.getConfirmationText().contains("Yes"));

        radioPage.clickImpressiveRadio();
        Assert.assertTrue(radioPage.getConfirmationText().contains("Impressive"));
        Assert.assertTrue(radioPage.isNoRadioDisabled());
    }
}