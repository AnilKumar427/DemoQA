package com.demoqa.tests;

import com.demoqa.pages.LinksPage;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {
    @Test
    public void testWindowNavigationAndMockApiLinks() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/links");
        LinksPage linksPage = new LinksPage(driver);

        String tabTitle = linksPage.followSimpleLinkAndGetTitle();
        Assert.assertFalse(tabTitle.isEmpty());

        linksPage.clickApiLink("created");
        Assert.assertTrue(linksPage.getApiResponsePanelText().contains("201"));
    }
}