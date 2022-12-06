package org.example;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginPage {
    private static final String URI = "http://the-internet.herokuapp.com/login";
    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[id=\"username\"]")
    public WebElement usernameInput;

    @FindBy(css = "[id=\"password\"]")
    public WebElement passwordInput;

    @FindBy(css = "button")
    public WebElement submitLogin;

    public void fillUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void submitLogin() {
        submitLogin.click();
    }

}
