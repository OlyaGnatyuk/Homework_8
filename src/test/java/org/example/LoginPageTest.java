package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@Slf4j
public class LoginPageTest {
    LoginPage loginPage;
    LoginResultPage loginResultPage;
    WebDriver webDriver;

    @Before
    public void initialize() {
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void testFormAuthenticationWithCorrectCredentials() {
        loginPage.fillUsername("tomsmith");
        loginPage.fillPassword("SuperSecretPassword!");
        loginPage.submitLogin();
        loginResultPage = new LoginResultPage(webDriver);

        Assert.assertTrue(loginResultPage.isPageWithCorrectCredentialsOpened());
    }

    @Test
    public void testFormAuthenticationWithIncorrectCredentials() {
        loginPage.fillUsername("username");
        loginPage.fillPassword("password");
        loginPage.submitLogin();
        loginResultPage = new LoginResultPage(webDriver);

        Assert.assertTrue(loginResultPage.isPageWithIncorrectCredentialsOpened());
    }

    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}