package io.qase.page_element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QaseSelect {

    private final WebDriver driver;
    private final By selfLocator;
    private final By optionsXpath = By.xpath(".//*[contains(@id, 'option')]");


    public QaseSelect(WebDriver driver, By selfLocator) {
        this.driver = driver;
        this.selfLocator = selfLocator;
    }

    public void selectByVisibleText(String text) {
        WebElement self = driver.findElement(selfLocator);
        WebElement menuElement = self.findElement(By.xpath("./div"));
        menuElement.click();

        List<WebElement> options = self.findElements(optionsXpath);
        WebElement targetOption = null;
        for (WebElement element :
                options) {
            if (element.getText().contains(text)) {
                targetOption = element;
            }
        }
        targetOption.click();
    }

}
