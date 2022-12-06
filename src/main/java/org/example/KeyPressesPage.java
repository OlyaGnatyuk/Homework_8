package org.example;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class KeyPressesPage {
    private static final int TIME_OUT_IN_SECONDS = 30;
    private static final int SLEEP_IN_MILLIS = 500;
    private static final String URI = "http://the-internet.herokuapp.com/key_presses";
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public KeyPressesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);
        webDriverWait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS, SLEEP_IN_MILLIS);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[id=\"target\"]")
    public WebElement keyInput;

    @FindBy(css = "[id=\"result\"]")
    private WebElement resultMessage;

    public void clickOnInput() {
        keyInput.click();
    }

    public void pressKey() {
        Actions actions = new Actions(webDriver);
        actions.sendKeys(Keys.TAB)
                .perform();
    }

    public boolean isKeyPressed() {
        return resultMessage.getText().contains("TAB");
    }

    public void waitFinishTextShown() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
    }
}


