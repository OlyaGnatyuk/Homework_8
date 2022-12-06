package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@Slf4j
public class CheckboxPageTest {
    CheckboxPage checkboxPage;
    WebDriver webDriver;

    @Test
    public void testCheckboxChecked() {
        webDriver = new ChromeDriver();
        checkboxPage = new CheckboxPage(webDriver);

        WebElement firstCheckbox = checkboxPage.checkboxes.get(0);
        Assert.assertFalse(firstCheckbox.isSelected());
        checkboxPage.clickFirstCheckbox();
        Assert.assertTrue(firstCheckbox.isSelected());
    }

    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}