package com.demoqa.tests;

import com.demoqa.pages.DynamicPropertiesPage;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropsTest extends BaseTest {
    @Test
    public void testDynamicDelays() {
        driver.get(ConfigReader.getProperty("baseUrl") + "/dynamic-properties");
        DynamicPropertiesPage dynamicPage = new DynamicPropertiesPage(driver);

        Assert.assertTrue(dynamicPage.waitForElementVisibility());
        Assert.assertTrue(dynamicPage.waitForButtonClickable());
        Assert.assertTrue(dynamicPage.waitForColorMutation());
    }
}