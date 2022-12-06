package org.example;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class DynamicLoadingPage {
    private static final int TIME_OUT_IN_SECONDS = 30;
    private static final int SLEEP_IN_MILLIS = 500;
    private static final String URI = "http://the-internet.herokuapp.com/dynamic_loading/2";
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public DynamicLoadingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS, SLEEP_IN_MILLIS);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "button")
    public WebElement submitStart;

    @FindBy(css = "[id=\"finish\"]")
    private WebElement resultMessage;

    public void submitStart() {
        Actions actions = new Actions(webDriver);
        actions.click(submitStart)
                .perform();
    }

    public boolean isLoadingCompleted() {
        return resultMessage.getText().contains("Hello World!");
    }

    public void waitFinishTextShown() {
        webDriverWait.until(ExpectedConditions.visibilityOf(resultMessage));
    }
}


