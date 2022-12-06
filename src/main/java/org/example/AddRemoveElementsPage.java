package org.example;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class AddRemoveElementsPage {
    private static final String URI = "http://the-internet.herokuapp.com/add_remove_elements/";
    private final WebDriver webDriver;

    public AddRemoveElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "[onclick]")
    public WebElement addButton;

    @FindBy(css = "[class=\"added-manually\"]")
    public List<WebElement> elementsAdded;

    public void addElements(int number) {
        for (int i = 0; i < number; i++) {
            addButton.click();
        }
    }

    public boolean newElementsNumberEquals(int number) {
        return elementsAdded.size() == number;
    }
}


