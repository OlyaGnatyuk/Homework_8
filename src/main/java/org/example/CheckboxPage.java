package org.example;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class CheckboxPage {
    private static final String URI = "http://the-internet.herokuapp.com/checkboxes";
    private final WebDriver webDriver;

    public CheckboxPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[type=\"checkbox\"]")
    public List<WebElement> checkboxes;

    public void clickFirstCheckbox() {
        if (!checkboxes.isEmpty()) {
            WebElement webElement = checkboxes.get(0);
            log.info("Чекбокс выбран: {}", webElement.isSelected());
            webElement.click();
            log.info("Чекбокс выбран: {}", webElement.isSelected());
        }
    }
}


