package org.example;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class HoversPage {
    private static final String URI = "http://the-internet.herokuapp.com/hovers";
    private final WebDriver webDriver;

    public HoversPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[alt=\"User Avatar\"]")
    public List<WebElement> userAvatars;

    @FindBy(css = "[class=\"figcaption\"]")
    public List<WebElement> userCaptions;

    public void hoverSecondUserAvatar() {
        WebElement secondAvatar = userAvatars.get(1);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(secondAvatar).perform();
    }

    public boolean isSecondFigcaptionTextDisplayed() {
        if (!userCaptions.isEmpty()) {
            return userCaptions.get(1).isDisplayed();
        }

        return false;
    }

    public String getSecondFigcaptionText() {
        if (!userCaptions.isEmpty()) {
            return userCaptions.get(1).getText();
        }

        return null;
    }
}


