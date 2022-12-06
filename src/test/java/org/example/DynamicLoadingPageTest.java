package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Slf4j
public class DynamicLoadingPageTest {
    DynamicLoadingPage dynamicLoadingPage;
    WebDriver webDriver;

    @Before
    public void initialize() {
        webDriver = new ChromeDriver();
        dynamicLoadingPage = new DynamicLoadingPage(webDriver);
    }

    @Test
    public void testDynamicLoading() {
        dynamicLoadingPage.submitStart();
        dynamicLoadingPage.waitFinishTextShown();

        Assert.assertTrue(dynamicLoadingPage.isLoadingCompleted());
    }

    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}