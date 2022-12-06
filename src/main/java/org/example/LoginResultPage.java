package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginResultPage {
    private final WebDriver webDriver;

    @FindBy(css = "[id=\"flash\"]")
    private WebElement resultMessage;

    public LoginResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageWithCorrectCredentialsOpened() {
        return resultMessage.getText().contains("You logged into a secure area!");
    }

    public boolean isPageWithIncorrectCredentialsOpened() {
        return resultMessage.getText().contains("Your username is invalid!");
    }
}
