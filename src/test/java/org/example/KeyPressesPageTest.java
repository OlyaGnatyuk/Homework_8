package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Slf4j
public class KeyPressesPageTest {
    KeyPressesPage keyPressesPage;
    WebDriver webDriver;

    @Before
    public void initialize() {
        webDriver = new ChromeDriver();
        keyPressesPage = new KeyPressesPage(webDriver);
    }

    @Test
    public void testPressKey() {
        keyPressesPage.clickOnInput();
        keyPressesPage.pressKey();
        keyPressesPage.waitFinishTextShown();

        Assert.assertTrue(keyPressesPage.isKeyPressed());
    }

    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}