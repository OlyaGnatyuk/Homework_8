package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HoversPageTest {
    HoversPage hoversPage;
    WebDriver webDriver;

    @Before
    public void initialize() {
        webDriver = new ChromeDriver();
        hoversPage = new HoversPage(webDriver);
    }

    @Test
    public void testHoverSecondAvatar() {
        hoversPage.hoverSecondUserAvatar();
        Assert.assertTrue(hoversPage.isSecondFigcaptionTextDisplayed());
    }

    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}