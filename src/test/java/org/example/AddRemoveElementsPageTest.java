package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Slf4j
public class AddRemoveElementsPageTest {
    private static final int NUMBER_OF_ELEMENTS = 10;

    AddRemoveElementsPage addRemoveElementsPage;
    WebDriver webDriver;

    @Before
    public void initialize() {
        webDriver = new ChromeDriver();
        addRemoveElementsPage = new AddRemoveElementsPage(webDriver);
    }

    @Test
    public void testAddRemoveElements() {
        addRemoveElementsPage.addElements(NUMBER_OF_ELEMENTS);

        Assert.assertTrue(addRemoveElementsPage.newElementsNumberEquals(NUMBER_OF_ELEMENTS));
    }

    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}